package cn.com.shukaiken.controller.feed;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.BackFeed;
import cn.com.shukaiken.model.BackFeedType;
import cn.com.shukaiken.model.Cust;
import cn.com.shukaiken.service.IBackFeedService;
import cn.com.shukaiken.service.IBackFeedTypeService;
import cn.com.shukaiken.service.ICustService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/admin/feed")
public class BackFeedController {
	
	private Logger logger = LoggerFactory.getLogger(BackFeedController.class);
	
	private static final String FEED_PATH = "/admin/feed/";//反馈页面的路径 
	
	@Resource
	private IBackFeedService backFeedService;
	
	@Resource
	private IBackFeedTypeService backFeedTypeService;
	
	@Resource
	private ICustService custService;
	
	/**
	 * 查询反馈
	 * @param rc
	 * @param backFeed
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getBackFeedLs")
	public String getBackFeedLs(RequestContext rc,BackFeed backFeed,ModelMap model){
		logger.info("查询反馈");
		if(backFeed == null){
			backFeed = new BackFeed();
		}else{
			if(backFeed.getUser_name()!=null){
				if(backFeed.getUser_name().equals("")){
					backFeed.setUser_name(null);
				}else{
					Cust cust = new Cust();
					cust.setUser_name(backFeed.getUser_name());
					cust = custService.selectByCust(cust);
					if(cust!=null){
						backFeed.setCust_id(cust.getId());
					}
				}
			}
			
			if(backFeed.getIs_valid()!=null){
				if(backFeed.getIs_valid().equals("")){
					backFeed.setIs_valid(null);
				}
			}
			
			if(backFeed.getFeed_type_id()!=null){
				if(backFeed.getFeed_type_id()==0){
					backFeed.setFeed_type_id(null);
				}
			}
			
			if(backFeed.getContent()!=null){
				if(backFeed.getContent().equals("")){
					backFeed.setContent(null);
				}
			}
			
			if(backFeed.getDemand_point()!=null){
				if(backFeed.getDemand_point().equals("")){
					backFeed.setDemand_point(null);
				}
			}
		}
		rc.attr("backFeed",backFeed);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<BackFeed> backFeedLs = backFeedService.getBackFeedLs(backFeed);
		List<BackFeedType> backFeedTypeLs = backFeedTypeService.getBackFeedTypeLs(null);
		if(backFeedTypeLs!=null&& backFeedTypeLs.size()>0){
			rc.attr("backFeedTypeLs",backFeedTypeLs);
		}
		PageInfo<BackFeed> page = new PageInfo<BackFeed>(backFeedLs);
		model.addAttribute("page", page);
		
		return FEED_PATH+"feed_list";
	}
	
	
	/**
	 * 去给反馈信息分组
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toGroupWithBackFeed")
	public String toGroupWithBackFeed(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return FEED_PATH+"feed_list";
		}else{
			BackFeed backFeed =  backFeedService.getBackFeedById(Integer.parseInt(id));
			List<BackFeedType> backFeedTypeLs = backFeedTypeService.getBackFeedTypeLs(null);
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",2);
			rc.attr("backFeed",backFeed);
			if(backFeedTypeLs!=null&& backFeedTypeLs.size()>0){
				rc.attr("backFeedTypeLs",backFeedTypeLs);
			}
		}
		
		return FEED_PATH+"feed_group_form";
	}
	
	/**
	 * 去给反馈信息提取需求点
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toFetchDemandPoint")
	public String toFetchDemandPoint(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return FEED_PATH+"feed_list";
		}else{
			BackFeed backFeed =  backFeedService.getBackFeedById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",3);
			rc.attr("backFeed",backFeed);
		}
		
		return FEED_PATH+"feed_demand_form";
	}
	
	
	/**
	 * 去处理反馈信息(改为已处理)
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toHandleBackFeed")
	public String toHandleBackFeed(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return FEED_PATH+"feed_list";
		}else{
			BackFeed backFeed =  backFeedService.getBackFeedById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",4);
			rc.attr("backFeed",backFeed);
		}
		
		return FEED_PATH+"feed_handle_form";
	}
	
	
	/**
	 * 修改反馈信息
	 * @param rc
	 * @param backFeed
	 * @return
	 */
	@RequestMapping("/updateBackFeedWithType")
	public String updateBackFeedWithType(RequestContext rc,BackFeed backFeed){
		String type = rc.get("type");
		String id = rc.get("id");
		if(type.equals("2")){
			if(!id.equals("") && id != null){//给反馈信息分组
				backFeed.setId(Integer.parseInt(id));
				backFeed.setIs_valid(1);
				backFeedService.updateByBackFeedId(backFeed);
			}
		}else if(type.equals("3")){//给反馈信息提取需求点
			if(!id.equals("") && id != null){
				backFeed.setId(Integer.parseInt(id));
				backFeed.setIs_valid(2);
				backFeedService.updateByBackFeedId(backFeed);
			}
			
		}else if(type.equals("4")){//处理反馈信息(改为已处理)
			if(!id.equals("") && id != null){
				backFeed.setId(Integer.parseInt(id));
				backFeedService.updateByBackFeedId(backFeed);
			}
		}
		
		return "forward:getBackFeedLs";
	}
	
	@RequestMapping(value="/batchBackFeed")
	public String batchBackFeed(RequestContext rc){
		String[] feeds = rc.getValues("feeds");
		if(feeds!=null && feeds.length>0){
			for(int i=0;i<feeds.length;i++){
				BackFeed backFeed = new BackFeed();
				backFeed.setId(Integer.parseInt(feeds[i])-27);
				backFeed.setIs_valid(3);
				backFeedService.updateByBackFeedId(backFeed);
			}
		}
		return "forward:getBatchBackFeedLs";
	}
	
	
	/**
	 * 查询需要批处理的反馈信息
	 * @param rc
	 * @param backFeed
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getBatchBackFeedLs")
	public String getBatchBackFeedLs(RequestContext rc,BackFeed backFeed,ModelMap model){
		logger.info("查询批处理反馈");
		if(backFeed == null){
			backFeed = new BackFeed();
		    backFeed.setIs_valid(2);
		}else{
			if(backFeed.getUser_name()!=null){
				if(backFeed.getUser_name().equals("")){
					backFeed.setUser_name(null);
				}else{
					Cust cust = new Cust();
					cust.setUser_name(backFeed.getUser_name());
					cust = custService.selectByCust(cust);
					if(cust!=null){
						backFeed.setCust_id(cust.getId());
					}
				}
			}
			
		    backFeed.setIs_valid(2);
		   
			if(backFeed.getFeed_type_id()!=null){
				if(backFeed.getFeed_type_id()==0){
					backFeed.setFeed_type_id(null);
				}
			}
			
			if(backFeed.getContent()!=null){
				if(backFeed.getContent().equals("")){
					backFeed.setContent(null);
				}
			}
			
			if(backFeed.getDemand_point()!=null){
				if(backFeed.getDemand_point().equals("")){
					backFeed.setDemand_point(null);
				}
			}
		}
		rc.attr("backFeed",backFeed);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<BackFeed> backFeedLs = backFeedService.getBackFeedLs(backFeed);
		List<BackFeedType> backFeedTypeLs = backFeedTypeService.getBackFeedTypeLs(null);
		if(backFeedTypeLs!=null&& backFeedTypeLs.size()>0){
			rc.attr("backFeedTypeLs",backFeedTypeLs);
		}
		PageInfo<BackFeed> page = new PageInfo<BackFeed>(backFeedLs);
		model.addAttribute("page", page);
		
		return FEED_PATH+"feed_batch_list";
	}
	
	/**
	 * 去查看反馈信息详情
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toViewBatchFeed")
	public String toViewBatchFeed(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return FEED_PATH+"feed_batch_list";
		}else{
			BackFeed backFeed =  backFeedService.getBackFeedById(Integer.parseInt(id));
			rc.attr("backFeed",backFeed);
		}
		
		return FEED_PATH+"feed_batch_form";
	}
	

}
