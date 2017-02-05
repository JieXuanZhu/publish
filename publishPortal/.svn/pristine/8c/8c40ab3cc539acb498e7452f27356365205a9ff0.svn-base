package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.InfoSearchWord;

@Repository
public interface InfoSerarchWordDao {
    int deleteByPrimaryKey(Integer wordId);

    int insert(InfoSearchWord record);

    int insertSelective(InfoSearchWord record);

    InfoSearchWord selectByPrimaryKey(Integer wordId);

    int updateByPrimaryKeySelective(InfoSearchWord record);

    int updateByPrimaryKey(InfoSearchWord record);

	/**
	 * @Title: selectByWord 
	 * @Description: TODO
	 * @param @param word
	 * @param @return
	 * @return List<InfoSearchWord>
	 * @throws 
	 */
	List<InfoSearchWord> selectByWord(InfoSearchWord infoWord);
	
	List<InfoSearchWord> selectByInfoId(Integer infoId);
}