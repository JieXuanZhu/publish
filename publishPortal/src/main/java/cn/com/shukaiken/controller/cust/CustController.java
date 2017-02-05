package cn.com.shukaiken.controller.cust;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Cust;
import cn.com.shukaiken.model.CustLevel;
import cn.com.shukaiken.service.ICustLevelService;
import cn.com.shukaiken.service.ICustService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/admin/cust")
public class CustController {
	
	private Logger logger = LoggerFactory.getLogger(CustController.class);
	
	private static final String CUST_PATH = "/admin/cust/";//会员页面的路径 
	
	@Resource
	private ICustService custService;
	
	@Resource
	private ICustLevelService levelService;
	
	/**
	 * 查询会员
	 * @param rc
	 * @param searchWords
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getCustLs")
	public String getCustLs(RequestContext rc,Cust cust,ModelMap model){
		logger.info("查询会员");
		if(cust == null){
			cust = new Cust();
		}else{
			if(cust.getUser_name()!=null){
				if(cust.getUser_name().equals("")){
					cust.setUser_name(null);
				}
			}
			if(cust.getNick_name()!=null){
				if(cust.getNick_name().equals("")){
					cust.setNick_name(null);
				}
			}
		}
		rc.attr("cust",cust);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<Cust> custLs = custService.getCustLs(cust);
		PageInfo<Cust> page = new PageInfo<Cust>(custLs);
		model.addAttribute("page", page);
		
		
		return CUST_PATH+"cust_list";
	}
	
	
	/**
	 * 修改会员
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateCust")
	public String toUpdateCust(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "id不能为空！");
			return CUST_PATH+"cust_list";
		}else{
			Cust cust =  custService.getCustById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			List<CustLevel> levelLs = levelService.getCustLevelLs(null);
			if(levelLs!=null&& levelLs.size()>0){
				rc.attr("levelLs",levelLs);
			}
			rc.attr("TOKEN", token);
			rc.attr("cust",cust);
		}
		
		return CUST_PATH+"cust_edit";
	}
	
	
	/**
	 * 添加或修改会员
	 * @param rc
	 * @param searchWords
	 * @return
	 */
	@RequestMapping("/updateCust")
	public String updateCust(RequestContext rc,Cust cust){
		
		if(!TokenHandler.validToken(rc.getRequest())){
			rc.attr("msg", "会员不能重复提交！");
			return CUST_PATH+"cust_edit";
		}else{
			String id = rc.get("id");
			if(!id.equals("") && id != null){
				cust.setId(Integer.parseInt(id));
				custService.updateByCustId(cust);
			}
		}
		
		return "forward:getCustLs";
	}
	
	
	/**
	 * 删除会员
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/delCust")
	public String delCust(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			Cust cust = new Cust();
			cust.setId(Integer.parseInt(id));
			cust.setIs_valid(2);
			custService.updateByCustId(cust);
		}else{
			rc.attr("msg", "id不能为空！");
			return CUST_PATH+"cust_list";
		}
		
		return "forward:getCustLs";
	}
	
}
