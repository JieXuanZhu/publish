package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.Tag;

@Repository
public interface TagDao {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

	/**
	 * @Title: selectByCondition 
	 * @Description: TODO
	 * @param @param tag
	 * @param @return
	 * @return List<Tag>
	 * @throws 
	 */
	List<Tag> selectByCondition(Tag tag);

	/**
	 * @Title: getAllTagsByLabel 
	 * @Description: TODO
	 * @param @param qlt
	 * @param @return
	 * @return List<LabelTagRel>
	 * @throws 
	 */
	List<Tag> getAllTagsByLabel(Integer labelId);
	
	List<Tag> selectByInfoId(Integer infoId);
}