package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.EditorImg;

public interface IEditorImgDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EditorImg record);

    int insertSelective(EditorImg record);

    EditorImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EditorImg record);

    int updateByPrimaryKey(EditorImg record);
    
    EditorImg selectBySelective(EditorImg record);
    
    List<EditorImg> getEditorImgLs(EditorImg record);
    
    List<EditorImg> getEditorImgByEditorIdLs(Integer editor_id);
}