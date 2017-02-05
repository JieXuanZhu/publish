package cn.com.shukaiken.dao;

import cn.com.shukaiken.model.CustSurplusCount;

public interface CustSurplusCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustSurplusCount record);

    int insertSelective(CustSurplusCount record);

    CustSurplusCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustSurplusCount record);

    int updateByPrimaryKey(CustSurplusCount record);
}