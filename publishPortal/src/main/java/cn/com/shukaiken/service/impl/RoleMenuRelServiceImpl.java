package cn.com.shukaiken.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IRoleMenuRelDao;
import cn.com.shukaiken.model.RoleMenuRel;
import cn.com.shukaiken.service.IRoleMenuRelService;
@Service
public class RoleMenuRelServiceImpl implements IRoleMenuRelService {
	
	@Resource
	private IRoleMenuRelDao roleMenuRelDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {

		return roleMenuRelDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RoleMenuRel record) {
		
		return roleMenuRelDao.insert(record);
	}

	@Override
	public int insertSelective(RoleMenuRel record) {
		return roleMenuRelDao.insertSelective(record);
	}

	@Override
	public RoleMenuRel selectByPrimaryKey(Integer id) {
		return roleMenuRelDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(RoleMenuRel record) {
	
		return roleMenuRelDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RoleMenuRel record) {
		
		return roleMenuRelDao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByRoleId(Integer id) {
		
		return roleMenuRelDao.deleteByRoleId(id);
	}

}
