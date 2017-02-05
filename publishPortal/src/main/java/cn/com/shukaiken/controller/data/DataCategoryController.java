package cn.com.shukaiken.controller.data;

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
import cn.com.shukaiken.model.DataCategory;
import cn.com.shukaiken.service.IDataCategoryService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.TokenHandler;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/admin/category")
public class DataCategoryController {
	
	private Logger logger = LoggerFactory.getLogger(DataCategoryController.class);
	
	private static final String DATA_PATH = "/admin/data/";//数据来源页面的路径 
	
	@Resource
	private IDataCategoryService dataCategoryService;
	
	/**
	 * 查询数据来源
	 * @param rc
	 * @param dataCategory
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getDataCategoryLs")
	public String getDataCategoryLs(RequestContext rc,DataCategory dataCategory,ModelMap model){
		logger.info("查询数据来源");
		if(dataCategory == null){
			dataCategory = new DataCategory();
		}else{
			if(dataCategory.getCategory_name()!=null){
				if(dataCategory.getCategory_name().equals("")){
					dataCategory.setCategory_name(null);
				}
			}
		}
		
		rc.attr("dataCategory",dataCategory);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<DataCategory> dataCategoryLs = dataCategoryService.getDataCategoryLs(dataCategory);
		PageInfo<DataCategory> page = new PageInfo<DataCategory>(dataCategoryLs);
		model.addAttribute("page", page);
		
		return DATA_PATH+"data_category_list";
	}
	
	
	/**
	 * 创建数据来源
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddDataCategory")
	public String toAddDataCategory(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return DATA_PATH+"data_category_form";
	}
	
	/**
	 * 修改数据来源
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateDataCategory")
	public String toUpdateDataCategory(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && id.equals("")){
			rc.attr("msg", "程序异常！");
			return DATA_PATH+"data_category_form";
		}else{
			DataCategory dataCategory =  dataCategoryService.getDataCategoryById(Integer.parseInt(id));
			String token = TokenHandler.generateGUID(rc.getSession());
			rc.attr("TOKEN", token);
			rc.attr("type",2);
			rc.attr("dataCategory",dataCategory);
		}
		
		return DATA_PATH+"data_category_form";
	}
	
	
	/**
	 * 添加或修改数据来源
	 * @param rc
	 * @param dataCategory
	 * @return
	 */
	@RequestMapping("/addOrUpdateDataCategory")
	public String addOrUpdateDataCategory(HttpServletRequest request,RequestContext rc,DataCategory dataCategory){
		
		if(!TokenHandler.validToken(request)){
			rc.attr("msg", "数据来源不能重复提交！");
			return DATA_PATH+"data_category_form";
		}else{
			String type = rc.get("type");
			String id = rc.get("id");
			if(type.equals("1")){
				if(dataCategory!=null && !dataCategory.getCategory_name().equals("")){
					DataCategory  temp = new DataCategory();
					temp.setCategory_name(dataCategory.getCategory_name());
					temp.setIs_valid(0);
					temp = dataCategoryService.selectByDataCategory(dataCategory);
					if(temp==null){
						//继续往下走
						dataCategory.setIs_valid(0);
						dataCategory.setCreate_date(new Date());
						dataCategoryService.addDataCategory(dataCategory);
					}else{
						//数据来源已经存在
						rc.attr("type",1);
						rc.attr("msg", "该数据来源已经存在！");
						return DATA_PATH+"data_category_form";
					}
				}
			}else if(type.equals("2")){
				if(!id.equals("") && id != null){
					dataCategory.setId(Integer.parseInt(id));
					dataCategoryService.updateByDataCategoryId(dataCategory);
				}
			}
		}
		
		return "forward:getDataCategoryLs";
	}
	
	/**
	 * 删除数据来源
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/delDataCategory")
	public String delDataCategory(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			DataCategory dataCategory = new DataCategory();
			dataCategory.setId(Integer.parseInt(id));
			dataCategory.setIs_valid(2);
			dataCategoryService.updateByDataCategoryId(dataCategory);
			
		}else{
			rc.attr("msg", "程序异常！");
			return DATA_PATH+"data_category_list";
		}
		
		return "forward:getDataCategoryLs";
		
	}
	
	
	

}
