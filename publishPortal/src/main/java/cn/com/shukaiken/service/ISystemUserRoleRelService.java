package cn.com.shukaiken.service;

import cn.com.shukaiken.model.SystemUserRoleRel;

public interface ISystemUserRoleRelService {
	int deleteByPrimaryKey(Integer id);

    int insert(SystemUserRoleRel record);

    int insertSelective(SystemUserRoleRel record);

    SystemUserRoleRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUserRoleRel record);

    int updateByPrimaryKey(SystemUserRoleRel record);

}
