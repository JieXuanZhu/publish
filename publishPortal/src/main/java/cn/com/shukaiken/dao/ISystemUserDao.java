package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.SystemUser;

public interface ISystemUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);
    
    SystemUser selectBySystemUser(SystemUser record);
    
    SystemUser login (SystemUser record);

    SystemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
    
    int deleteRecordByUserId(Integer record);
    
    List<SystemUser> getUserLs(SystemUser record);
    
}