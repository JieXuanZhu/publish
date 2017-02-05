package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IMenuDao;
import cn.com.shukaiken.model.Menu;
import cn.com.shukaiken.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	
	@Resource
	private IMenuDao menuDao;
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return menuDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Menu record) {
	
		return menuDao.insert(record);
	}

	@Override
	public int insertSelective(Menu record) {
		
		return menuDao.insertSelective(record);
	}

	@Override
	public Menu selectByPrimaryKey(Integer id) {
		
		return menuDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		
		return menuDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Menu record) {

		return menuDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Menu> getAdminMenuLs() {
		
		return menuDao.getAdminMenuLs();
	}

	@Override
	public List<Menu> getLoginMenuLs(int userId) {
		
		return menuDao.getLoginMenuLs(userId);
	}

	@Override
	public List<Menu> getMenuLs(Menu menu) {
		
		return menuDao.getMenuLs(menu);
	}

	@Override
	public Menu selectByName(String menu_name) {
		
		return menuDao.selectByName(menu_name);
	}

	@Override
	public int canDelMenu(String id) {
		
		return menuDao.canDel(id);
	}

	@Override
	public List<Menu> getRoleMenuLs(String roleId) {
		
		return menuDao.getRoleMenuLs(roleId);
	}

	@Override
	public int getSubCountById(Menu record) {
		return menuDao.getSubCountById(record);
	}

}
