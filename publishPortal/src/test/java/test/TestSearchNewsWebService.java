package test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import cn.com.shukaiken.webService.IAppNewsWebService;
import cn.com.shukaiken.util.JSONHelper;

public class TestSearchNewsWebService {
	
	public static void main(String[] args) {
		viewNews();
	}
	
	public static void getsSearchLs(){
		Service serviceModel = new ObjectServiceFactory().create(IAppNewsWebService.class);  
		IAppNewsWebService service;
		try {
			//service = (IAppNewsWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppNewsWebService");
			service = (IAppNewsWebService) new XFireProxyFactory().create(serviceModel,"http://192.168.1.186:8080/publish/service/IAppNewsWebService");
			//方法一 测试  
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("tag_id", 1);
			map.put("pageNum", 1);
			map.put("pageSize", 3);
			map.put("days",50);
			map.put("words", "经营");
			String jsonStr = JSONHelper.getJsonByMap(map);
			jsonStr = service.getSearchNews(jsonStr);
			System.out.println("jsonStr="+jsonStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}  
	}
	
	public static void viewNews(){
		Service serviceModel = new ObjectServiceFactory().create(IAppNewsWebService.class);  
		IAppNewsWebService service;
		try {
			//service = (IAppNewsWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppNewsWebService");
			service = (IAppNewsWebService) new XFireProxyFactory().create(serviceModel,"http://192.168.1.186:8080/publish/service/IAppNewsWebService");
			//方法一 测试  
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("info_id", 57);
			String jsonStr = JSONHelper.getJsonByMap(map);
		    jsonStr = service.viewNewsDetail(jsonStr);
			System.out.println("jsonStr="+jsonStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}  
	}


}
