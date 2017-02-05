package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Label;

public interface ILabelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);
    
    Label selectBySelective(Label record);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
    
    int getSubCountById(Label label);
    
    List<Label> getLabelLs(Label label);
    
    List<Label> getLevelLs(Label label);
    
    List<Label> getLabelsByCondition(Label label);
}