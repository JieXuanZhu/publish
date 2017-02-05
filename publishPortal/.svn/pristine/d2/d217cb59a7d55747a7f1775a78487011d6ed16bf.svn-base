package cn.com.shukaiken.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 把HshMap转换成json
 * @author jiexuan.zhu
 * 
 */
public class JSONHelper {
	 /*
     * 功能      ：将json转成map
     * 参数      ：json字符串
     * return : map
     * 
     * */
	// {id:'id1',code:'code1',name:'name1'}
	public static Map<String, Object> getMapByJson(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject object = JSONObject.fromObject(json);
		for (Object k : object.keySet()) {
			Object v = object.get(k);
			map.put(k.toString(), v);
		}
		return map;
	}
	
	/* 功能      ：将一个map转成json对象
     * 参数      ：map
     * return ：json对象
	 * Map<String,Object> map = new HashMap<String,Object>(); 
	 * map.put("users", users); 
	 * map.put("u", u);
	 */
	@SuppressWarnings("rawtypes")
	public static String getJsonByMap(Map map) {
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Object> removeRepeat(List<Object> list){
		HashMap<Integer, Object> set = new HashMap<Integer, Object>();
	        for(int i =0 ;i<list.size();i++){
	    	  Object t = list.get(i);    
	          set.put(t.hashCode() ,t);  //相同对象属性.有相同id.将id转换为字符串.作为hashmap key值;
	                                  //   hashmap会自动过滤key中字符串相等的元素.从而进行相同对象属性过滤;
        } 
        list.clear();
        for (Iterator it = set.entrySet().iterator(); it.hasNext();) {
			Entry e = (Entry) it.next();
			list.add(e.getValue());
		}
		return list;
	}
	
	/** 
     * 将一个json字串转为list 
     * @param props 
     * @return 
     */  
	@SuppressWarnings("unchecked")
	public static List<String> getListByJsonString(String jsonStr){  
        if (jsonStr == null || jsonStr.equals("")) {
        	 return new ArrayList<String>();  
        }
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
        List<String> list = (List<String>) JSONArray.toCollection(jsonArray,Object.class);
        return list;  
    }  
      
    /** 
     *  
     * 将一个 Object对象的List 生成Json字串 
     * 是根据客户端页面用户输入的信息生成的 
     *  
     *  
     */  
    public static String getJsonByList(List<Object> list) {  
    	
        JSONArray jsonarray = JSONArray.fromObject(list);  
  
        return jsonarray.toString();  
    }  

}