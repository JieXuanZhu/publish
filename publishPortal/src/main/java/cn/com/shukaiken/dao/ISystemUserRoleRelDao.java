package cn.com.shukaiken.dao;

import cn.com.shukaiken.model.SystemUserRoleRel;

public interface ISystemUserRoleRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUserRoleRel record);

    int insertSelective(SystemUserRoleRel record);

    SystemUserRoleRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserRoleRel record);

    int updateByPrimaryKey(SystemUserRoleRel record);
    
    int deleteBySystemUserId(Integer id);
}