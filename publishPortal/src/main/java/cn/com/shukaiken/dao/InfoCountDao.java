package cn.com.shukaiken.dao;

import org.springframework.stereotype.Repository;

import cn.com.shukaiken.model.InfoCount;

@Repository
public interface InfoCountDao {
    int deleteByPrimaryKey(Integer countId);

    int insert(InfoCount record);

    int insertSelective(InfoCount record);

    InfoCount selectByPrimaryKey(Integer countId);

    int updateByPrimaryKeySelective(InfoCount record);

    int updateByPrimaryKey(InfoCount record);
}