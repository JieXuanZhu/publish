package cn.com.shukaiken.dao;

import cn.com.shukaiken.model.CustRole;

public interface CustRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustRole record);

    int insertSelective(CustRole record);

    CustRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustRole record);

    int updateByPrimaryKey(CustRole record);
}