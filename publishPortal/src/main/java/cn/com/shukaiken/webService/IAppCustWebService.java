package cn.com.shukaiken.webService;

/**
 * 登录、注册、个人中心接口
 * @author jiexuan.zhu
 * @date 2015-11-22
 *
 */
public interface IAppCustWebService {
	/**
	 * 获取注册手机验证码
	 * @param user_name 用户名（手机号）的json字符串
	 * @return
	 */
	public String getValidCode(String jsonStr);
	
	/**
	 * 注册方法
	 * @param user_name 用户名（手机号）的json字符串
	 * @return
	 */
	public String addCust(String jsonStr);
	
	/**
	 * 获取登录手机验证码
	 * @param user_name 用户名（手机号）的json字符串
	 * @return
	 */
	public String getLoginValidCode(String jsonStr);
	
	/**
	 * 登录
	 * @param user_name 用户名（手机号）
	 * @param 
	 * @return
	 */
	public String login(String jsonStr);
	

	/**
	 * 设置昵称
	 * @param cust_id 用户id
	 * @param nick_name 昵称的json字符串
	 * @return
	 */
	public String setCustNickName(String jsonStr);
	
	/**
	 * 设置头像
	 * @param cust_id  用户id
	 * @param data:经过base64加密的byte[](byte[]由上传的图片File得来）
	 * @return
	 */
	public String setCustHeadImg(String jsonStr);
	
	/**
	 * 绑定手机号
	 * @param cust_id 用户id
	 * @param mobile 微信号
	 * @return
	 */
	public String boundMobile(String jsonStr);
	
	/**
	 * 绑定微信号
	 * @param cust_id 用户id
	 * @param wei_xin 微信号
	 * @return
	 */
	public String boundWei_xin(String jsonStr);
	
	
	/**
	 * 绑定qq号
	 * @param cust_id 用户id
	 * @param qq QQ号
	 * @return
	 */
	public String boundQQ(String jsonStr);
	
	/**
	 * 绑定微博号
	 * @param cust_id 用户id
	 * @param sina_wei_bo 新浪微博号
	 * @return
	 */
	public String boundSina_wei_bo(String jsonStr);
	
	
	/**
	 * 修改密码
	 * @param cust_id 用户id
	 * @param password 密码   （传过来的已经过加密）
	 * @return
	 */
	public String updatePassword(String jsonStr);
	
	
}
