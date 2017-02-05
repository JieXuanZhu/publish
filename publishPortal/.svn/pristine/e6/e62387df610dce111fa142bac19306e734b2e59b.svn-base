package cn.com.shukaiken.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.shukaiken.model.Log;
import cn.com.shukaiken.model.SystemUser;
import cn.com.shukaiken.service.ILogService;
import cn.com.shukaiken.util.Constant;

/**  
 * Copyright: Copyright (c) 2015 
 * 
 * @ClassName: LogAspect.java
 * @Description: 日志记录，添加、修改、删除方法
 *
 * @version: v1.0.0
 * @author: 
 * @date: 2015-11-16 下午02:15:57 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2015-11-16     tc           v1.0.0               修改原因
 */
@Aspect
@Service
public class LogAspect {
	
	@Autowired
	private ILogService logService;

	/**
	 * 
	 * @Function: LogAspect::selectControllerCall
	 * @Description: 添加业务切入点 查询
	 * @version: v1.0.0
	 * @author: 
	 * @date: 2015-11-17 下午04:04:11 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	@Pointcut("@annotation(cn.com.shukaiken.aop.ControllerLog)")
	public void controllerCall(){}
	
	@Pointcut("@annotation(cn.com.shukaiken.aop.ServiceLog)")
	public void serviceCall(){}
	
	/**
	 * 
	 * @Function: LogAspect::insertServiceCall
	 * @Description: 添加业务切入点
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @date: 2015-11-17 下午04:04:11 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 *//*
	//@Pointcut("execution(* cn.com.shukaiken.service.*.insert*(..))")
	@Pointcut("@annotation(cn.com.shukaiken.aop.AddControllerLog)")
	public void insertControllerCall(){}
	
	@Pointcut("@annotation(cn.com.shukaiken.aop.AddServiceLog)")
	public void insertServiceCall(){}
	
	*//**
	 * 
	 * @Function: LogAspect::updateServiceCall
	 * @Description: 修改业务切入点
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @date: 2015-11-17 下午04:04:34 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 *//*
	//@Pointcut("execution(* cn.com.shukaiken.service.*.update*(..))")
	@Pointcut("@annotation(cn.com.shukaiken.aop.UpdateControllerLog)")
	public void updateControllerCall(){}
	
	@Pointcut("@annotation(cn.com.shukaiken.aop.UpdateServiceLog)")
	public void updateServiceCall(){}
	
	*//**
	 * 
	 * @Function: LogAspect::deleteServiceCall
	 * @Description: 删除业务切入点
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @date: 2015-11-17 下午04:04:57 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 *//*
	//@Pointcut("execution(* cn.com.shukaiken.service.*.delete*(..))")
	@Pointcut("@annotation(cn.com.shukaiken.aop.DeleteControllerLog)")
	public void deleteControllerCall(){}
	
	@Pointcut("@annotation(cn.com.shukaiken.aop.DeleteServiceLog)")
	public void deleteServiceCall(){}*/
	
	/**
	 * 
	 * @Function: LogAspect::insertServiceCallCalls
	 * @Description: 操作员添加操作日志(后置通知)
	 * @param joinPoint
	 * @param rtv
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @throws Exception 
	 * @date: 2015-11-17 下午04:13:54 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	@AfterReturning(value="controllerCall()")
	public void controllerCallCalls(JoinPoint joinPoint){
		
		HttpServletRequest request  =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SystemUser user = (SystemUser) request.getSession().getAttribute("systemUser");
		if(null==user){
			return ;
		}
		Integer id = user.getId();
		String name = user.getName();
		
		String parameters = getParametersFromRequest(request);
		
		//判断参数
		if(joinPoint.getArgs()==null){
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(),methodName);
		String operType = "";
		String cateogry = "";
		try {
			opContent = this.getControllerMethodDescription(joinPoint)+" | "+parameters;
			operType = this.getControllerMethodType(joinPoint);
			cateogry = this.getControllerMethodCategory(joinPoint);
		} catch (Exception e) {
			opContent = "保存日志发生异常:Exception:"+e;
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setCustId(id);
		log.setName(name);
		log.setBehavior(opContent);
		log.setTargetId(1);
		log.setCreateDate(new Date());
		log.setOperateType(operType);
		log.setCategory(cateogry);
		log.setLogsType("0");
		log.setIsValid(Constant.VALID);
		log.setLogFrom("controller");
		logService.logInsert(log);
	}
	
	
	/**
	 * 
	 * @Function: LogAspect::insertServiceCallCalls
	 * @Description: 操作员添加操作日志(后置通知)
	 * @param joinPoint
	 * @param rtv
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @throws Exception 
	 * @date: 2015-11-17 下午04:13:54 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	@AfterReturning(value="serviceCall()")
	public void serviceCallCalls(JoinPoint joinPoint){
		
		HttpServletRequest request  =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SystemUser user = (SystemUser) request.getSession().getAttribute("systemUser");
		if(null==user){
			return ;
		}
		Integer id = user.getId();
		String name = user.getName();
		
		//判断参数
		if(joinPoint.getArgs()==null){
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		String parameters = getParametersFromRequest(request);
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(),methodName);
		String operType ="";
		String cateogry = "";
		try {
			opContent = this.getServiceMethodDescription(joinPoint)+" | "+parameters;
			operType = this.getServiceMethodType(joinPoint);
			cateogry = this.getServiceMethodCategory(joinPoint);
		} catch (Exception e) {
			opContent = "保存日志发生异常:Exception:"+e;
			e.printStackTrace();
		}
		
		
		Log log = new Log();
		log.setCustId(id);
		log.setName(name);
		log.setBehavior(opContent);
		log.setTargetId(1);
		log.setCreateDate(new Date());
		log.setOperateType(operType);
		log.setCategory(cateogry);
		log.setLogsType("0");
		log.setIsValid(Constant.VALID);
		log.setLogFrom("service");
		logService.logInsert(log);
	}
	
	/**
	 * 
	 * @Function: LogAspect::insertServiceCallCallsError
	 * @Description: 操作员添加操作异常日志(后置通知)
	 * @param joinPoint
	 * @param rtv
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @throws Exception 
	 * @date: 2015-11-17 下午04:13:54 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	@AfterThrowing(value="controllerCall()")
	public void controllerCallCallsError(JoinPoint joinPoint){
		
		HttpServletRequest request  =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SystemUser user = (SystemUser) request.getSession().getAttribute("systemUser");
		if(null==user){
			return ;
		}
		Integer id = user.getId();
		String name = user.getName();
		
		//判断参数
		if(joinPoint.getArgs()==null){
			return;
		}
		String parameters = getParametersFromRequest(request);
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(),methodName);
		String operType = "";
		String cateogry = "";
		try {
			opContent = this.getControllerMethodDescription(joinPoint)+" | "+parameters;
			operType = this.getControllerMethodType(joinPoint);
			cateogry = this.getControllerMethodCategory(joinPoint);
		} catch (Exception e) {
			opContent = "保存日志发生异常:Exception:"+e;
			e.printStackTrace();
		}
		Log log = new Log();
		log.setCustId(id);
		log.setName(name);
		log.setBehavior(opContent);
		log.setTargetId(1);
		log.setCreateDate(new Date());
		log.setOperateType(operType);
		log.setCategory(cateogry);
		log.setLogsType("1");
		log.setIsValid(Constant.VALID);
		log.setLogFrom("controller");
		logService.logInsert(log);
	}
	
	/**
	 * 
	 * @Function: LogAspect::insertServiceCallCallsError
	 * @Description: 操作员添加操作异常日志(后置通知)
	 * @param joinPoint
	 * @param rtv
	 * @version: v1.0.0
	 * @author: zhouyx3
	 * @throws Exception 
	 * @date: 2015-11-17 下午04:13:54 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 */
	@AfterThrowing(value="serviceCall()")
	public void serviceCallCallsError(JoinPoint joinPoint){
		
		HttpServletRequest request  =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SystemUser user = (SystemUser) request.getSession().getAttribute("systemUser");
		if(null==user){
			return ;
		}
		Integer id = user.getId();
		String name = user.getName();
		
		//判断参数
		if(joinPoint.getArgs()==null){
			return;
		}
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		String parameters = getParametersFromRequest(request);
		//获取操作内容
		String opContent = adminOptionContent(joinPoint.getArgs(),methodName);
		String operType = "";
		String cateogry = "";
		
		try {
			opContent = this.getServiceMethodDescription(joinPoint)+" | "+parameters;
			operType = this.getServiceMethodType(joinPoint);
			cateogry = this.getServiceMethodCategory(joinPoint);
		} catch (Exception e) {
			opContent = "保存日志发生异常:Exception:"+e;
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setCustId(id);
		log.setName(name);
		log.setBehavior(opContent);
		log.setTargetId(1);
		log.setCreateDate(new Date());
		log.setOperateType(operType);
		log.setLogsType("1");
		log.setCategory(cateogry);
		log.setIsValid(Constant.VALID);
		log.setLogFrom("service");
		logService.logInsert(log);
	}
	
	
	//获取操作内容
	public String adminOptionContent(Object[] args,String methodName){
		if(args==null){
			return null;
		}
		StringBuffer rs = new StringBuffer();
		String classname = null;
		rs.append(methodName);
		int index = 1;
		
		//遍历参数对象
		for(Object info:args){
			//获取对象类型
			classname = info.getClass().getName();
			classname = classname.substring(classname.lastIndexOf(".")+1);
			rs.append("[参数"+index+",类型："+classname+",值：");
			
			//获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();
			
			//遍历方法 取得 get方法
			for(Method m:methods){
				String mname = m.getName();
				if(mname.indexOf("get")==-1){
					continue;
				}
				
				Object rtValue = null;
				try{
					rtValue = m.invoke(info);
					if(null==rtValue){
						continue;
					}
					
				}catch(Exception e){
					continue;
				}
				
				rs.append("("+mname+":"+rtValue+")");
			}
			rs.append("]");
			index++;
		}
		return rs.toString();
	}
	
	/**
	 * @Title: getParametersFromRequest 
	 * @Description: TODO
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws 
	 */
	private String getParametersFromRequest(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		
		if(request!=null){
			Map<String, String[]> parMap = request.getParameterMap();
			if(parMap!=null && parMap.size()>0){
				for(Map.Entry<String, String[]> entry:parMap.entrySet()){
					String pv = "";
					sb.append("{参数[");
					sb.append(entry.getKey());
					sb.append("]:[");
					for(String parValue:entry.getValue()){
						//sb.append(parValue+",");
						if(parValue.length()>30){
							parValue=parValue.replaceAll("\\s+","").substring(0, 30);
						}
						pv+=parValue+",";
					}
					sb.append(pv.substring(0, pv.length()-1));
					sb.append("]}");
				}
			}
		}
		return sb.toString();
	}
	
	/**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMethodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ServiceLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ControllerLog.class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    } 
     /**  
      * 获取注解中对方法的描述信息 用于service层类型
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
     public  static String getServiceMethodType(JoinPoint joinPoint)    
    		 throws Exception {    
    	 String targetName = joinPoint.getTarget().getClass().getName();    
    	 String methodName = joinPoint.getSignature().getName();    
    	 Object[] arguments = joinPoint.getArgs();    
    	 Class targetClass = Class.forName(targetName);    
    	 Method[] methods = targetClass.getMethods();    
    	 String type = "";    
    	 for (Method method : methods) {    
    		 if (method.getName().equals(methodName)) {    
    			 Class[] clazzs = method.getParameterTypes();    
    			 if (clazzs.length == arguments.length) {    
    				 type = method.getAnnotation(ServiceLog. class).type();    
    				 break;    
    			 }    
    		 }    
    	 }    
    	 return type;    
     }    
     
     /**  
      * 获取注解中对方法的描述信息 用于Controller层类型  
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
     public  static String getControllerMethodType(JoinPoint joinPoint)  throws Exception {    
    	 String targetName = joinPoint.getTarget().getClass().getName();    
    	 String methodName = joinPoint.getSignature().getName();    
    	 Object[] arguments = joinPoint.getArgs();    
    	 Class targetClass = Class.forName(targetName);
    	 Method[] methods = targetClass.getMethods();    
    	 String type = "";    
    	 for (Method method : methods) {    
    		 if (method.getName().equals(methodName)) {    
    			 Class[] clazzs = method.getParameterTypes();    
    			 if (clazzs.length == arguments.length) {    
    				 type = method.getAnnotation(ControllerLog.class).type();    
    				 break;    
    			 }    
    		 }    
    	 }    
    	 return type;    
     } 
     /**  
      * 获取注解中对方法的描述信息 用于service层类型
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
     public  static String getServiceMethodCategory(JoinPoint joinPoint)    
    		 throws Exception {    
    	 String targetName = joinPoint.getTarget().getClass().getName();    
    	 String methodName = joinPoint.getSignature().getName();    
    	 Object[] arguments = joinPoint.getArgs();    
    	 Class targetClass = Class.forName(targetName);    
    	 Method[] methods = targetClass.getMethods();    
    	 String category = "";    
    	 for (Method method : methods) {    
    		 if (method.getName().equals(methodName)) {    
    			 Class[] clazzs = method.getParameterTypes();    
    			 if (clazzs.length == arguments.length) {    
    				 category = method.getAnnotation(ServiceLog. class).category();    
    				 break;    
    			 }    
    		 }    
    	 }    
    	 return category;    
     }    
     
     /**  
      * 获取注解中对方法的描述信息 用于Controller层类型  
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
     public  static String getControllerMethodCategory(JoinPoint joinPoint)  throws Exception {    
    	 String targetName = joinPoint.getTarget().getClass().getName();    
    	 String methodName = joinPoint.getSignature().getName();    
    	 Object[] arguments = joinPoint.getArgs();    
    	 Class targetClass = Class.forName(targetName);
    	 Method[] methods = targetClass.getMethods();    
    	 String category = "";    
    	 for (Method method : methods) {    
    		 if (method.getName().equals(methodName)) {    
    			 Class[] clazzs = method.getParameterTypes();    
    			 if (clazzs.length == arguments.length) {    
    				 category = method.getAnnotation(ControllerLog.class).category();    
    				 break;    
    			 }    
    		 }    
    	 }    
    	 return category; 
     } 
}
