package cn.com.shukaiken.controller.base;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageHelper;

import cn.com.shukaiken.model.SystemUser;
import cn.com.shukaiken.util.DateTimeUtils;
import cn.com.shukaiken.util.ValidateUtils;


public class RequestContext {
	
	private static Logger logger = LoggerFactory.getLogger(RequestContext.class);
	
	private HttpServletRequest request  =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	
	private HttpServletResponse response; 
	
	private HttpSession session;
	
	public RequestContext(){
		session = this.request.getSession();
		if(!ValidateUtils.isEmpty(get("selId")))
			session("selId", get("selId"));
	}
	
	public SystemUser getCurrUser(){
		return (SystemUser) session.getAttribute("systemUser");
	}
	/**
	 * 从request中取得参数
	 * @param key
	 */
	public String get(String key) {
		String v = request.getParameter(key);
		if(v!=null) v=v.trim();
		return v;
	}
	/**
	 * 从request中取得参数，如果参数为null，返回空字符串。
	 * @param key
	 * @return
	 */
	public String get(String key,String defaultValue) {
		String v = request.getParameter(key);
		if(ValidateUtils.isEmpty(v)){
			v= defaultValue;
		}
		if(v!=null) v=v.trim();
		return v;
	}
	
	public Date getDate(String key){
		String val = this.get(key);
		if(ValidateUtils.isDateTime(val)){
			return DateTimeUtils.parserDateTime(val);
		}
		return null;
	}
	public Date getDate(String key,String defaultValue){
		String val = this.get(key, defaultValue);
		if(ValidateUtils.isDateTime(val)){
			return DateTimeUtils.parserDateTime(val);
		}
		return null;
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * 
	 * @param key
	 * @return
	 */
	public Integer getInt(String key) {
		try {
			return Integer.parseInt(request.getParameter(key));
		} catch (NumberFormatException e) {
			throw new RuntimeException("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
		}
	}
	public BigDecimal getBigDecimal(String key) {
		try {
			return new BigDecimal(request.getParameter(key));
		} catch (NumberFormatException e) {
			throw new RuntimeException("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
		}
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * @param key
	 * @return
	 */
	public Integer getInt(String key,Integer defaultValue) {
		try {
			return Integer.parseInt(request.getParameter(key));
		} catch (NumberFormatException e) {
			logger.debug("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
			return defaultValue;
		}
	}
	/**
	 * 从request中取一个Float变量。如果没有值，则会抛出运行时异常
	 * @param key
	 * @return
	 */
	public Float getFloat(String key,Float defaultValue) {
		try {
			return Float.parseFloat(request.getParameter(key));
		} catch (Exception e) {
			logger.debug("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
			return defaultValue;
		}
	}
	/**
	 * 从request中取一个Float变量。如果没有值，则会抛出运行时异常
	 * @param key
	 * @return
	 */
	public Float getFloat(String key) {
		try {
			return Float.parseFloat(request.getParameter(key));
		} catch (Exception e) {
			throw new RuntimeException("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
		}
	}

	/**
	 * 从request中取得该key对应的所有参数值。
	 * 
	 * @param key
	 * @return
	 */
	public String[] getValues(String key) {
		return request.getParameterValues(key);
	}

	/**
	 * 向请求中插入数据。
	 * 
	 * @param key
	 * @param value
	 */
	public void attr(String key, Object value) {
		request.setAttribute(key, value);
	}

	public Object attr(String key) {
		return request.getAttribute(key);
	}
	public Integer attrInt(String key){
		return Integer.parseInt(attr(key)+"");
	}
	/**
	 * 从session中取值
	 * 
	 * @param key
	 * @return
	 */
	public Object session(String key) {
		return session.getAttribute(key);
	}
	
	public void initPageHelper(int pageSize){
		String pageNum = this.get("pageNum");
		int num = ValidateUtils.isEmpty(pageNum)?1:Integer.valueOf(pageNum.trim());
		PageHelper.startPage(num, pageSize, true);
	}

	/**
	 * 向session中插入值。
	 * 
	 * @param key
	 * @param value
	 */
	public void session(String key, Object value) {
		session.setAttribute(key, value);
	}
	
	
	/**
	 * 移除session
	 * @param key
	 */
	public void removeSession(String key){
		session.removeAttribute(key);
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		RequestContext.logger = logger;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}
