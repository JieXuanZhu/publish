package cn.com.shukaiken.webService;
/**
 * 用户反馈接口
 * @author jiexuan.zhu
 * @date 2015-11-23
 *
 */
public interface IAppBackFeedWebService {
	
	/**
	 * 
	 * @param jsonStr为 用户名id和 反馈内容、系统、机型、版本、联系方式的json字符串
	 *        主键分别为 cust_id、 content、system、model、version和  contact
	 * @return
	 */
	public String addBackFeed(String jsonStr);

}
