package cn.com.shukaiken.controller.role;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Menu;
import cn.com.shukaiken.model.Role;
import cn.com.shukaiken.service.IMenuService;
import cn.com.shukaiken.service.IRoleService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.DateTimeUtils;
import cn.com.shukaiken.util.TokenHandler;
import cn.com.shukaiken.util.ValidateUtils;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-10
 *
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	private Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	private static final String ROLE_PATH = "/admin/role/";//角色页面的路径
	
	@Resource
	private IRoleService roleService;
	
	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/getRoleLs")
	public String getRoleLs(RequestContext rc,Role role,ModelMap model){
		logger.info("查询角色");
		if(role == null){
			role = new Role();
		}else{
			if(role.getName()!=null){
				if(role.getName().equals("")){
					role.setName(null);
				}
			}
			rc.attr("role", role);
			rc.initPageHelper(Constant.PAGE_SIZE_TEN);
			List<Role> roleLs = roleService.getRoleLs(role);
			PageInfo<Role> page = new PageInfo<Role>(roleLs);
			model.addAttribute("page", page);
			
		}
		
		return ROLE_PATH+"role_list";
	}
	
	/**
	 * 创建角色
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toAddRole")
	public String toAddRole(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		rc.attr("type",1);
		return ROLE_PATH+"role_form";
	}
	
	/**
	 * 修改角色
	 * @param rc
	 * @return
	 */
	@RequestMapping("/toUpdateRole")
	public String toUpdateRole(RequestContext rc){
		String token = TokenHandler.generateGUID(rc.getSession());
		rc.attr("TOKEN", token);
		String id = rc.get("id");
		Role role = null;
		if(!id.equals("") && id != null){
			role = roleService.selectByPrimaryKey(Integer.parseInt(id));
		}
		rc.attr("type",2);
		rc.attr("role",role);
		return ROLE_PATH+"role_form";
	}
	
	/**
	 * 添加或修改
	 * @param rc
	 * @param power
	 * @return
	 */
	@RequestMapping("/addOrUpdateRole")
	public String addOrUpdateRole(HttpServletRequest request,RequestContext rc,Role role){
		if(!TokenHandler.validToken(request)){
			request.setAttribute("msg", "角色不能重复提交！");
			return ROLE_PATH+"role_form";
		}else{
			String type = rc.get("type");
			String id = rc.get("id");
			if(type.equals("1")){
				Role roleTemp = roleService.selectByName(role.getName());
				if(roleTemp!=null){
					rc.attr("msg", "该角色已经存在！");
					rc.attr("type",1);
					return ROLE_PATH+"role_form";
				}else{
					role.setIs_valid(0);
					role.setCreate_date(new Date());
					roleService.insert(role);
				}
				
			}else if(type.equals("2")){
				
				if(!id.equals("") && id != null){
					
					role.setId(Integer.parseInt(id));
					
					roleService.updateByPrimaryKeySelective(role);
				}
				
			}
			
		}
		
		return "forward:getRoleLs";
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping("/delRole")
	public String delRole(RequestContext rc){
		try {
			String id = rc.get("id");
			if(!id.equals("") && id != null){
				Role role = new Role();
				role.setIs_valid(2);
				role.setId(Integer.parseInt(id));
				roleService.updateByPrimaryKeySelective(role);
			}else{
				rc.attr("msg", "程序异常！");
				return ROLE_PATH+"role_list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:getRoleLs";
	}
	
	
	/**
	 * 判断角色是否可以删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/canDelRole")
	@ResponseBody
	public Map<String, Object> canDelRole(HttpServletRequest reuqest,HttpServletResponse response){
		String id = reuqest.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		if(id!=null && !id.equals("")){
			int count = roleService.canDelRole(id);
			if(count>0){//还在被使用
				map.put("result", 1);
			}else {//没有被使用
				map.put("result", 0);
			}
		}else{
			//id不能为空
			map.put("result", 2);
		}
		
		return map;
	}
	
	/**
	 * 跳转到角色设置权限页面
	 * @return
	 */
	@RequestMapping("/goSetMenu")
	public String goSetMenu(RequestContext rc){
		String id = rc.get("id");
		Role role = roleService.selectByPrimaryKey(Integer.parseInt(id));//查询菜单
		//List<Menu> menuLs = menuService.getRoleMenuLs(id);//根据角色查询菜单
		rc.attr("role", role);
		//rc.attr("menuLs", menuLs);
		return ROLE_PATH+"menu_set";
	}
	
	 /**
	 * 菜单列表
	 * @return
	 */
	@RequestMapping("/ajaxRolePowerList")
	@ResponseBody
	public JSONArray ajaxRolePowerList(RequestContext rc){
		String id =  rc.get("id");
		List<Menu> menuLs = menuService.getRoleMenuLs(id);//根据角色查询菜单
		//初始化JSONArray对象，并添加数据
		JSONArray array = new JSONArray();
		
		if(menuLs != null && menuLs.size() > 0){
			for (Menu menu : menuLs) {
				//初始化HashMap集合并添加数组
			    Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", menu.getId());
				map.put("pId", menu.getP_id());
				if(menu.getP_id()==Constant.TREE_ROOT_ID){
					map.put("open", "true");	
			    }
				map.put("name", menu.getMenu_name());
			    if((int)Integer.valueOf(menu.getUrl())>0){
					map.put("checked", "true");
				}
				array.add(map);
			}
			
		}
		
		return array;
		
	}
	
	/**
	 * 设置角色权限
	 * @param rc
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editRoleMenu")
	@ResponseBody
	@Transactional(rollbackFor=Exception.class)
	public Map<String,String> editRoleMenu(RequestContext rc,ModelMap model){
		String id = rc.get("id");
		logger.info("设置角色菜单"+",roleId="+(ValidateUtils.isEmpty(id)?"null":id)+",操作时间:"+DateTimeUtils.currentDateTime()+",操作人员:");
		Map<String,String> map = new HashMap<String,String>();
		String menus = rc.get("menusId");
		String[] ids = menus.split(",");
		try {
			if(ids!=null && ids.length>0){
				roleService.editRoleMenu(ids, id);
				map.put("success", "true");
				map.put("message", "角色菜单设置成功");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			map.put("success", "false");
			map.put("message", "角色菜单设置失败");
		}
		
		return map;
	}
	
}