package cn.com.shukaiken.webService;

public interface IAppEditorWebService {
	
	/**
	 * 添加现场采编信息
	 * @param jsonStr为 用户名id、内容、图片data:经过base64加密的Lsit<byte[]>(byte[]由上传的图片File得来）的json字符串
	 *        主键分别为 cust_id、 content和  data
	 * @return
	 */
	public String addEditor(String jsonStr);
	
	/**
	 * 我的发布
	 * @param jsonStr为 用户名id、页号、分页数量的json字符串
	 * @return 主键为 cust_id、pageNum、pageSize
	 */
	public String viewPublishLs(String jsonStr);
	
	/**
	 * 出版圈
	 * @param jsonStr为页号、分页数量的json字符串
	 * 		主键分别为pageNum、pageSize
	 * @return
	 */
	public String getEditorLs(String jsonStr);
	
	
	/**
	 * 删除现场采编信息
	 * @param jsonStr为用户id、采编信息id的json字符串
	 * 		主键分别为cust_id、editor_id
	 * @return
	 */
	public String delEditorByCustId(String jsonStr);
	

}
