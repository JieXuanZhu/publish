package cn.com.shukaiken.controller.sensitive;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.SensitiveWords;
import cn.com.shukaiken.service.ISensitiveWordsService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping("/admin/sensitive")
public class SensitiveController {
	
	private Logger logger = LoggerFactory.getLogger(SensitiveController.class);
	
	private static final String SENSITIVE_PATH = "/admin/sensitive/";//敏感词页面的路径 
	
	@Resource
	private ISensitiveWordsService sensitiveWordsService;
	
	/**
	 * 查询敏感词
	 * @param rc
	 * @param sensitiveWords
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getSensitiveLs")
	public String getSensitiveLs(RequestContext rc,SensitiveWords sensitiveWords,ModelMap model){
		logger.info("查询敏感词");
		if(sensitiveWords == null){
			sensitiveWords = new SensitiveWords();
		}else{
			if(sensitiveWords.getWords()!=null){
				if(sensitiveWords.getWords().equals("")){
					sensitiveWords.setWords(null);
				}
			}
			if(sensitiveWords.getSpecial_character()!=null){
				if(sensitiveWords.getSpecial_character().equals("")){
					sensitiveWords.setSpecial_character(null);
				}
			}
		}
		
		rc.attr("sensitiveWords",sensitiveWords);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<SensitiveWords> sensitiveWordsLs = sensitiveWordsService.getSensitiveLs(sensitiveWords);
		PageInfo<SensitiveWords> page = new PageInfo<SensitiveWords>(sensitiveWordsLs);
		model.addAttribute("page", page);
		
		return SENSITIVE_PATH+"sensitive_list";
	}
	
	
	/**
	 * 创建敏感词
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddSensitiveWords")
	public String toAddSensitiveWords(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return SENSITIVE_PATH+"sensitive_form";
	}
	
	/**
	 * 修改敏感词
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateSensitiveWords")
	public String toUpdateSensitiveWords(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "程序异常！");
			return SENSITIVE_PATH+"sensitive_form";
		}else{
			SensitiveWords sensitiveWords =  sensitiveWordsService.getSensitiveWordsById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",2);
			rc.attr("sensitiveWords",sensitiveWords);
		}
		
		return SENSITIVE_PATH+"sensitive_form";
	}
	
	
	/**
	 * 添加或修改敏感词
	 * @param rc
	 * @param sensitiveWords
	 * @return
	 */
	@RequestMapping("/addOrUpdateSensitiveWords")
	public String addOrUpdateSensitiveWords(RequestContext rc,SensitiveWords sensitiveWords){
		
		if(!TokenHandler.validToken(rc.getRequest())){
			rc.attr("msg", "敏感词不能重复提交！");
			return SENSITIVE_PATH+"sensitive_form";
		}else{
			String type = rc.get("type");
			String id = rc.get("id");
			if(type.equals("1")){
				if(sensitiveWords!=null && !sensitiveWords.getWords().equals("")){
					SensitiveWords  temp = new SensitiveWords();
					temp.setWords(sensitiveWords.getWords());
					temp.setIs_valid(0);
					temp = sensitiveWordsService.selectBySensitiveWords(sensitiveWords);
					
					if(temp==null){
						//继续往下走
						sensitiveWords.setIs_valid(0);
						sensitiveWords.setCreate_date(new Date());
						sensitiveWordsService.addSensitiveWords(sensitiveWords);
						
					}else{
						//敏感词已经存在
						rc.attr("type",1);
						rc.attr("msg", "该敏感词已经存在！");
						return SENSITIVE_PATH+"sensitive_form";
					}
				}
				
				
			}else if(type.equals("2")){
				
				if(!id.equals("") && id != null){
					sensitiveWords.setId(Integer.parseInt(id));
					sensitiveWordsService.updateBySensitiveWordsId(sensitiveWords);
					
				}
				
			}
		}
		
		return "forward:getSensitiveLs";
	}
	
	/**
	 * 删除敏感词
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/delSensitiveWords")
	public String delSensitiveWords(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			SensitiveWords sensitiveWords = new SensitiveWords();
			sensitiveWords.setId(Integer.parseInt(id));
			sensitiveWords.setIs_valid(2);
			sensitiveWordsService.updateBySensitiveWordsId(sensitiveWords);
			
		}else{
			rc.attr("msg", "id不能为空！！");
			return SENSITIVE_PATH+"sensitive_list";
		}
		
		return "forward:getSensitiveLs";
		
	}
	
}
