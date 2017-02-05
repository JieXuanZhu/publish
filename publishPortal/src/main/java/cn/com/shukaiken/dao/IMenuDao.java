package cn.com.shukaiken.dao;

import java.util.List;

import cn.com.shukaiken.model.Menu;

public interface IMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);
    
    Menu selectByName(String menu_name);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> getAdminMenuLs();
    
    List<Menu> getLoginMenuLs(int userId);
    
    List<Menu> getMenuLs(Menu record);
    
    int canDel(String id);
    
    int getSubCountById(Menu record);
    
    List<Menu> getRoleMenuLs(String roleId);
}