package cn.com.shukaiken.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shukaiken.dao.ISystemUserDao;
import cn.com.shukaiken.dao.ISystemUserRoleRelDao;
import cn.com.shukaiken.model.SystemUser;
import cn.com.shukaiken.model.SystemUserRoleRel;
import cn.com.shukaiken.service.ISystemUserService;
/**
 * @ClassName: SystemUserServiceImpl 
 * @Description: <p>系统用户实现类</p>
 * @date 2015年11月7日 下午18:30:31 
 * @author jiexuan.zhu
 *
 */
@Service
public class SystemUserServiceImpl implements ISystemUserService{
	
	@Resource
	private ISystemUserDao systemUserDao;
	
	@Resource
	private ISystemUserRoleRelDao relDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return systemUserDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SystemUser record) {
		
		return systemUserDao.insert(record);
	}

	@Override
	public int insertSelective(SystemUser record) {
		
		return systemUserDao.insert(record);
	}

	@Override
	public SystemUser selectByPrimaryKey(Integer id) {
		
		return systemUserDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SystemUser record) {
		
		return systemUserDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SystemUser record) {
		
		return systemUserDao.updateByPrimaryKey(record);
	}

	@Override
	public SystemUser getSystemUserByName(SystemUser record) {
		return systemUserDao.selectBySystemUser(record);
	}

	@Override
	public SystemUser login(SystemUser record) {
		return systemUserDao.login(record);
	}

	@Override
	public List<SystemUser> getUserLs(SystemUser record) {
		
		return systemUserDao.getUserLs(record);
	}
	
	/**
	 * 设置角色权限
	 * @param ids
	 * @param roleId
	 */
	@Transactional(rollbackFor=Exception.class)
	public void editUserRole(String[] ids,int userId){
		
		if(ids!=null && ids.length>0){
			//删除角色权限的关系
			systemUserDao.deleteRecordByUserId(userId);
			//添加角色权限关系
			for (int i = 0; i < ids.length; i++) {
				SystemUserRoleRel record = new SystemUserRoleRel();
				record.setSystem_user_id(userId);
				record.setRole_id(Integer.parseInt(ids[i]));
				record.setCreate_date(new Date());
				record.setIs_valid(0);
				relDao.insert(record);
			}
			
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delUser(int id) {
		SystemUser user  = new SystemUser();
		user.setIs_valid(3);
		user.setId(id);
		systemUserDao.updateByPrimaryKeySelective(user);
		relDao.deleteBySystemUserId(id);
	}

}
