/**
 * @Title: CrawlNewsInfoContoller.java 
* @Package cn.com.shukaiken.controller.info 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月29日 下午6:12:35 
* @version V1.0 
 */
package cn.com.shukaiken.controller.info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.CrawlNewsInfo;
import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.model.Label;
import cn.com.shukaiken.model.TableInfo;
import cn.com.shukaiken.service.ICrawlNewsInfoService;
import cn.com.shukaiken.service.ILabelService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: CrawlNewsInfoContoller 
 * @Description: <p>TODO</p>
 * @date 2015年11月29日 下午6:12:35 
 * @author Zhao Xiang
 *
 */
@RequestMapping
@Controller
public class CrawlNewsInfoContoller {
	Logger logger = LoggerFactory.getLogger(CrawlNewsInfoContoller.class);
	
	private static final String NEWS_INFO_PATH = "/admin/data/";
	
	@Autowired
	private ICrawlNewsInfoService crawlNewsInfoService;
	@Autowired
	private ILabelService labelService;
	
	@RequestMapping(value="/admin/data/getNewsInfoSources")
	public String getCrawlNewsInfoSources(RequestContext rc,CrawlNewsInfoSource source,ModelMap model){
		logger.info("获取新闻数据抓取数据源");
		source.setIsValid(Constant.VALID);
		rc.initPageHelper(10);
		List<CrawlNewsInfoSource> sourcesList = crawlNewsInfoService.getSourceList(source);
		PageInfo<CrawlNewsInfoSource> page = new PageInfo<CrawlNewsInfoSource>(sourcesList);
		model.addAttribute("page", page);
		model.addAttribute("queryCond", source);
		
		return NEWS_INFO_PATH+"news_info_data_sources";
	}
	
	@RequestMapping(value="/admin/data/initAddCrawlNISource")
	public String initAddCrawlNewsInfoSource(RequestContext rc,ModelMap model){
		List<TableInfo> tableInfos = crawlNewsInfoService.selectTableInfo("t_news_info");//根据表名获取表的字段信息，包括位置，名称和注释
		model.addAttribute("tableInfos", tableInfos);
		Label ql = new Label();
		ql.setIs_valid(1);
		List<Label> labelList = labelService.selectLabelsByCondition(ql);
		model.addAttribute("labelList", labelList);
		logger.info("进入新增配置页面");
		return NEWS_INFO_PATH+"news_info_data_config";
	}
	
	@RequestMapping(value="/admin/data/initModifyCrawlSource")
	public String initModifyCrawlSource(RequestContext rc,ModelMap model){
		logger.info("进入修改配置页面");
		String srcId = rc.get("sourceId");
		if(!ValidateUtils.isEmpty(srcId)){
			CrawlNewsInfoSource source = crawlNewsInfoService.getSourceById(Integer.valueOf(srcId));
			List<TableInfo> tableInfos = crawlNewsInfoService.selectTableInfo("t_news_info");//根据表名获取表的字段信息，包括位置，名称和注释
			model.addAttribute("tableInfos", tableInfos);
			model.addAttribute("source", source);
		}
		Label ql = new Label();
		ql.setIs_valid(1);
		List<Label> labelList = labelService.selectLabelsByCondition(ql);
		model.addAttribute("labelList", labelList);
		return NEWS_INFO_PATH+"news_info_data_config_edit";
		
	}
	
	@RequestMapping(value="/admin/data/delCrawlSource")
	@ResponseBody
	public Map<String,String> delCrawlSource(RequestContext rc,ModelMap model){
		Map<String,String> map = new HashMap<String,String>();
		int result = 0;
		logger.info("删除数据源");
		try {
			String srcId = rc.get("sourceId");
			if(!ValidateUtils.isEmpty(srcId)){
				CrawlNewsInfoSource source = new CrawlNewsInfoSource();
				source.setIsValid(Constant.INVALID);
				source.setId(Integer.valueOf(srcId));
				result = crawlNewsInfoService.removeSourceById(source);
				if(result>0){
					map.put("success", "true");
					map.put("message", "数据源删除成功");
				}else {
					map.put("fail", "true");
					map.put("message", "数据源删除失败");
				}
			}else {
				map.put("fail", "true");
				map.put("message", "数据源删除失败");
			}
		} catch (Exception e) {
			logger.error("delCrawlSource.ERROR:"+e,e);
			map.put("fail", "true");
			map.put("message", "数据源删除失败");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/admin/data/addNewInfoCrawlConfig")
	@ResponseBody
	public Map<String,String> addNewInfoCrawlConfig(RequestContext rc,ModelMap model,CrawlNewsInfoSource infoSource){
		Map<String,String> map = new HashMap<String,String>();
		try {
			if(infoSource!=null){
				int sourceId = crawlNewsInfoService.addNewNewsSource(infoSource);
				if(sourceId>0){
					map.put("sourceId", Integer.toString(sourceId));
					map.put("success", "true");
					map.put("message", "新建数据源成功");
				}else {
					map.put("fail", "true");
					map.put("message", "新建数据源失败");
				}
			}
		} catch (Exception e) {
			logger.error("addNewInfoCrawlConfig。ERROR:"+e, e);
			map.put("fail", "true");
			map.put("message", "新建数据源失败");
			e.printStackTrace();
		}
		return map;
		
	}
	@RequestMapping(value="/admin/data/modifyInfoCrawlConfig")
	@ResponseBody
	public Map<String,String> modifyInfoCrawlConfig(RequestContext rc,ModelMap model,CrawlNewsInfoSource source){
		Map<String,String> map = new HashMap<String,String>();
		try {
			if(source!=null){
				int sourceId = crawlNewsInfoService.modifyNewsSource(source);
				if(sourceId>0){
					map.put("sourceId", Integer.toString(sourceId));
					map.put("success", "true");
					map.put("message", "修改数据源成功");
				}else {
					map.put("fail", "true");
					map.put("message", "修改数据源失败");
				}
			}
		} catch (Exception e) {
			logger.error("modifyInfoCrawlConfig。ERROR:"+e, e);
			map.put("fail", "true");
			map.put("message", "修改数据源失败");
			e.printStackTrace();
		}
		return map;
		
	}
	
	@RequestMapping(value="/admin/data/viewNewsSource")
	public String viewNewsInfoCrawlSource(RequestContext rc,ModelMap model){
		String sourceId = rc.get("sourceId");
		if(!ValidateUtils.isEmpty(sourceId)){
			logger.info("查看详细，sourceId="+sourceId);
			CrawlNewsInfoSource source = crawlNewsInfoService.getSourceById(Integer.valueOf(sourceId));
			model.addAttribute("source", source);
			Label label = labelService.getLabelById(source.getLabelId());
			if(label!=null){
				model.addAttribute("labelName", label.getLabel_name());
			}
		}
		return  NEWS_INFO_PATH+"news_info_data_detail";
	}
	
	@RequestMapping(value="/admin/data/getDatas")
	public String getCrawlDatas(RequestContext rc,CrawlNewsInfo qInfo,ModelMap model){
		logger.info("获取抓取的数据");
		logger.error("getLocalAddr："+rc.getRequest().getLocalAddr());
		logger.error("getLocalName："+rc.getRequest().getLocalName());
		logger.error("getRemoteAddr："+rc.getRequest().getRemoteAddr());
		logger.error("getRemoteHost："+rc.getRequest().getRemoteHost());
		logger.error("getRemoteUser："+rc.getRequest().getRemoteUser());
		logger.error("getRequestURI："+rc.getRequest().getRequestURI());
		logger.error("getScheme："+rc.getRequest().getScheme());
		logger.error("getProtocol："+rc.getRequest().getProtocol());
		logger.error("getServerName："+rc.getRequest().getServerName());
		logger.error("getServletPath："+rc.getRequest().getServletPath());
		logger.error("getRemotePort："+rc.getRequest().getRemotePort()+"");
		logger.error("getRequestURL："+rc.getRequest().getRequestURL()+"");
		logger.error("getServerPort："+rc.getRequest().getServerPort()+"");
		logger.error("getServletContext："+rc.getRequest().getServletContext()+"");
		rc.initPageHelper(20);
		List<CrawlNewsInfo> infos = crawlNewsInfoService.selectAllInfos(qInfo);
		PageInfo<CrawlNewsInfo> page = new PageInfo<CrawlNewsInfo>(infos);
		model.addAttribute("page", page);
		model.addAttribute("qInfo", qInfo);
		return NEWS_INFO_PATH+"news_info_list";
	}
	
	@RequestMapping(value="/admin/data/viewCrawlInfo")
	public String viewCrawlData(RequestContext rc,ModelMap model){
		String infoId = rc.get("infoId");
		logger.info("查看抓取数据");
		if(!ValidateUtils.isEmpty(infoId)){
			CrawlNewsInfo data = crawlNewsInfoService.getCrawlDataById(Integer.valueOf(infoId));
			model.addAttribute("info", data);
		}
		return NEWS_INFO_PATH+"news_info_view";
	}
	
}
