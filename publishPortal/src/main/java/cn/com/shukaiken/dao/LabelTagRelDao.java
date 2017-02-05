package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.LabelTagRel;

@Repository
public interface LabelTagRelDao {
    int insert(LabelTagRel record);

    int insertSelective(LabelTagRel record);

	/**
	 * @Title: getLabelTagsByCondition 
	 * @Description: TODO
	 * @param @param qlt
	 * @param @return
	 * @return List<LabelTagRel>
	 * @throws 
	 */
	List<LabelTagRel> getLabelTagsByCondition(LabelTagRel qlt);

	/**
	 * @Title: updateRelByLabelId 
	 * @Description: TODO
	 * @param @param ultr
	 * @return void
	 * @throws 
	 */
	int updateRelByLabelId(LabelTagRel ultr);
}