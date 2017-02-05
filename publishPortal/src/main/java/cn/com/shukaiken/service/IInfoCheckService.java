/**
 * @Title: IInfoCheck.java 
* @Package cn.com.shukaiken.service 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:18:37 
* @version V1.0 
 */
package cn.com.shukaiken.service;

import cn.com.shukaiken.model.InfoCheck;

/**
 * @ClassName: IInfoCheck 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:18:37 
 * @author Zhao Xiang
 *
 */
public interface IInfoCheckService {

	/**
	 * @Title: addNewCheck 
	 * @Description: TODO
	 * @param @param check
	 * @return void
	 * @throws 
	 */
	public int addNewCheck(InfoCheck check);

	/**
	 * @Title: removeAllCheckByInfoId 
	 * @Description: TODO
	 * @param @param infoId
	 * @return void
	 * @throws 
	 */
	public int removeAllCheckByInfoId(Integer infoId);

}
