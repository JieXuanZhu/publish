package cn.com.shukaiken.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.IRoleDao;
import cn.com.shukaiken.dao.IRoleMenuRelDao;
import cn.com.shukaiken.dao.ISystemUserDao;
import cn.com.shukaiken.model.Role;
import cn.com.shukaiken.model.RoleMenuRel;
import cn.com.shukaiken.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{
	@Resource
	private IRoleDao  roleDao;
	
	@Resource
	private IRoleMenuRelDao  relDao;
	
	@Resource
	private ISystemUserDao systemUserDao;

	@Override
	public void deleteByPrimaryKey(Integer id) {
		roleDao.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Role record) {
		roleDao.insert(record);
		
	}

	@Override
	public void insertSelective(Role record) {
		roleDao.insertSelective(record);
		
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		
		return roleDao.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(Role record) {
		roleDao.updateByPrimaryKeySelective(record);
		
	}

	@Override
	public void updateByPrimaryKey(Role record) {
		roleDao.updateByPrimaryKey(record);
		
	}

	@Override
	public List<Role> getRoleLs(Role record) {
		return roleDao.getRoleLs(record);
	}

	@Override
	public Role selectByName(String name) {
		return roleDao.selectByName(name);
	}
	
	/**
	 * 设置角色权限
	 * @param ids
	 * @param roleId
	 */
	@Transactional(rollbackFor=Exception.class)
	public void editRoleMenu(String[] ids,String roleId){
		if(ids!=null && ids.length>0){
			//删除角色权限的关系
			relDao.deleteByRoleId(Integer.parseInt(roleId));
			//添加角色权限关系
			for (int i = 0; i < ids.length; i++) {
				RoleMenuRel record = new RoleMenuRel();
				record.setRole_id(Integer.parseInt(roleId));
				record.setMenu_id(Integer.parseInt(ids[i]));
				record.setCreate_date(new Date());
				record.setIs_valid(0);
				relDao.insert(record);
			}
		}
		
	}

	@Override
	public List<Role> getUserRoleLs(String userId) {
		return roleDao.getUserRoleLs(userId);
	}

	@Override
	public int canDelRole(String id) {
		return roleDao.canDel(id);
	}

	
}
