package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Data;

public interface IDataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKeyWithBLOBs(Data record);

    int updateByPrimaryKey(Data record);
    
    Data selectBySelective(Data record);
    
    List<Data> getDataLs(Data record);
}