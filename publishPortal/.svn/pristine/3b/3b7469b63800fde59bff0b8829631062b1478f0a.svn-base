package cn.com.shukaiken.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.InfoComment;

@Repository
public interface InfoCommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(InfoComment record);

    int insertSelective(InfoComment record);

    InfoComment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(InfoComment record);

    int updateByPrimaryKey(InfoComment record);
    
    List<InfoComment> getCommentLs(InfoComment record);
}