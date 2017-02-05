package cn.com.shukaiken.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import cn.com.shukaiken.model.CrawlNewsInfo;

public class ReflectUtil {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		CrawlNewsInfo  info = (CrawlNewsInfo) Class.forName("cn.com.shukaiken.model.CrawlNewsInfo").newInstance();
		setAttrValue("title", "java", Class.forName("cn.com.shukaiken.model.CrawlNewsInfo"), info);
		System.err.println(info.getTitle());
		
		setter(info, "Subtitle", "oracle", String.class);
		System.err.println(info.getSubtitle());
		
		System.err.println(getter(info,"Subtitle"));

	}
	
	//根据class获取所有的属性
	public static List<String> getAllAttributes(Class<?> clazz){
		List<String> attrs = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for(int i = 0;i<fields.length;i++){
			attrs.add(fields[i].getName());
		}
		return attrs;
	}
	
	 /**
     * @param obj 操作的对象
     * @param att 操作的属性
     * */

    public static Object getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }

    /**
     * @param obj 操作的对象
     * @param att  操作的属性
     * @param value 设置的值
     * @param type 参数的属性
     * */

    public static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param attr 需要设置的属性
     * @param value 需要设置的值
     * @param clazz 对象的Class
     * @param obj 操作的对象
     */
    public static void setAttrValue(String attr,Object value,Class<?> clazz,Object obj){
    	
    	try {
			Field field = clazz.getDeclaredField(attr);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * @param attr
     * @return 去掉属性中的下划线并且转成小写
     */
    public static String formatAttr(String attr){
    	return attr.replace("_", "").toLowerCase();
    }

}
