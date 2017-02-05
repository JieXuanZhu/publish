package cn.com.shukaiken.util;

/**
 * 保存分页信息的类
 * 
 */
public class PagerHelper {
	
	public static int startRow(int pageNum,int pageSize){
		int startRow = (pageNum - 1) * pageSize;
		return startRow;
	}

}
