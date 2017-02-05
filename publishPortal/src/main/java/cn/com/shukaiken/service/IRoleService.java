package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.Role;

public interface IRoleService {
	
	void deleteByPrimaryKey(Integer id);

	void insert(Role record);

	void insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    Role selectByName(String name);

    void updateByPrimaryKeySelective(Role record);

    void updateByPrimaryKey(Role record);
    
    List<Role> getRoleLs(Role record);
    
    public void editRoleMenu(String[] ids,String roleId);
    
    List<Role> getUserRoleLs(String userId);
    
    int canDelRole(String id);
    
  
}
