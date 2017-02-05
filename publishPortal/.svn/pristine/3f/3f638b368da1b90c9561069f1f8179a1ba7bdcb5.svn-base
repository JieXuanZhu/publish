package cn.com.shukaiken.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.InfoBanner;

@Repository
public interface InfoBannerDao {
    int deleteByPrimaryKey(Integer banId);

    int insert(InfoBanner record);

    int insertSelective(InfoBanner record);

    InfoBanner selectByPrimaryKey(Integer banId);

    int updateByPrimaryKeySelective(InfoBanner record);

    int updateByPrimaryKey(InfoBanner record);

	/**
	 * @Title: updateByInfoId 
	 * @Description: TODO
	 * @param @param ban
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int updateByInfoId(InfoBanner ban);

	/**
	 * @Title: updateBannerByIds 
	 * @Description: TODO
	 * @param @param bannerMap
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int updateBannerByIds(Map<String, Object> bannerMap);
	
	List<InfoBanner> selectByInfoId(Integer infoId);

	/**
	 * @Title: updateBannerByIdsAndInfoId 
	 * @Description: TODO
	 * @param @param bannerMap
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int updateBannerByIdsAndInfoId(Map<String, Object> bannerMap);
	
	/**
	 * @Title: selectIndexBannerByInfoId 
	 * @Description: 查询IndexBanner供前端展示
	 * @param @param infoBan
	 * @param @return
	 * @return List<InfoBanner>
	 * @throws 
	 */
	List<InfoBanner> selectIndexBannerByInfoId(InfoBanner infoBan);
	
	/**
	 * @Title: selectIndexBannerForBackByInfoId 
	 * @Description: TODO 查询IndexBanner 供后台修改查看用
	 * @param @param infoBan
	 * @param @return
	 * @return List<InfoBanner>
	 * @throws 
	 */
	List<InfoBanner> selectIndexBannerForBackByInfoId(InfoBanner infoBan);
	
}