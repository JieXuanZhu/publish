package cn.com.shukaiken.util;

/**
 * 对数据进行MD5加密 <br>
 * Copyright (c) 2009 <br>
 * newGlobe <br>
 * @author Blank.
 * 
 * @version $Revision: 1.3 $ $Date: 2014/06/30 03:48:34 $ 
 *
 */
import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class Md5 {

	private static final Logger logger = Logger.getLogger(Md5.class);

	public Md5(){
	}

	public static String getMD5(String sourceStr)
	{
		logger.debug("正在对数据进行加密,现返回加密值...");
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		try
		{
			byte[] strTemp = sourceStr.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移

				str[k++] = hexDigits[byte0 & 0xf];  // 取字节中低 4 位的数字转换
			}
			return new String(str);
		}
		catch (Exception e)
		{
			logger.info("对数据加密失败...");
			return null;
		} 
	} 
	
	public static void main(String[] args) {
		System.out.println(Md5.getMD5("1234567"));
		System.out.println("fcea920f7412b5da7be0cf42b8c93759");
	}

}
