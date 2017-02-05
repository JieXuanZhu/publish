package cn.com.shukaiken.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.shukaiken.model.SystemUser;


public class BackendLoginInterceptor extends HandlerInterceptorAdapter {
	 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		 request.setCharacterEncoding("UTF-8");  
		 response.setCharacterEncoding("UTF-8");  
		 response.setContentType("text/html;charset=UTF-8");
		
		// 不拦截的请求
		 String[] noFilters = new String[] {"/admin/login", "/dologin", "/logout"};
		 
		 String uri = request.getRequestURI();
		 //noFilter为true时url不在拦截器里面；为false时url在拦截器里
		 boolean noFilter = true; 
		
		 for (String s : noFilters) {
			if(uri.indexOf(s) != -1){
				noFilter = false;
				break;
			}
		 }
		 
		 
	   if (noFilter) {
			SystemUser systemUser = (SystemUser)request.getSession().getAttribute("systemUser");
			//未登陆
			if(systemUser == null){
				/*request.getRequestDispatcher("/admin/login").forward(request, response);*/
			    response.sendRedirect(request.getContextPath()+"/admin/login");
				return false;
			}
		}
		
		
	   return super.preHandle(request, response, handler);
	}
}
