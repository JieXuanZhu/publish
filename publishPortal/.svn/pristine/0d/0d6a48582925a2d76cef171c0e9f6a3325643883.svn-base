package cn.com.shukaiken.controller.feed;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.BackFeedType;
import cn.com.shukaiken.service.IBackFeedTypeService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping(value="/admin/feed/type")
public class BackFeedTypeController {
	
	private Logger logger = LoggerFactory.getLogger(BackFeedTypeController.class);
	
	private static final String FEED_PATH = "/admin/feed/";//反馈类型页面的路径 
	
	@Resource
	private IBackFeedTypeService backFeedTypeService;
	
	/**
	 * 查询反馈类型
	 * @param rc
	 * @param backFeedType
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getBackFeedTypeLs")
	public String getBackFeedTypeLs(RequestContext rc,BackFeedType backFeedType,ModelMap model){
		logger.info("查询反馈类型");
		if(backFeedType == null){
			backFeedType = new BackFeedType();
		}else{
			if(backFeedType.getFeed_type_name()!=null){
				if(backFeedType.getFeed_type_name().equals("")){
					backFeedType.setFeed_type_name(null);
				}
			}
		}
		
		rc.attr("backFeedType",backFeedType);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<BackFeedType> backFeedTypeLs = backFeedTypeService.getBackFeedTypeLs(backFeedType);
		PageInfo<BackFeedType> page = new PageInfo<BackFeedType>(backFeedTypeLs);
		model.addAttribute("page", page);
		
		return FEED_PATH+"feed_type_list";
	}
	
	
	/**
	 * 创建反馈类型
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddBackFeedType")
	public String toAddBackFeedType(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return FEED_PATH+"feed_type_form";
	}
	
	/**
	 * 修改反馈类型
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateBackFeedType")
	public String toUpdateBackFeedType(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return FEED_PATH+"feed_type_form";
		}else{
			BackFeedType backFeedType =  backFeedTypeService.getBackFeedTypeById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",2);
			rc.attr("backFeedType",backFeedType);
		}
		
		return FEED_PATH+"feed_type_form";
	}
	
	
	/**
	 * 添加或修改反馈类型
	 * @param rc
	 * @param backFeedType
	 * @return
	 */
	@RequestMapping("/addOrUpdateBackFeedType")
	public String addOrUpdateBackFeedType(HttpServletRequest request,RequestContext rc,BackFeedType backFeedType){
		
		if(!TokenHandler.validToken(request)){
			rc.attr("msg", "反馈类型不能重复提交！");
			return FEED_PATH+"feed_type_form";
		}else{
			String type = rc.get("type");
			String id = rc.get("id");
			if(type.equals("1")){
				if(backFeedType!=null && !backFeedType.getFeed_type_name().equals("")){
					BackFeedType  temp = new BackFeedType();
					temp.setFeed_type_name(backFeedType.getFeed_type_name());
					temp.setIs_valid(0);
					temp = backFeedTypeService.selectByBackFeedType(backFeedType);
					if(temp==null){
						//继续往下走
						backFeedType.setIs_valid(0);
						backFeedType.setCreate_date(new Date());
						backFeedTypeService.addBackFeedType(backFeedType);
					}else{
						//反馈类型已经存在
						rc.attr("type",1);
						rc.attr("msg", "该反馈类型已经存在！");
						return FEED_PATH+"feed_type_form";
					}
				}
				
				
			}else if(type.equals("2")){
				
				if(!id.equals("") && id != null){
					backFeedType.setId(Integer.parseInt(id));
					backFeedTypeService.updateByBackFeedTypeId(backFeedType);
					
				}
				
			}
		}
		
		return "forward:getBackFeedTypeLs";
	}
	
	/**
	 * 删除反馈类型
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/delBackFeedType")
	public String delBackFeedType(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			BackFeedType backFeedType = new BackFeedType();
			backFeedType.setId(Integer.parseInt(id));
			backFeedType.setIs_valid(2);
			backFeedTypeService.updateByBackFeedTypeId(backFeedType);
		}else{
			rc.attr("msg", "id不能为空！！");
			return FEED_PATH+"feed_type_list";
		}
		
		return "forward:getBackFeedTypeLs";
		
	}

}
