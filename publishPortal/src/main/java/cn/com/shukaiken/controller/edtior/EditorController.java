package cn.com.shukaiken.controller.edtior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Cust;
import cn.com.shukaiken.model.Editor;
import cn.com.shukaiken.model.EditorImg;
import cn.com.shukaiken.service.ICustService;
import cn.com.shukaiken.service.IEditorImgService;
import cn.com.shukaiken.service.IEditorService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.ValidateUtils;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/admin/editor")
public class EditorController {
	
	private Logger logger = LoggerFactory.getLogger(EditorController.class);
	
	private static final String EDITOR_PATH = "/admin/editor/";//现场采编页面的路径 
	
	@Resource
	private IEditorService editorService;
	
	@Resource
	private IEditorImgService imgService;
	
	@Resource
	private ICustService custService;
	
	/**
	 * 后台查询现场采编信息
	 * @param rc
	 * @param editor
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getEditorLs")
	public String getEditorLs(RequestContext rc,Editor editor,ModelMap model){
		logger.info("查询现场采编信息");
		if(editor == null){
			editor = new Editor();
		}else{
			if(editor.getUser_name()!=null){
				if(editor.getUser_name().equals("")){
					editor.setUser_name(null);
				}else{
					Cust cust = new Cust();
					cust.setUser_name(editor.getUser_name());
					cust = custService.selectByCust(cust);
					if(cust!=null){
						editor.setCust_id(cust.getId());
					}
				}
			}
			
			if(editor.getIs_valid()!=null){
				if(editor.getIs_valid().equals("")){
					editor.setIs_valid(null);
				}
			}
			
			if(editor.getReason()!=null){
				if(editor.getReason().equals("")){
					editor.setReason(null);
				}
			}
			
			if(editor.getContent()!=null){
				if(editor.getContent().equals("")){
					editor.setContent(null);
				}
			}
			
		}
		rc.attr("editor",editor);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<Editor> editorLs = editorService.getEditorLs(editor);
		PageInfo<Editor> page = new PageInfo<Editor>(editorLs);
		model.addAttribute("page", page);
		
		return EDITOR_PATH+"editor_list";
	}
	
	/**
	 * 预览采编信息详情
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/viewEditor")
	public String viewEditor(RequestContext rc){
		String id = rc.get("id");
		if(id==null||id.equals("")){
			rc.attr("msg", "id不能为空！");
			return "forward:getEditorLs";
		}
		Editor editor = editorService.getEditorById(Integer.parseInt(id));
		EditorImg editorImg = new EditorImg();
		editorImg.setEditor_id(Integer.parseInt(id));
		List<EditorImg>  imgLs = imgService.getEditorImgLs(editorImg);
		rc.attr("editor",editor);
		rc.attr("imgLs",imgLs);
		return EDITOR_PATH+"editor_edit";
	}
	
	/**
	 * 修改现场采编信息的状态
	 * @param rc
	 * @param model
	 * @return
	 */
	@RequestMapping(value="changeStatus")
	@ResponseBody
	public Map<String,String> changeStatus(RequestContext rc,ModelMap model){
		
		Map<String,String> map = new HashMap<String,String>();
		String id = rc.get("id");
		String status = rc.get("status");
		String reason = rc.get("reason");
		logger.info("修现场采编信息的状态,id="+id+",to status="+status+",操作人:"+rc.getCurrUser().getName()+",id="+rc.getCurrUser().getId());
		if(!ValidateUtils.isEmpty(id)){
			Editor editor = new Editor();
			editor.setId(Integer.valueOf(id));
			editor.setIs_valid(Integer.valueOf(status));
			if(reason!=null&&!reason.equals("")){
				editor.setReason(reason);
			}
			int result = editorService.updateByEditorId(editor);
			String message = "";
			if(result>0){
				if(status.equals("1")){
					message = "现场采编信息审核通过";
				}else if(status.equals("2")){
					message="现场采编信息审核未通过";
				}else{
					message="现场采编信息状态修改成功";
				}
				map.put("message",message );
				map.put("success", "true");
			}else{
				if(status.equals("1")){
					message = "现场采编信息审核通过状态修改失败";
				}else if(status.equals("2")){
					message="票现场采编信息审核未通过状态修改失败";
				}else{
					message="现场采编信息状态修改失败";
				}
				map.put("message",message );
				map.put("success", "false");
			}
		}else {
			map.put("message","现场采编信息状态修改失败" );
			map.put("success", "false");
		}
		
		return map;
	}

}
