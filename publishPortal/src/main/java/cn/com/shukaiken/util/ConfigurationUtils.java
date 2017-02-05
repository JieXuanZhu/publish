package cn.com.shukaiken.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationUtils {
	
	
	public static String readValue(String key,String configPath){
		String str = null;
		try {
			String path = ConfigurationUtils.class.getClassLoader().getResource(configPath).toString();
			if(path.startsWith("file")){
				path = path.substring(5);
			}
			path.replace("/", File.separator);
		InputStream is = new BufferedInputStream(new FileInputStream(path));
		Properties pro = new Properties();
		pro.load(is);
		str =  pro.getProperty(key);
			if(str.equals(new String(str.getBytes("ISO8859-1"),"ISO8859-1"))){//如果是ISO-8859-1的编码，那么转出UTF-8输出 
				return new String(str.getBytes("ISO8859-1"),"UTF-8");
			}else if(str.equals(new String(str.getBytes("UTF-8"),"UTF-8"))){//如果是UTF-8的编码，那么直接返回
				return str;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
