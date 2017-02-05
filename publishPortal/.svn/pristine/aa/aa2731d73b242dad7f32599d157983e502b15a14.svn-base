package cn.com.shukaiken.controller.label;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.LabelTagRel;
import cn.com.shukaiken.model.Tag;
import cn.com.shukaiken.service.ITagService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.PinyinUtil;
import cn.com.shukaiken.util.TokenHandler;
import cn.com.shukaiken.util.ValidateUtils;

@Controller
@RequestMapping(value="/admin/tag")
public class TagController {
	
	private Logger logger = LoggerFactory.getLogger(TagController.class);
	
	private static final String TAG_PATH = "/admin/tag/";//角色页面的路径 
	
	@Resource
	private ITagService tagService;
	
	@RequestMapping("/getTagLs")
	public String getTagLs(RequestContext rc,Tag tag,ModelMap model){
		logger.info("查询标签");
		if(tag == null){
			tag = new Tag();
		}
		tag.setIsValid(0);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<Tag> tagList = tagService.getTagsByCondition(tag);
		PageInfo<Tag> page = new PageInfo<Tag>(tagList);
		model.addAttribute("page", page);
		
		return TAG_PATH+"tag_list";
	}
	
	
	/**
	 * 创建标签
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddTag")
	public String toAddTag(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return TAG_PATH+"tag_add";
	}
	
	@RequestMapping("/addTag")
	public String addTag(HttpServletRequest request,RequestContext rc,Tag tag){
		
		if(!TokenHandler.validToken(request)){
			request.setAttribute("msg", "标签不能重复提交！");
			return TAG_PATH+"tag_add";
		}else{
			if(tag!=null && !ValidateUtils.isEmpty(tag.getTagName())){
				Tag temp = new Tag();
				temp.setIsValid(0);
				temp.setCreateDate(new Date());
				temp.setTagCode(PinyinUtil.cn2py(tag.getTagName()));
				temp.setTagName(tag.getTagName());
				List<Tag> list = tagService.getTagsByCondition(tag);
				if(list!=null&&list.size()>0){
					//标签已经存在
					rc.attr("type",1);
					rc.attr("msg", "该标签已经存在！");
					return TAG_PATH+"tag_add";
				}else {
					tagService.addTag(temp);
				}
		}
		
			return "forward:getTagLs";
		}
	}
	
	@RequestMapping("/toUpdateTag")
	public String toUpdateTag(RequestContext rc){
		String id = rc.get("id");
		if(id==null || id.equals("")){
			rc.attr("msg", "程序异常！");
			return TAG_PATH+"tag_edit";
		}else{
			Tag tag =  tagService.getTagById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("tag",tag);
		}
		
		return TAG_PATH+"tag_edit";
	}
	
	@RequestMapping("/updateTag")
	public String updateTag(HttpServletRequest request,RequestContext rc,Tag tag){
		
		if(!TokenHandler.validToken(request)){
			request.setAttribute("msg", "标签不能重复提交！");
			return TAG_PATH+"label_edit";
		}else{
			String id = rc.get("id");
				if(!id.equals("") && id != null){
					tag.setTagId(Integer.parseInt(id));
					tag.setTagCode(PinyinUtil.cn2py(tag.getTagName()));
					tagService.updateByTagId(tag);
				}
				
		}
		
		return "forward:getTagLs";
	}
	
	@RequestMapping("/viewTag")
	public String viewTag(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "程序异常！");
			return TAG_PATH+"tag_list";
		}else{
			Tag tag =  tagService.getTagById(Integer.parseInt(id));
			rc.attr("tag",tag);
		}
		
		return TAG_PATH+"tag_detail";
	}
	
	@RequestMapping(value="/delTag")
	@ResponseBody
	public Map<String,String> delLabel(RequestContext rc){
		Map<String,String> map = new HashMap<String,String>();
		String id = rc.get("id");
		int result = 0;
		if(id!=null && !id.equals("")){
			Tag tag = new Tag();
			tag.setTagId(Integer.parseInt(id));
			tag.setIsValid(2);
			result = tagService.updateByTagId(tag);
			if(result>0){
				map.put("success", "true");
				map.put("message", "标签删除成功");
			}
		}else{
			map.put("message", "id不能为空！");
			map.put("success", "false");
		}
		
		return map;
		
	}
	
	@RequestMapping("/ajaxLabelTagList")
	@ResponseBody
	public JSONArray ajaxTagList(RequestContext rc){
		String labelId = rc.get("labelId");
		LabelTagRel qlt = new LabelTagRel();
		if(!ValidateUtils.isEmpty(labelId)){
			qlt.setLabelId(Integer.valueOf(labelId));
		}else {
			qlt.setLabelId(null);
		}
		//qlt.setLabelId(Integer.valueOf(labelId));
		//qlt.setIsValid(Constant.VALID);
		//List<LabelTagRel> labelTagList = tagService.getLabelTagsByCondition(qlt);//根据分类的Id获取这个分类下面的所有的标签
		List<Tag> labelTagList = tagService.getTagsByLabel(qlt);//根据分类的Id获取这个分类下面的所有的标签
		//List<Tag> tagLs = tagService.getTagsByCondition(qTag);//根据角色查询菜单
		//初始化JSONArray对象，并添加数据
		JSONArray array = new JSONArray();
		
		if(labelTagList != null && labelTagList.size() > 0){
			for (Tag tag : labelTagList) {
				//初始化HashMap集合并添加数组
			    Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", tag.getTagId());
				//map.put("pId", label.getP_id());
				/*if(label.getP_id()==Constant.TREE_ROOT_ID){
					map.put("open", "true");	
			    }*/
				map.put("name", tag.getTagName());
				
			    if(!ValidateUtils.isEmpty(labelId) && Integer.valueOf(labelId)==tag.getLabelId()){
					map.put("checked", "true");
				}
				array.add(map);
			}
			
		}
		
		return array;
		
	}
	
}
