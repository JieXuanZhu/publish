package cn.com.shukaiken.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shukaiken.controller.base.RequestContext;
import cn.com.shukaiken.model.Menu;
import cn.com.shukaiken.model.SystemUser;
import cn.com.shukaiken.service.IMenuService;
import cn.com.shukaiken.service.ISystemUserService;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.DateTimeUtils;
import cn.com.shukaiken.util.PictureCheckCodeUtil;
import cn.com.shukaiken.util.SysConfig;
import cn.com.shukaiken.util.tree.etree.EuiTreeJsonL;
import cn.com.shukaiken.util.tree.etree.EuiTreeNodeL;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @author jiexuan.zhu
 * @date   2015-11-07
 *
 */
@Controller
public class AdminLoginController {
	
	private Logger logger = Logger.getLogger(AdminLoginController.class);
	/**
	 * 管理员信息服务类
	 */
	@Resource
	private ISystemUserService systemUserService;
	
	/**
	 * 权限信息服务类
	 */
	@Resource
	private IMenuService menuService;
	
	/**
	 * 超级管理员信息服务类
	 */
	@Resource
	private SysConfig sysConfig;
	
	/**
	 * 到后台登陆页面
	 * @return
	 */
	@RequestMapping("/admin")
	public String toBackLogin(HttpServletRequest request){
		
		return "admin/login";
	}
	
	/**
	 * 到后台登陆页面
	 * @return
	 */
	@RequestMapping("/admin/login")
	public String toBackendLogin(HttpServletRequest request){
		
		return "admin/login";
	}
	
	/**
	 * 后台登录成功页面(欢迎页）
	 * @return
	 */
	@RequestMapping(value="/admin/index")
	public String index(){
		return "admin/welcome";
	}
	
	/**
	 * frameset头部
	 * @return
	 */
	@RequestMapping(value="/admin/header")
	public String header(){
		return "admin/header";
	}
	
	/**
	 * frameset底部
	 * @return
	 */
	@RequestMapping(value="/admin/footer")
	public String footer(){
		return "admin/footer";
	}
	

	/**
	 * frameset左部
	 * @return
	 */
	@RequestMapping(value="/admin/left")
	public String left(){
		return "admin/left";
	}
	
	/**
	 * 后台登录成功页面(欢迎页）
	 * @return
	 */
	@RequestMapping(value="/admin/welcome")
	public String welcome(){
		return "admin/welcome";
	}
	
	/**
	 * 后台登陆
	 * @param request
	 * @return
	 */
	@RequestMapping("/dologin")
	public String login(RequestContext rc){
		try {
			String name = rc.get("username");
			String pwd = rc.get("password");
			String validCode = rc.get("captcha");
			/*String sessionValidCode = (String)rc.session("validCode");
			if(!sessionValidCode.equals(validCode.toUpperCase())){
				rc.attr("msg", "验证码输入错误");
				rc.attr("name",name);
				return "forward:/admin/login";
			}*/
			SystemUser systemUser = new SystemUser();
			systemUser.setName(name);
			systemUser.setPassword(pwd);
			SystemUser admin = systemUserService.login(systemUser);
			if(admin!=null){
				  rc.session("systemUser", admin);
				  logger.info("登录"+"操作时间:"+DateTimeUtils.currentDateTime()+",操作人员:"+admin.getName());
			}else {
				rc.attr("msg", "用户名或者密码错误");
				rc.attr("name",name);
				return "forward:/admin/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/login";
		}
		return "admin/main";
	}
	
	/***
	 * 生成验证码图片
	 */
	@RequestMapping("/getCode")
	public String getCode(HttpServletRequest request,HttpServletResponse response){	

		try{			
			ImageIO.write(PictureCheckCodeUtil.getCode(request, response, 98, 28, 20, 15, 23),"png",response.getOutputStream());			

		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			return "error/error";
		}					
		return null;
	}
	
     /**
	 * 动态获取菜单列表
	 * @return
	 */
	@RequestMapping("/admin/ajaxMenuList")
	@ResponseBody
	public List<EuiTreeNodeL> ajaxOrderList(RequestContext rc){
		SystemUser admin = (SystemUser) rc.session("systemUser");
		List<Menu> menuLs = null;
		try {		
			if(admin.getId()==Integer.parseInt(sysConfig.getAdminId())){//超级管理员
				menuLs = menuService.getAdminMenuLs();
			}else {
				menuLs = menuService.getLoginMenuLs(admin.getId());
			}
			rc.session("menuLs", menuLs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//组装菜单栏所需数据
		List<EuiTreeNodeL> tree = new ArrayList<EuiTreeNodeL>();
		if(menuLs != null && menuLs.size() > 0){
			for (Menu menu : menuLs) {
				EuiTreeNodeL node = new EuiTreeNodeL();
				node.setId(menu.getId().longValue());
				node.setPid(menu.getP_id().longValue());
				node.setState("off");
				node.setText(menu.getMenu_name());
				JSONObject attrs = new JSONObject();
				attrs.put("title", menu.getMenu_name());
				
				if(!menu.getUrl().equals("javascript:void(0);")){
					attrs.put("href", rc.getRequest().getContextPath()+"/"+menu.getUrl());
				}else{
					attrs.put("href", menu.getUrl());
				}
				
				node.setAttributes(attrs);
				tree.add(node);
			}
			
			tree = EuiTreeJsonL.buildtree(tree, Constant.TREE_ROOT_ID.longValue());
		}
		
		return tree;
		
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(RequestContext rc){
		rc.removeSession("account");
		return "redirect:/admin/login";
	}
	
	/**
	 * 帮助页面
	 * @param rc
	 * @return
	 */
	@RequestMapping(value="/admin/help")
	public String help(RequestContext rc){
		return "admin/help";
	}
}
