package cn.com.shukaiken.webService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.xfire.transport.http.XFireServletController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.shukaiken.model.Editor;
import cn.com.shukaiken.model.EditorImg;
import cn.com.shukaiken.service.IEditorImgService;
import cn.com.shukaiken.service.IEditorService;
import cn.com.shukaiken.util.ConfigurationUtils;
import cn.com.shukaiken.util.DateTimeUtils;
import cn.com.shukaiken.util.JSONHelper;
import cn.com.shukaiken.util.JacksonHelper;
import cn.com.shukaiken.util.PagerHelper;
import cn.com.shukaiken.util.UploadImageUtil;
import cn.com.shukaiken.webService.IAppEditorWebService;
@Service
public class AppEditorWebServiceImpl implements IAppEditorWebService {
	
	@Resource
	private IEditorService editorService;
	
	@Resource
	private IEditorImgService imgService;

	private Logger logger = LoggerFactory.getLogger(AppEditorWebServiceImpl.class);
	/**
	 * 添加现场采编信息
	 * @param jsonStr为 用户名id、内容、图片data:经过base64加密的Lsit<byte[]>(byte[]由上传的图片File得来）的json字符串
	 *        主键分别为 cust_id、 content和  data
	 * @return
	 */
	@Override
	public String addEditor(String jsonStr) {
		Map<String, Object> map = new HashMap<String,Object>();
	    if(jsonStr != null && jsonStr.length() > 0) {
	      map = JSONHelper.getMapByJson(jsonStr);
	      String savePath = "";
	      
	      String fileName = "";
	      HttpServletRequest request = XFireServletController.getRequest();
	      String requestURL = request.getRequestURL().toString();
		  String servletPath = request.getServletPath();
		  //String appURL = requestURL.substring(0, requestURL.indexOf(servletPath));
		  String appURL = ConfigurationUtils.readValue("info.images.server.path", "config.properties");
	      //String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
	      String path = appURL + ConfigurationUtils.readValue("info.images.access.path", "config.properties")+ DateTimeUtils.customDateTime(new Date(),"yyyyMMdd" ) + "/";
	      logger.error("采编图像，服务器映射地址为:"+path);
	      logger.error("请求地址为:"+request.getRequestURI());
	      String osname = System.getProperty("os.name");
	      if (osname.toLowerCase().indexOf("linux") > -1){
	    	  savePath = ConfigurationUtils.readValue("linux.info.images.upload.path", "config.properties")+ DateTimeUtils.customDateTime(new Date(),"yyyyMMdd" ) + "/";
	      }
	      else if (osname.toLowerCase().indexOf("windows") > -1){
	    	  savePath = ConfigurationUtils.readValue("windows.info.images.upload.path", "config.properties")+ DateTimeUtils.customDateTime(new Date(),"yyyyMMdd" ) + "\\";
	      }
	      String custId = map.get("cust_id").toString();
	      String content =  map.get("content").toString();
	      String data = map.get("data").toString();
	      map = new HashMap<String,Object>();
			if (custId != null && !custId.equals("")) {
				
			}else{
				map.put("result", "002");
				map.put("message", "传递的用户id为空");
				return JSONHelper.getJsonByMap(map);
			}
			
			if (content != null && !content.equals("")) {
				
			}else{
				map.put("result", "003");
				map.put("message", "传递的采编内容为空");
				return JSONHelper.getJsonByMap(map);
			}
	      
			List<String> imgStrLs = new ArrayList<String>();
			if(data!=null&&data.length()>0){
				imgStrLs = JSONHelper.getListByJsonString(data);
			}else{
				  map.put("result", "004");
			      map.put("message", "传递的data为空");
			      return JSONHelper.getJsonByMap(map); 
			}
			
			
			List<String> fileNameLs = new ArrayList<String>();
			if(imgStrLs!=null&&imgStrLs.size()>0){
				for(int i=0;i<imgStrLs.size();i++){
					byte[] b = UploadImageUtil.decode(imgStrLs.get(i));
					fileName = DateTimeUtils.customDateTime(new Date(), "yyyyMMddHHmmss") + "_head_" + new Random().nextInt(1000000) + ".jpg";
					String status = UploadImageUtil.fileUpload(b,savePath,fileName);
				    if (!status.equals("ok")) {
			        	map.put("result", "005");
				        map.put("message", "图片上传失败请重新上传");
				        return JSONHelper.getJsonByMap(map);
			        }else{
			        	 fileNameLs.add(path+fileName);
			        }
				}
			}
	      
		  Editor editor = new Editor();
		  editor.setCust_id(Integer.parseInt(custId));
		  editor.setContent(content);
		  editor.setCreate_date(new Date());
		  editor.setIs_valid(0);
	      int status = 0;
	      status = editorService.addEditor(editor);
	      if (status > 0) {
	    	  if(fileNameLs!=null&&fileNameLs.size()>0){
	    		  for(int i=0;i<imgStrLs.size();i++){
	    			  EditorImg img = new EditorImg();
		    		  img.setEditor_id(editor.getId());
		    		  img.setImg_url(fileNameLs.get(i));
		    		  img.setCreate_date(new Date());
		    		  img.setIs_valid(0);
		    		  imgService.addEditorImg(img);
	    		  }
	    		  map.put("result", "1");
	  	          map.put("message", "现场采编添加成功");
	    	  }else{
	    		  map.put("result", "007");
	  	          //map.put("message", "采编信息图片插入失败请重新提交");
	  	          map.put("message", "采编信息添加成功");
	    	  }
	      } else {
	        map.put("result", "006");
	        map.put("message", "采编信息插入失败请重新提交");
	      }
	      
	    } else {
	      map.put("result", "001");
	      map.put("message", "传递的数据为空");
	    }

	    return JacksonHelper.toJSON(map);
	  }
	
	/**
	 * 我的发布
	 * @param jsonStr为 用户名id、页号、分页数量的json字符串
	 * @return 主键为 cust_id、pageNum、pageSize
	 */
	@Override
	public String viewPublishLs(String jsonStr) {
		Map<String, Object> map = new HashMap<String,Object>();
	    if(jsonStr != null && jsonStr.length() > 0) {
	       map = JSONHelper.getMapByJson(jsonStr);
	       String custId = map.get("cust_id").toString();
		   String pageSize = map.get("pageSize").toString();
		   String pageNum = map.get("pageNum").toString();
		   map = new HashMap<String,Object>();
		   if (custId == null || custId.equals("")) {
			   map.put("result", "002");
			   map.put("message", "传递的用户id为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   if (pageSize == null || pageSize.equals("")) {
			   map.put("result", "003");
			   map.put("message", "传递的分页尺寸为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   if (pageNum == null || pageNum.equals("")) {
			   map.put("result", "004");
			   map.put("message", "传递的页号为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   Editor editor = new Editor();
		   editor.setCust_id(Integer.parseInt(custId));
		   int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
		   editor.setStartRow(startRow);
		   editor.setPageSize(Integer.parseInt(pageSize));
		   List<Editor> editorLs = editorService.getEditorBySelectiveLs(editor);
		   map.put("result", "1");
		   map.put("message", "获取我的发布成功");
		   map.put("data", editorLs);
	    }else{
	       map.put("result", "001");
		   map.put("message", "传递的数据为空");
	    }
	    return JacksonHelper.toJSON(map);
	}

	/**
	 * 出版圈
	 * @param jsonStr为页号、分页数量的json字符串
	 * 		  主键分别为pageNum、pageSize
	 * @return
	 */
	@Override
	public String getEditorLs(String jsonStr) {
		Map<String, Object> map = new HashMap<String,Object>();
	    if(jsonStr != null && jsonStr.length() > 0) {
	       map = JSONHelper.getMapByJson(jsonStr);
		   String pageSize = map.get("pageSize").toString();
		   String pageNum = map.get("pageNum").toString();
		   map = new HashMap<String,Object>();
		   if (pageSize == null || pageSize.equals("")) {
			   map.put("result", "002");
			   map.put("message", "传递的分页尺寸为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   if (pageNum == null || pageNum.equals("")) {
			   map.put("result", "003");
			   map.put("message", "传递的页号为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   Editor editor = new Editor();
		   editor.setIs_valid(1);
		   int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
		   editor.setStartRow(startRow);
		   editor.setPageSize(Integer.parseInt(pageSize));
		   List<Editor> editorLs = editorService.getEditorBySelectiveLs(editor);
		   map.put("result", "1");
		   map.put("message", "获取我的发布成功");
		   map.put("data", editorLs);
	    }else{
	       map.put("result", "001");
		   map.put("message", "传递的数据为空");
	    }
	    return JacksonHelper.toJSON(map);
	}

	@Override
	public String delEditorByCustId(String jsonStr) {
		Map<String, Object> map = new HashMap<String,Object>();
	    if(jsonStr != null && jsonStr.length() > 0) {
	       map = JSONHelper.getMapByJson(jsonStr);
		   String cust_id = map.get("cust_id").toString();
		   String editor_id = map.get("editor_id").toString();
		   map = new HashMap<String,Object>();
		   if (cust_id == null || cust_id.equals("")) {
			   map.put("result", "002");
			   map.put("message", "传递的用户id为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   if (editor_id == null || editor_id.equals("")) {
			   map.put("result", "003");
			   map.put("message", "传递的采编信息id为空");
			   return JSONHelper.getJsonByMap(map);
			}
		   Editor editor = new Editor();
		   editor.setCust_id(Integer.parseInt(cust_id));
		   editor.setId(Integer.parseInt(editor_id));
		   editor.setIs_valid(3);
		   int status = editorService.updateByEditorId(editor);
		   if(status>0){
			   map.put("result", "1");
			   map.put("message", "删除采编信息成功");
		   }else{
			   map.put("result", "004");
			   map.put("message", "删除采编信息失败");
		   }
	    }else{
	       map.put("result", "001");
		   map.put("message", "传递的数据为空");
	    }
	    return JacksonHelper.toJSON(map);
	}

}
