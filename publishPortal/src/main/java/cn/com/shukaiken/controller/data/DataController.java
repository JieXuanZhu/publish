package cn.com.shukaiken.controller.data;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Data;
import cn.com.shukaiken.service.IDataService;
import cn.com.shukaiken.util.Constant;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin/data")
public class DataController {
	
	private Logger logger = LoggerFactory.getLogger(DataController.class);
	
	private static final String DATA_PATH = "/admin/data/";//数据页面的路径 
	
	@Resource
	private IDataService dataService;
	
	/**
	 * 查询数据
	 * @param rc
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getDataLs")
	public String getDataLs(RequestContext rc,Data data,ModelMap model){
		logger.info("查询数据");
		if(data == null){
			data = new Data();
		}else{
			if(data.getTitle()!=null){
				if(data.getTitle().equals("")){
					data.setTitle(null);
				}
			}
		}
		
		rc.attr("data",data);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<Data> dataLs = dataService.getDataLs(data);
		PageInfo<Data> page = new PageInfo<Data>(dataLs);
		model.addAttribute("page", page);
		
		return DATA_PATH+"data_list";
	}
	

}
