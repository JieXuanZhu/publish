package cn.com.shukaiken.dao;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.InfoCheck;

@Repository
public interface InfoCheckDao {
    int deleteByPrimaryKey(Integer checkId);

    int insert(InfoCheck record);

    int insertSelective(InfoCheck record);

    InfoCheck selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(InfoCheck record);

    int updateByPrimaryKey(InfoCheck record);

	/**
	 * @Title: updateByInfoId 
	 * @Description: TODO
	 * @param @param infoId
	 * @return void
	 * @throws 
	 */
	int updateByInfoId(InfoCheck check);
}