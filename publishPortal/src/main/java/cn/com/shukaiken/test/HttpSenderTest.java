package cn.com.shukaiken.test;

import cn.com.shukaiken.util.HttpSender;

public class HttpSenderTest {
	public static void main(String[] args) {
		String url = "http://222.73.117.158/msg/";// 应用地址
		String account = "jiekou-clcs-03";// 账号
		String pswd = "Admin888";// 密码
		String mobile = "18302185720,";// 手机号码，多个号码使用","分割
		String msg = "您好，您的验证码是123456";// 短信内容
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = null;// 产品ID
		String extno = null;// 扩展码

		try {
			//String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			String returnString = HttpSender.aliSend("18936962500", "{\"code\":\"123456\",\"product\":\"出版头条\"}", "SMS_3480223", "登录验证");
			
			System.out.println(returnString);
			// 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// 处理异常
			e.printStackTrace();
		}
	}
}
