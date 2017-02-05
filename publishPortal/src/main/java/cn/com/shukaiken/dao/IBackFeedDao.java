package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.BackFeed;

public interface IBackFeedDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BackFeed record);

    int insertSelective(BackFeed record);

    BackFeed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackFeed record);

    int updateByPrimaryKey(BackFeed record);
    
    BackFeed selectBySelective(BackFeed record);
    
    List<BackFeed> getBackFeedLs(BackFeed record);
    
    int batchBackFeed();
}