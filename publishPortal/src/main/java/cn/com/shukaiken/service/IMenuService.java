package cn.com.shukaiken.service;

import java.util.List;

import cn.com.shukaiken.model.Menu;

public interface IMenuService {
	int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> getAdminMenuLs();
    
    List<Menu> getLoginMenuLs(int userId);

    List<Menu> getMenuLs(Menu record);
    
    Menu selectByName(String menu_name);
    
    int canDelMenu(String id);
    
    int getSubCountById(Menu record);
    
    List<Menu> getRoleMenuLs(String roleId);

}
