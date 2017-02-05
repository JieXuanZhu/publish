package cn.com.shukaiken.controller.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Role;
import cn.com.shukaiken.model.SystemUser;
import cn.com.shukaiken.service.IRoleService;
import cn.com.shukaiken.service.ISystemUserRoleRelService;
import cn.com.shukaiken.service.ISystemUserService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.Md5;

import com.github.pagehelper.PageInfo;
/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-12
 *
 */
@Controller
@RequestMapping(value="/admin/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
		
	private static final String USER_PATH = "/admin/user/";//角色页面的路径
	
	@Resource
    private ISystemUserService userService;
	
	@Resource
    private IRoleService roleService;
	

	@Resource
    private ISystemUserRoleRelService systemUserRoleRelService;
	
	
	@RequestMapping("/getUserLs")
	public String getUserLs(RequestContext rc,SystemUser user,ModelMap model){
		logger.info("查询管理员");
		if(user == null){
			user = new SystemUser();
		}else{
			if(user.getName()!=null){
				if(user.getName().equals("")){
					user.setName(null);
				}
			}
		}
		rc.attr("user",user);
		rc.initPageHelper(Constant.PAGE_SIZE_TEN);
		List<SystemUser> userLs = userService.getUserLs(user);
		PageInfo<SystemUser> page = new PageInfo<SystemUser>(userLs);
		model.addAttribute("page", page);
		
		return USER_PATH+"user_list";
	}
	
	/**
	 * 跳转到添加管理员页面
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(RequestContext rc){
		try {
			List<Role> roleLs = roleService.getRoleLs(null);
			rc.attr("roleLs", roleLs);
			rc.attr("type", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return USER_PATH+"user_form";
	}
	
	/**
	 * 跳转到管理员修改页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toEditUser")
	public String toEditUser(RequestContext rc){
		String  id = rc.get("id");		
		SystemUser user = userService.selectByPrimaryKey(Integer.parseInt(id));
		List<Role> roleLs = roleService.getUserRoleLs(id);
		rc.attr("roleLs", roleLs);
		rc.attr("user", user);	
		rc.attr("type", "2");
		return USER_PATH+"user_edit";
	}
	
	/**
	 * 跳转到重置密码页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/goSetPassword")
	public String goSetPassword(RequestContext rc){
		String  id = rc.get("id");		
		SystemUser user = userService.selectByPrimaryKey(Integer.parseInt(id));
		rc.attr("user", user);	
		rc.attr("type", "3");
		return USER_PATH+"set_password";
	}
	
	/**
	 * 添加/修改 管理员用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/editUser")
	@Transactional(rollbackFor=Exception.class)
	public String editUser(RequestContext rc){
		String type = rc.get("type");
		String id = rc.get("id");
		String name = rc.get("name");
		String[] ids = rc.getValues("roles");//角色id数组
		String password = rc.get("password");
		String surepwd = rc.get("surepwd");
		if("1".equals(type)){
			if(!password.equals(surepwd)){
				List<Role> roleLs = roleService.getRoleLs(null);
				rc.attr("roleLs", roleLs);
				rc.attr("type", "1");
				rc.attr("msg", "2次密码输入不一致！");
				return USER_PATH+"user_form";
			}
		}
		
		if("1".equals(type)){//新增用户
			SystemUser user = new SystemUser();
			user.setName(name);
			user.setIs_valid(0);
			SystemUser userTemp = userService.getSystemUserByName(user);
			if(userTemp==null){
				user.setPassword(Md5.getMD5(password));
				user.setCreate_date(new Date());
				userService.insert(user);
				user = userService.getSystemUserByName(user);
				userService.editUserRole(ids, user.getId());
				
			}else{
				List<Role> roleLs = roleService.getRoleLs(null);
				rc.attr("roleLs", roleLs);
				rc.attr("type", "1");
				rc.attr("msg", "该管理员信息已经存在！");
				return USER_PATH+"user_form";
			}
		}
		if("2".equals(type)){//修改用户
			SystemUser user = new SystemUser();
			user.setName(name);
			user.setId(Integer.parseInt(id));
			try {
				userService.updateByPrimaryKeySelective(user);
				
				userService.editUserRole(ids, user.getId());;
			} catch (Exception e) {
				e.printStackTrace();
			    user = userService.selectByPrimaryKey(Integer.parseInt(id));
				List<Role> roleLs = roleService.getUserRoleLs(id);
				rc.attr("roleLs", roleLs);
				rc.attr("user", user);	
				rc.attr("type", "2");
				rc.attr("msg", "管理员设置角色失败！");
				return USER_PATH+"user_edit";
			}
			
		}
		//修改用户密码
		if("3".equals(type)){//修改用户
			SystemUser user = new SystemUser();
			user.setPassword(Md5.getMD5(password));
			user.setId(Integer.parseInt(id));
			userService.updateByPrimaryKeySelective(user);
		}
		return "forward:getUserLs";
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @return
	 */
	@RequestMapping("/delUser")
	public String delUser(RequestContext rc){
		String id = rc.get("id");
		if(id!=null && !id.equals("")){
			try {
				userService.delUser(Integer.parseInt(id));
			} catch (Exception e) {
				logger.error(e.toString());
				e.printStackTrace();
				rc.attr("msg", "删除管理员失败！");
				return "forward:getUserLs";
			}
		}else{
			rc.attr("msg", "程序异常！");
			return USER_PATH+"user_list";
		}
		
		return "forward:getUserLs";
	}

}
