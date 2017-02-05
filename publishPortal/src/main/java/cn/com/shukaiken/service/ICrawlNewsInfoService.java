/**
 * @Title: ICrawlNewsInfoService.java 
* @Package cn.com.shukaiken.service 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月29日 下午6:10:08 
* @version V1.0 
 */
package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.CrawlNewsInfo;
import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.model.TableInfo;

/**
 * @ClassName: ICrawlNewsInfoService 
 * @Description: <p>TODO</p>
 * @date 2015年11月29日 下午6:10:08 
 * @author Zhao Xiang
 *
 */
public interface ICrawlNewsInfoService {

	/**
	 * @Title: getSourceList 
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return List<CrawlNewsInfoSource>
	 * @throws 
	 */
	List<CrawlNewsInfoSource> getSourceList(CrawlNewsInfoSource source);

	/**
	 * @Title: getSourceById 
	 * @Description: TODO
	 * @param @param valueOf
	 * @param @return
	 * @return CrawlNewsInfoSource
	 * @throws 
	 */
	CrawlNewsInfoSource getSourceById(Integer valueOf);

	/**
	 * @Title: removeSourceById 
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int removeSourceById(CrawlNewsInfoSource source);

	/**
	 * @Title: selectTableInfo 
	 * @Description: TODO
	 * @param @param string
	 * @param @return
	 * @return List<TableInfo>
	 * @throws 
	 */
	List<TableInfo> selectTableInfo(String string);

	/**
	 * @Title: addNewNewsSource 
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int addNewNewsSource(CrawlNewsInfoSource source);

	/**
	 * @Title: modifyNewsSource 
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int modifyNewsSource(CrawlNewsInfoSource source);

	int addNewsInfo(CrawlNewsInfo info, CrawlNewsInfoSource source);

	/**
	 * @Title: updateNewsInfoSourceById 
	 * @Description: TODO
	 * @param @param sr
	 * @return void
	 * @throws 
	 */
	int updateNewsInfoSourceById(List<CrawlNewsInfoSource> sourcesList);

	List<CrawlNewsInfo> selectAllInfos(CrawlNewsInfo qInfo);

	CrawlNewsInfo getCrawlDataById(Integer valueOf);

}
