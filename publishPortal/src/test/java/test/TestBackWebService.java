package test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import cn.com.shukaiken.util.JSONHelper;
import cn.com.shukaiken.webService.IAppBackFeedWebService;

public class TestBackWebService {
	public static void main(String[] args) {
		Service serviceModel = new ObjectServiceFactory().create(IAppBackFeedWebService.class);  
		IAppBackFeedWebService service;
		try {
			//service = (IAppNewsWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppNewsWebService");
			service = (IAppBackFeedWebService) new XFireProxyFactory().create(serviceModel,"http://192.168.1.186:8080/publish/service/IAppBackFeedWebService");
			//方法一 测试  
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cust_id", 2);
			map.put("content", "俄罗斯记者近日探访叙利亚政府军与武装分子在大马士革近郊的交火阵地，用镜头记录下叙利亚阿拉伯军女兵的战斗风采。");
			map.put("system", "安卓系统");
			map.put("model", "华为C8650");
			map.put("version", "7.1.5");
			map.put("contact", "18302185720");
			String jsonStr = JSONHelper.getJsonByMap(map);
		    jsonStr = service.addBackFeed(jsonStr);
			System.out.println("jsonStr="+jsonStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}  
	}
	
}
