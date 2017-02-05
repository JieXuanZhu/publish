package cn.com.shukaiken.webService.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.shukaiken.model.Cust;
import cn.com.shukaiken.model.InfoComment;
import cn.com.shukaiken.model.InfoContent;
import cn.com.shukaiken.model.InfoEnshrine;
import cn.com.shukaiken.service.ICustService;
import cn.com.shukaiken.service.IInfoCommentService;
import cn.com.shukaiken.service.IInfoContentService;
import cn.com.shukaiken.service.IInfoEnshrineService;
import cn.com.shukaiken.service.IInfoService;
import cn.com.shukaiken.util.JSONHelper;
import cn.com.shukaiken.util.JacksonHelper;
import cn.com.shukaiken.util.PagerHelper;
import cn.com.shukaiken.webService.IAppNewsWebService;
@Service
public class AppNewsWebServiceImpl implements IAppNewsWebService {
	
	private Logger logger = LoggerFactory.getLogger(AppNewsWebServiceImpl.class);
	
	/**
	 * 新闻信息服务类
	 */
	@Resource
	private IInfoService infoService;
	
	/**
	 * 收藏信息服务类
	 */
	@Resource
	private IInfoEnshrineService enshrineService;
	
	/**
	 * 收藏信息服务类
	 */
	@Resource
	private IInfoCommentService commentService;
	
	/**
	 * 新闻内容信息服务类
	 */
	@Resource
	private IInfoContentService contentService;
	
	/**
	 * 会员信息服务类
	 */
	@Resource
	private ICustService custService;

	/**
	 * 获取搜索新闻列表
	 * @param type
	 * @param jsonStr
	 * @return
	 */
	
	@Override
	public String getSearchNews(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(jsonStr!=null&&jsonStr.length()>0){
			map = JSONHelper.getMapByJson(jsonStr);
			String tag_id = map.get("tag_id").toString();
			String pageSize = map.get("pageSize").toString();
			String pageNum = map.get("pageNum").toString();
			String days = map.get("days").toString();
			String words = map.get("words").toString();
			map = new HashMap<String,Object>();
			
			InfoContent content = new InfoContent();
			if(tag_id!=null && !tag_id.equals("")){
				if(!tag_id.equals("1")){
					content.setTagId(Integer.parseInt(tag_id));
				}
			}
			if(words!=null && !words.equals("")){
				content.setWords(words);
			}
			if(days!=null ){
				if(!days.equals("")){
					int day = Integer.parseInt(days);
					Date endDate= new Date();
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar rightNow = Calendar.getInstance();
					rightNow.setTime(endDate);
					rightNow.add(Calendar.DAY_OF_YEAR,-day);
					Date startDate=rightNow.getTime();
					content.setStartDate(simpleDateFormat.format(startDate));
					content.setEndDate(simpleDateFormat.format(endDate));
				}
			}
			
			int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
			content.setStartRow(startRow);
			content.setPageSize(Integer.parseInt(pageSize));
			//新闻列表
			List<InfoContent> newsLs = contentService.getSearchInfoLs(content);
			map.put("result", "1");
			map.put("message", "搜素新闻成功");
			map.put("data", newsLs);
			
		}else{
			map.put("result", "0");
			map.put("message", "传递的数据为空");
		}
	   
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	
	}
	
	/**
	 * 获取头条新闻列表
	 */
	@Override
	public String getHeadNews() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//获取头条大banner新闻
		List<InfoContent> headBannerInfoLs = contentService.getHeadBannerInfoLs();
		
		//获取头条分类banner新闻
		List<InfoContent> categoryBannerInfoLs = contentService.getCategoryBannerInfoLs();
		
		//最新
		InfoContent newestInfo = contentService.getNewestInfo();
		//热门
		InfoContent hotInfo = contentService.getHotInfo();
		
		InfoContent content = new InfoContent();
	    content.setTagId(2);
		content.setStartRow(0);
		content.setPageSize(3);
		//行业动态新闻列表
		List<InfoContent> trendsNewsLs = contentService.getHeadCategoryInfoLs(content);
		
		//政策规划新闻列表
		content.setTagId(3);
	    List<InfoContent> policyNewsLs = contentService.getHeadCategoryInfoLs(content);
	    
	    //市场动态新闻列表
		content.setTagId(4);
	    List<InfoContent> bazaarNewsLs = contentService.getHeadCategoryInfoLs(content);
	    
	    //书展圈新闻列表
		content.setTagId(5);
	    List<InfoContent> bookNewsLs = contentService.getHeadCategoryInfoLs(content);
	    map.put("result", "1");
		map.put("message", "获取头条新闻成功");
		Map<String,Object> map_data = new HashMap<String,Object>();
		map_data.put("headBannerInfoLs", headBannerInfoLs);
		map_data.put("newestInfo", newestInfo);
		map_data.put("hotInfo", hotInfo);
		map_data.put("trendsNewsLs", trendsNewsLs);
		map_data.put("policyNewsLs", policyNewsLs);
		map_data.put("bazaarNewsLs", bazaarNewsLs);
		map_data.put("bookNewsLs", bookNewsLs);
		map_data.put("categoryBannerInfoLs", categoryBannerInfoLs);
		map.put("data", map_data);
	    String jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}


	/**
	 * 查询分类新闻
	 */
	@Override
	public String getCategoryNews(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		//String reg = "&quot;"; 
		//jsonStr = jsonStr.replaceAll(reg,"\""); 
		logger.info("jsonStr为："+jsonStr);
		map = JSONHelper.getMapByJson(jsonStr);
		if(map!=null&&map.size()>0){
			String tag_id = map.get("tag_id").toString();
			String pageSize = map.get("pageSize").toString();
			String pageNum = map.get("pageNum").toString();
			map = new HashMap<String,Object>();
			InfoContent content = new InfoContent();
		   
			if(tag_id!=null&& !tag_id.equals("")){
				 content.setTagId(Integer.parseInt(tag_id));
			}
			int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
			content.setStartRow(startRow);
			content.setPageSize(Integer.parseInt(pageSize));
			//新闻列表
			List<InfoContent> newsLs = contentService.getCategoryInfoLs(content);
			map.put("result", "1");
			map.put("message", "查询分类新闻成功");
			map.put("data", newsLs);
			
		}else{
			map.put("result", "0");
			map.put("message", "传递的数据为空");
		}
	   
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

	/**
	 * 查看新闻详情
	 */
	@Override
	public String viewNewsDetail(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		String info_id = map.get("info_id").toString();
		String cust_id = map.get("cust_id").toString();
		map = new HashMap<String,Object>();
		if(info_id==null || info_id.equals("")){
			map.put("result", "001");
			map.put("message", "新闻id不能为空");
			return JacksonHelper.toJSON(map);
		}
		InfoContent info = new InfoContent();
		info.setInfoId(Integer.parseInt(info_id));
		if(cust_id!=null&&!cust_id.equals("")){
			info.setCust_id(Integer.parseInt(cust_id));
		}
		InfoContent content = contentService.viewNewsDetail(info);
		map.put("result", "1");
		map.put("message", "查询新闻详情成功");
		map.put("data", content);
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}
	
	/**
	 * 获取新闻的评论列表
	 */
	@Override
	public String getCommentLs(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		if(map!=null&&map.size()>0){
			String info_id = map.get("info_id").toString();
			String pageSize = map.get("pageSize").toString();
			String pageNum = map.get("pageNum").toString();
			map = new HashMap<String,Object>();
			InfoComment comment = new InfoComment();
			if(info_id!=null && !info_id.equals("")){
				comment.setInfoId(Integer.parseInt(info_id));
				comment.setIsValid(0);
			}
			int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
			comment.setStartRow(startRow);
			comment.setPageSize(Integer.parseInt(pageSize));
			List<InfoComment> commentLs =  commentService.getCommentLs(comment);
			
			map.put("result", "1");
			map.put("message", "查询新闻评论成功");
			map.put("data", commentLs);
			
		}else{
			map.put("result", "0");
			map.put("message", "传递的数据为空");
		}
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

	/**
	 * 添加评论
	 */
	@Override
	public String addNewsComment(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		if(map!=null&&map.size()>0){
			String author_id = map.get("author_id").toString();
			String info_id = map.get("info_id").toString();
			//String cust_id = map.get("cust_id").toString();
			String comment_content = map.get("comment_content").toString();
			//String comment_id = map.get("comment_id").toString();
			String type = map.get("type").toString();
			map = new HashMap<String,Object>();
			InfoComment comment = new InfoComment();
			Cust cust = new Cust();
			if(author_id!=null&& !author_id.equals("")){
				comment.setAuthorId(Integer.parseInt(author_id));
				cust =custService.getCustById(Integer.parseInt(author_id));
				if(cust!=null&&cust.getUser_name()!=null&&!cust.getUser_name().equals("")){
					comment.setAuthor(cust.getUser_name());
				}
			}
			if(info_id!=null&& !info_id.equals("")){
				comment.setInfoId(Integer.parseInt(info_id));
			}
			if(comment_content!=null&&!comment_content.equals("")){
				comment.setComment_content(comment_content);
			}
			if(type!=null && !type.equals("")){
				if("1".equals(type)){
					comment.setCust_id(0);
					comment.setParentCommentId(0);
				}else if("2".equals(type)){
					/*if(cust_id!=null && !cust_id.equals("")){
						comment.setCust_id(Integer.parseInt(cust_id));
						cust =custService.getCustById(Integer.parseInt(cust_id));
						if(cust!=null&&cust.getUser_name()!=null&&!cust.getUser_name().equals("")){
							comment.setUser_name(cust.getUser_name());
						}
					}
					
					if(comment_id!=null&&!comment_id.equals("")){
						comment.setParentCommentId(Integer.parseInt(comment_id));
					}*/
					
				}
			}
			comment.setIsValid(0);
			comment.setCreateTime(new Date());
			int status = 0;
			status = commentService.addInfoComment(comment);
			if(status>0){
				map.put("result", "1");
				map.put("message", "评论成功");
			}else{
				map.put("result", "0");
				map.put("message", "评论失败");
			}
			
		}else{
			map.put("result", "001");
			map.put("message", "传递的数据为空");
		}
		
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

	/**
	 * 添加收藏
	 */
	@Override
	public String enshrineNews(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		String cust_id = map.get("cust_id").toString();
		String info_id = map.get("info_id").toString();
		map = new HashMap<String,Object>();
		InfoEnshrine enshrine = new InfoEnshrine();
		if(cust_id!=null && !cust_id.equals("")){
			enshrine.setCust_id(Integer.parseInt(cust_id));
		}
		if(info_id!=null&& !info_id.equals("")){
			enshrine.setInfoId(Integer.parseInt(info_id));
		}
		enshrine.setIs_valid(0);
		InfoEnshrine temp = enshrineService.selectByInfoEnshrine(enshrine);
		if(temp==null){
			enshrine.setCreate_time(new Date());
			int status = 0;
		    status = enshrineService.addInfoEnshrine(enshrine);
			if(status>0){
				map.put("result", "1");
				map.put("message", "收藏成功");
			}else{
				map.put("result", "0");
				map.put("message", "收藏失败");
			}
		}else{
			map.put("result", "2");
			map.put("message", "该新闻已经收藏过");
		}
		
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}
	
	@Override
	public String cancelEnshrine(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(jsonStr!=null&&jsonStr.length()>0){
			map = JSONHelper.getMapByJson(jsonStr);
			String cust_id = map.get("cust_id").toString();
			String info_id = map.get("info_id").toString();
			map = new HashMap<String,Object>();
			InfoEnshrine enshrine = new InfoEnshrine();
			if(cust_id==null || cust_id.equals("")){
				map.put("result", "102");
		        map.put("message", "传递的用户id为空");
			}
			if(info_id==null||info_id.equals("")){
				map.put("result", "103");
		        map.put("message", "传递的新闻id为空");
			}
			enshrine.setCust_id(Integer.parseInt(cust_id));
			enshrine.setInfoId(Integer.parseInt(info_id));
			int status = enshrineService.cancelEnshrine(enshrine);
			if(status>0){
				map.put("result", "1");
		        map.put("message", "取消收藏成功");
			}else{
				map.put("result", "0");
		        map.put("message", "取消收藏失败");
			}
		}else{
			map.put("result", "101");
	        map.put("message", "传递的数据为空");
		}
		return JacksonHelper.toJSON(map);
	}


	/**
	 * 分页查询收藏列表
	 */
	@Override
	public String getEnshrineLs(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		if(map!=null&&map.size()>0){
			String cust_id = map.get("cust_id").toString();
			String pageSize = map.get("pageSize").toString();
			String pageNum = map.get("pageNum").toString();
			map = new HashMap<String,Object>();
			if(cust_id!=null && !cust_id.equals("")){
				InfoEnshrine enshrine = new InfoEnshrine();
				enshrine.setCust_id(Integer.parseInt(cust_id));
				int startRow = PagerHelper.startRow(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
				enshrine.setStartRow(startRow);
				enshrine.setPageSize(Integer.parseInt(pageSize));
				List<InfoEnshrine> enshrineLs = enshrineService.getEnshrineInfoLs(enshrine);
				map.put("result", "1");
				map.put("message", "查询收藏列表成功");
				map.put("data", enshrineLs);
			}else{
				map.put("result", "002");
				map.put("message", "用户id不能为空");
			}
		}else{
			map.put("result", "001");
			map.put("message", "传递的数据为空");
		}
			
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

	/**
	 * 批量删除收藏
	 */
	@Override
	public String updateEnshrineStatus(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		if(map!=null&&map.size()>0){
			int status = enshrineService.updateEnshrineInfoStatusByMap(map);
			map = new HashMap<String,Object>();
		    if(status>0){
				map.put("result", "1");
				map.put("message", "批量删除收藏新闻成功");
			}else{
				map.put("result", "002");
				map.put("message", "批量删除收藏新闻失败");
			}
		}else{
			map.put("result", "001");
			map.put("message", "传递的数据为空");
		}
		
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

	
	/**
	 * 查看收藏的新闻详情
	 */
	@Override
	public String viewEnshrineInfo(String jsonStr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = JSONHelper.getMapByJson(jsonStr);
		String cust_id = map.get("cust_id").toString();
		String info_id = map.get("info_id").toString();
		map = new HashMap<String,Object>();
		InfoEnshrine enshrine = new InfoEnshrine();
		if(cust_id==null || cust_id.equals("")){
			map.put("result", "001");
			map.put("message", "用户id为空");
			return JSONHelper.getJsonByMap(map);
		}
		if(info_id==null || info_id.equals("")){
			map.put("result", "002");
			map.put("message", "新闻id为空");
			return JSONHelper.getJsonByMap(map);
		}
		enshrine.setInfoId(Integer.parseInt(info_id));
		enshrine.setCust_id(Integer.parseInt(cust_id));
		enshrine.setIs_valid(0);
		InfoEnshrine infoEnshrine = enshrineService.viewEnshrineInfo(enshrine);
		if(infoEnshrine==null){
			map.put("result", "003");
			map.put("message", "没有此新闻");
		}else{
			map.put("result", "1");
			map.put("message", "查询收藏新闻详情成功");
			map.put("data", infoEnshrine);
		}
		
		jsonStr = JacksonHelper.toJSON(map);
		return jsonStr;
	}

}
