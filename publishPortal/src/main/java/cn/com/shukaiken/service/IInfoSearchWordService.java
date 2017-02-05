/**
 * @Title: IInfoSearchWordService.java 
* @Package cn.com.shukaiken.service 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月22日 下午3:53:46 
* @version V1.0 
 */
package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.InfoSearchWord;

/**
 * @ClassName: IInfoSearchWordService 
 * @Description: <p>TODO</p>
 * @date 2015年11月22日 下午3:53:46 
 * @author Zhao Xiang
 *
 */
public interface IInfoSearchWordService {

	/**
	 * @Title: addNewWord 
	 * @Description: TODO
	 * @param @param word
	 * @return void
	 * @throws 
	 */
	public int addNewWord(InfoSearchWord word,Integer infoId);

	/**
	 * @Title: getWordsByInfoId 
	 * @Description: TODO
	 * @param @param infoId
	 * @param @return
	 * @return List<InfoSearchWord>
	 * @throws 
	 */
	public List<InfoSearchWord> getWordsByInfoId(Integer infoId);

	/**
	 * @Title: removeAllByInfoId 
	 * @Description: TODO
	 * @param @param infoId
	 * @return void
	 * @throws 
	 */
	public int removeAllByInfoId(Integer infoId);

}
