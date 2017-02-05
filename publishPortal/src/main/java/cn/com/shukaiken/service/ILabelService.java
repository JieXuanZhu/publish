package cn.com.shukaiken.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import cn.com.shukaiken.model.Label;

public interface ILabelService {
	
	int addLabel(Label label);
	
	int updateByLabelId(Label label);
	
	Label getLabelById(int id);
	
    Label selectByLabel(Label label);
	
	List<Label> getLabelLs(Label label);
	
	List<Label> getLevelLs(Label label);
	
	int getSubCountById(Label label);

	/**
	 * @Title: addLabelTagRel 
	 * @Description: TODO
	 * @param @param labelId
	 * @param @param nodeIds
	 * @param @return
	 * @return int
	 * @throws 
	 */
	int addLabelTagRel(String labelId, String nodeIds);

	/**
	 * @param tagIds 
	 * @return 
	 * @Title: getLabelTree 
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws 
	 */
	JSONArray getLabelTree(String tagIds,String labelId);

	List<Label> selectLabelsByCondition(Label ql);

}
