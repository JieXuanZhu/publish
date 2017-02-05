package cn.com.shukaiken.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.ISystemUserRoleRelDao;
import cn.com.shukaiken.model.SystemUserRoleRel;
import cn.com.shukaiken.service.ISystemUserRoleRelService;
@Service
public class SystemUserRoleRelServiceImpl implements ISystemUserRoleRelService {

	@Resource
	private ISystemUserRoleRelDao systemUserRoleRelDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {

		return systemUserRoleRelDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SystemUserRoleRel record) {
		
		return systemUserRoleRelDao.insert(record);
	}

	@Override
	public int insertSelective(SystemUserRoleRel record) {
		return systemUserRoleRelDao.insertSelective(record);
	}

	@Override
	public SystemUserRoleRel selectByPrimaryKey(Integer id) {
		return systemUserRoleRelDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SystemUserRoleRel record) {
	
		return systemUserRoleRelDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SystemUserRoleRel record) {
		
		return systemUserRoleRelDao.updateByPrimaryKey(record);
	}

}
