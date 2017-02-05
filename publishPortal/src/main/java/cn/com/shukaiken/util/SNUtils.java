package cn.com.shukaiken.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 产生各种序列号。基于UUID算法。
 * 
 * @author Gene.zhang
 * @date 2013-6-19
 */
public class SNUtils {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * 生成一个UUID。
	 * 
	 * @date 2013-6-19
	 * @return
	 */
	public static synchronized String createUUID() {
		String uid = UUID.randomUUID().toString().replace("-", "");
		return uid;
	}

	/**
	 * 产生一个年月日时分秒毫秒随机3位的数字组成的序列号
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @return
	 */
	public static synchronized String createTimeSn() {
		
		String ret = format.format(new Date());
		ret += createRndNumber(5);
		return ret;
	}
	/**
	 * 产生一个年月日时分秒毫秒随机3位的数字
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @return
	 */
	public static synchronized String createTimeSn(String prefix) {
		String ret = format.format(new Date());
		ret += createRndNumber(5);
		return prefix+ret;
	}
	/**
	 * 随机产生n个0~9之间的数字
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @param n 数字个数。
	 * @return
	 */
	public static String createRndNumber(int n) {
		String ret = "";
		for (int i = 0; i < n; i++) {
			ret += (int) (Math.random() * 10);
		}
		return ret;
	}

}
