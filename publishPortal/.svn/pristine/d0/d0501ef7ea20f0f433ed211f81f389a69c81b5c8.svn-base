package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Role;

public interface IRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByName(String name);
    
    Role selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(Role record);

    void updateByPrimaryKey(Role record);
    
    List<Role> getRoleLs(Role record);
    
    List<Role> getUserRoleLs(String userId);
    
    int canDel(String id);
}