package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Editor;

public interface IEditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Editor record);

    int insertSelective(Editor record);

    Editor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Editor record);

    int updateByPrimaryKey(Editor record);
    
    Editor selectBySelective(Editor record);
    
    List<Editor> getEditorLs(Editor record);
    
    List<Editor> getEditorBySelectiveLs(Editor record);
}