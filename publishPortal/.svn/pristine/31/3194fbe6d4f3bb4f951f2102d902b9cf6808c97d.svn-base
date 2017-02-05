package cn.com.shukaiken.controller.search;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.SearchWords;
import cn.com.shukaiken.service.ISearchWordsService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.PinyinUtil;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/admin/search")
public class SearchWordsController {
	
	private Logger logger = LoggerFactory.getLogger(SearchWordsController.class);
	
	private static final String SEARCH_PATH = "/admin/search/";//关键热词页面的路径 
	
	@Resource
	private ISearchWordsService searchWordsService;
	
	/**
	 * 查询关键热词
	 * @param rc
	 * @param searchWords
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getSearchWordsLs")
	public String getSearchWordsLs(RequestContext rc,SearchWords searchWords,ModelMap model){
		logger.info("查询关键热词");
		if(searchWords == null){
			searchWords = new SearchWords();
		}else{
			if(searchWords.getName()!=null){
				if(searchWords.getName().equals("")){
					searchWords.setName(null);
				}
			}
			if(searchWords.getName_initial()!=null){
				if(searchWords.getName_initial().equals("")){
					searchWords.setName_initial(null);
				}
			}
		}
		
		rc.attr("searchWords",searchWords);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<SearchWords> searchWordsLs = searchWordsService.getSearchWordsLs(searchWords);
		PageInfo<SearchWords> page = new PageInfo<SearchWords>(searchWordsLs);
		model.addAttribute("page", page);
		
		return SEARCH_PATH+"search_list";
	}
	
	
	/**
	 * 创建关键热词
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddSearchWords")
	public String toAddSearchWords(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return SEARCH_PATH+"search_form";
	}
	
	/**
	 * 修改关键热词
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateSearchWords")
	public String toUpdateSearchWords(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "程序异常！");
			return SEARCH_PATH+"search_form";
		}else{
			SearchWords searchWords =  searchWordsService.getSearchWordsById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",2);
			rc.attr("searchWords",searchWords);
		}
		
		return SEARCH_PATH+"search_form";
	}
	
	
	/**
	 * 添加或修改关键热词
	 * @param rc
	 * @param searchWords
	 * @return
	 */
	@RequestMapping("/addOrUpdateSearchWords")
	public String addOrUpdateSearchWords(RequestContext rc,SearchWords searchWords){
		
		if(!TokenHandler.validToken(rc.getRequest())){
			rc.attr("msg", "关键热词不能重复提交！");
			return SEARCH_PATH+"search_form";
		}else{
			String type = rc.get("type");
			String id = rc.get("id");
			if(type.equals("1")){
				if(searchWords!=null && !searchWords.getName().equals("")){
					SearchWords  temp = new SearchWords();
					temp.setName(searchWords.getName());
					temp.setIs_valid(0);
					temp = searchWordsService.selectBySearchWords(searchWords);
					
					if(temp==null){
						//继续往下走
						searchWords.setIs_valid(0);
						String name_initial = PinyinUtil.cn2py(searchWords.getName());
						searchWords.setName_initial(name_initial);
						searchWords.setHit_count(0);
						searchWords.setCreate_date(new Date());
						searchWordsService.addSearchWords(searchWords);
						
					}else{
						//关键热词已经存在
						rc.attr("type",1);
						rc.attr("msg", "该关键热词已经存在！");
						return SEARCH_PATH+"search_form";
					}
				}
				
				
			}else if(type.equals("2")){
				
				if(!id.equals("") && id != null){
					searchWords.setId(Integer.parseInt(id));
					String name_initial = PinyinUtil.cn2py(searchWords.getName());
					searchWords.setName_initial(name_initial);
					searchWordsService.updateBySearchWordsId(searchWords);
					
				}
				
			}
		}
		
		return "forward:getSearchWordsLs";
	}
	
	/**
	 * 删除关键热词
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/delSearchWords")
	public String delSearchWords(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			SearchWords searchWords = new SearchWords();
			searchWords.setId(Integer.parseInt(id));
			searchWords.setIs_valid(2);
			searchWordsService.updateBySearchWordsId(searchWords);
			
		}else{
			rc.attr("msg", "id不能为空！");
			return SEARCH_PATH+"search_list";
		}
		
		return "forward:getSearchWordsLs";
		
	}
	

}
