package cn.com.shukaiken.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.Info;

@Repository
public interface InfoDao {
    int deleteByPrimaryKey(Integer infoId);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
    
	/**
	 * @Title: selectInfosByCondition 
	 * @Description: TODO
	 * @param @param info
	 * @param @return
	 * @return List<Info>
	 * @throws 
	 */
	List<Info> selectInfosByCondition(Info info);

	/**
	 * @Title: getInfoById 
	 * @Description: TODO
	 * @param @param infoId
	 * @param @return
	 * @return Info
	 * @throws 
	 */
	Info getInfoById(Integer infoId);

	int updateInfoByInfoIds(Map<String, Object> map);
	
	int updateInfoByInfo(Map<String, Object> map);

	List<Info> searchInfos(Map<String, Object> queryMap);
}