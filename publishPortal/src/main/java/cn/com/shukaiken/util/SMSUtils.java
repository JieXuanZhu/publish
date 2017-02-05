package cn.com.shukaiken.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SMSUtils {
	private static Logger log = LoggerFactory.getLogger(SMSUtils.class);
	
    public static void main(String[] args) {
		try {
			//send("18936962500", "【亿阳指财富官网】 您正在绑定该手机，验证码为888888，如非本人操作请致电021-61299140");
			System.err.println(genrateCode(6));
			//短信接口测试状态：移动OK，电信OK, 联通OK
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * 发送短信
     * @param number 手机号
     * @param content 内容
     * @return
     * @throws Exception
     */
    public static boolean send(String number,String content) throws Exception{
    	if(ValidateUtils.isEmpty(content) || ValidateUtils.isEmpty(number)){
    		return false; 
    	}
    	String sms_sdk = "15161669570";
    	String sms_code = Md5.getMD5("zy888888");
    	//String line = "http://112.4.190.73:8088/sdk/smssdk!mt.action";
    	String line = "http://sdk.4001185185.com/sdk/smssdk!mt.action";
    	String resulttype = ""; //默认是text,或者指定为xml
    	String subcode = "";    //子号码，4位以下数字
    	String rpt = "0";    //是否需要状态报告(默认为0,1表示需要)
    	
    	List<NameValuePair> list = new ArrayList<NameValuePair>();
		// 组成url字符串
		list.add(new BasicNameValuePair("sdk", sms_sdk));
		list.add(new BasicNameValuePair("code",  sms_code));
		list.add(new BasicNameValuePair("pwdtype", "md5"));
		list.add(new BasicNameValuePair("phones", number));
		list.add(new BasicNameValuePair("rpt", rpt));
		list.add(new BasicNameValuePair("msg", content));
		list.add(new BasicNameValuePair("resulttype", resulttype));
		list.add(new BasicNameValuePair("subcode", subcode));
		long begin = System.currentTimeMillis();
		String resStr = HttpUtils.doPostRequest(line, new UrlEncodedFormEntity(list, "UTF-8"));
		long end = System.currentTimeMillis();
		Date startDate = new Date(begin + 60 * 1000);
		Date endDate = new Date(end + 60 * 1000);
		String timeUnits = "毫秒,秒,分钟,小时前";
		log.info("短信发送结果： " + resStr + "  耗时：" + DateTimeUtils.getPassedDate(startDate, endDate, timeUnits));
		log.info("手机号："+ number);
		log.info("发送消息："+ content);
        System.out.println(resStr);
        if("发送成功".equals(resStr)){
        	log.info("短信发送成功:手机号= "+number+" ...!");
        	System.out.println("send success ...!");
        	return true;
        }
        
        return false;
    	
    }
    
    /**
     * 生产验证码
     * @param length
     * @return
     */
    public static String genrateCode(int length){
    	StringBuffer code= new StringBuffer();
    	Random r = new Random();
		//String verify_code = "" + (r.nextInt(899999)+100000);
		for(int i =0;i<length;i++){
			code.append(r.nextInt(9));
		}
		return code.toString();
    }
}
