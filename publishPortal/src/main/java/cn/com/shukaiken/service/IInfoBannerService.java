/**
 * @Title: IInfoBannerService.java 
* @Package cn.com.shukaiken.service 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:18:20 
* @version V1.0 
 */
package cn.com.shukaiken.service;

import java.util.List;
import java.util.Map;

import cn.com.shukaiken.model.InfoBanner;

/**
 * @ClassName: IInfoBannerService 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:18:20 
 * @author Zhao Xiang
 *
 */
public interface IInfoBannerService {

	/**
	 * @throws Exception 
	 * @Title: addNewBanner 
	 * @Description: TODO
	 * @param @param banner
	 * @return int
	 * @throws 
	 */
	public int addNewBanner(InfoBanner banner) throws Exception;

	/**
	 * @Title: removeAllImageByInfoId 
	 * @Description: TODO
	 * @param @param infoId
	 * @return void
	 * @throws 
	 */
	public int removeAllImageByInfoId(Integer infoId);

	/**
	 * @Title: updateBannerByIds 
	 * @Description: TODO
	 * @param @param bannerMap
	 * @return void
	 * @throws 
	 */
	public int updateBannerByIds(Map<String, Object> bannerMap);

	/**
	 * @Title: removeAllImageByInfoIdAndNotInIds 
	 * @Description: TODO
	 * @param @param infoId
	 * @param @param bannerIds
	 * @return void
	 * @throws 
	 */
	public int removeAllImageByInfoIdAndNotInIds(String infoId, String bannerIds);

	/**
	 * @Title: getIndexBannnerForBackByInfoId 
	 * @Description: TODO
	 * @param @param qBan
	 * @param @return
	 * @return List<InfoBanner>
	 * @throws 
	 */
	public List<InfoBanner> getIndexBannnerForBackByInfoId(InfoBanner qBan);

	/**
	 * @Title: updateBannerById 
	 * @Description: TODO
	 * @param @param ban
	 * @return void
	 * @throws 
	 */
	public int updateBannerById(InfoBanner ban);

	/**
	 * @Title: getBannerById 
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return InfoBanner
	 * @throws 
	 */
	public InfoBanner getBannerById(Integer id);

}
