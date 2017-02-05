package cn.com.shukaiken.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.com.shukaiken.util.JSONHelper;
import cn.com.shukaiken.util.UploadImageUtil;
import cn.com.shukaiken.webService.IAppCustWebService;
import cn.com.shukaiken.webService.IAppEditorWebService;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="/file/uploads")
	public void uploads(HttpServletRequest request){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		if(commonsMultipartResolver.isMultipart(request)){
			MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request ;
			String title = mrequest.getParameter("title");
			String content = mrequest.getParameter("content");
			List<MultipartFile> imgLs = mrequest.getFiles("file");
			List<String> imgStrLs = new ArrayList<String>();
			if(imgLs!=null&&imgLs.size()>0){
				for(MultipartFile imgFile :imgLs ){
					CommonsMultipartFile cf= (CommonsMultipartFile)imgFile;
				    DiskFileItem fi = (DiskFileItem)cf.getFileItem();
				    File file = fi.getStoreLocation(); 
				    if(file!=null){
				    	try {
							byte[] b = UploadImageUtil.getByte(file);
							if(b!=null&&b.length>0){
								String base64Str = UploadImageUtil.encode(b);
								imgStrLs.add(base64Str);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}	
				    }
				}
			}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cust_id", 2);
			map.put("title", title);
			map.put("content", content);
			map.put("data", imgStrLs);
			String jsonStr = JSONHelper.getJsonByMap(map);
			/*map = JSONHelper.getMapByJson(jsonStr);
			String data = map.get("data").toString();
			List<String> imLs = new ArrayList<String>();
			if(data!=null&&data.length()>0){
				imLs = JSONHelper.getListByJsonString(map.get("data").toString());
			}*/
			
			Service serviceModel = new ObjectServiceFactory().create(IAppEditorWebService.class);
			IAppEditorWebService service;
			try {
				// service = (IAppCustWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppCustWebService");
				service = (IAppEditorWebService) new XFireProxyFactory().create(serviceModel,"http://192.168.1.186:8080/publish/service/IAppEditorWebService");
				// 参数：文件的字节数组，上传目的地路径，文件名称
				jsonStr = service.addEditor(jsonStr);
				// 打印返回值
				System.out.println("jsonStr=" + jsonStr);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
				
	}
	
	@RequestMapping(value="/file/upload")
	public void upload(HttpServletRequest request){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		if(commonsMultipartResolver.isMultipart(request)){
			MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request ;
			MultipartFile imgFile = mrequest.getFile("file");
			CommonsMultipartFile cf= (CommonsMultipartFile)imgFile;
		    DiskFileItem fi = (DiskFileItem)cf.getFileItem();
		    File file = fi.getStoreLocation(); 
			if(file!=null){
				byte[] b;
				try {
					b = UploadImageUtil.getByte(file);
					String base64Str = UploadImageUtil.encode(b);
					System.out.println(b.length);
					System.out.println(base64Str.length());
					Service serviceModel = new ObjectServiceFactory().create(IAppCustWebService.class);
					IAppCustWebService service;
					try {
						//service = (IAppCustWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppCustWebService");
						service = (IAppCustWebService) new XFireProxyFactory().create(serviceModel,"http://localhost:8080/publishPortal/service/IAppCustWebService");
						// 参数：文件的字节数组，上传目的地路径，文件名称
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("cust_id", 2);
						map.put("data", base64Str);
						String jsonStr = JSONHelper.getJsonByMap(map);
					    jsonStr = service.setCustHeadImg(jsonStr);
						// 打印返回值
						System.out.println("jsonStr=" + jsonStr);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		}
	}
	
	@RequestMapping(value="/file/file")
	public String file(){
		return "front/file_upload";
	}

}

