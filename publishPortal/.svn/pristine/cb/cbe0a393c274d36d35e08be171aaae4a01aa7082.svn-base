/**
 * @Title: InfoBannerServiceImpl.java 
* @Package cn.com.shukaiken.service.impl 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月13日 上午11:26:42 
* @version V1.0 
 */
package cn.com.shukaiken.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.InfoBannerDao;
import cn.com.shukaiken.model.InfoBanner;
import cn.com.shukaiken.service.IInfoBannerService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: InfoBannerServiceImpl 
 * @Description: <p>TODO</p>
 * @date 2015年11月13日 上午11:26:42 
 * @author Zhao Xiang
 *
 */
@Service
@Transactional
public class InfoBannerServiceImpl implements IInfoBannerService {
	Logger logger = LoggerFactory.getLogger(InfoBannerServiceImpl.class);
	
	@Autowired
	private InfoBannerDao bannerDao;
	
	/* (non-Javadoc)
	 * <p>Title: addNewBanner</p> 
	 * <p>Description: </p> 
	 * @param banner
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#addNewBanner(cn.com.shukaiken.model.InfoBanner) 
	 */
	@Override
	public int addNewBanner(InfoBanner banner) throws Exception {
		int result = 0;
		if(banner!=null){
			try {
				logger.info("新增资讯的图片标题:infoId="+banner.getInfoId());
				bannerDao.insertSelective(banner);
				result = banner.getBanId();
			} catch (Exception e) {
				result = 0;
				logger.error("InfoBannerServiceImpl.addNewBanner.ERROR:"+e, e);
				e.printStackTrace();
				throw new RuntimeException("addNewBanner出错");
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * <p>Title: removeAllImageByInfoId</p> 
	 * <p>Description: </p> 
	 * @param infoId
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#removeAllImageByInfoId(java.lang.Integer) 
	 */
	@Override
	public int removeAllImageByInfoId(Integer infoId) {
		int result = 0;
		// TODO Auto-generated method stub
		logger.info("根据资讯的Id:"+infoId+",移除所有的banner图");
		if(infoId!=null){
			InfoBanner ban = new InfoBanner();
			ban.setIsValid(Constant.INVALID);
			ban.setInfoId(infoId);
			result = bannerDao.updateByInfoId(ban);
		}
		return result;
	}

	/* (non-Javadoc)
	 * <p>Title: updateBannerByIds</p> 
	 * <p>Description: </p> 
	 * @param bannerMap 
	 * @see cn.com.shukaiken.service.IInfoBannerService#updateBannerByIds(java.util.Map) 
	 */
	@Override
	public int updateBannerByIds(Map<String, Object> bannerMap) {
		
		return bannerDao.updateBannerByIds(bannerMap);
	}

	/* (non-Javadoc)
	 * <p>Title: removeAllImageByInfoIdAndNotInIds</p> 
	 * <p>Description: </p> 
	 * @param infoId
	 * @param bannerIds
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#removeAllImageByInfoIdAndNotInIds(java.lang.String, java.lang.String) 
	 */
	@Override
	public int removeAllImageByInfoIdAndNotInIds(String infoId, String bannerIds) {
		Map<String,Object> bannerMap = new HashMap<String,Object>();
		if(!ValidateUtils.isEmpty(bannerIds)){
			String []bannerIdArray = bannerIds.split(",");
			Integer[] ids = new Integer[bannerIdArray.length];
			for(int i=0;i<bannerIdArray.length;i++){
				ids[i] = Integer.parseInt(bannerIdArray[i]);
			}
			bannerMap.put("ids", ids);
		}else {
			bannerMap.put("ids", null);
		}
		bannerMap.put("isValid", Constant.INVALID);
		bannerMap.put("infoId", Integer.valueOf(infoId));
		
		return bannerDao.updateBannerByIdsAndInfoId(bannerMap);
	}

	/* (non-Javadoc)
	 * <p>Title: getIndexBannnerForBackByInfoId</p> 
	 * <p>Description: </p> 
	 * @param qBan
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#getIndexBannnerForBackByInfoId(cn.com.shukaiken.model.InfoBanner) 
	 */
	@Override
	public List<InfoBanner> getIndexBannnerForBackByInfoId(InfoBanner qBan) {
		// TODO Auto-generated method stub
		return bannerDao.selectIndexBannerForBackByInfoId(qBan);
	}

	/* (non-Javadoc)
	 * <p>Title: updateBannerById</p> 
	 * <p>Description: </p> 
	 * @param ban
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#updateBannerById(cn.com.shukaiken.model.InfoBanner) 
	 */
	@Override
	public int updateBannerById(InfoBanner ban) {
		return bannerDao.updateByPrimaryKeySelective(ban);
	}

	/* (non-Javadoc)
	 * <p>Title: getBannerById</p> 
	 * <p>Description: </p> 
	 * @param id
	 * @return 
	 * @see cn.com.shukaiken.service.IInfoBannerService#getBannerById(java.lang.Integer) 
	 */
	@Override
	public InfoBanner getBannerById(Integer id) {
		return bannerDao.selectByPrimaryKey(id);
	}
}
