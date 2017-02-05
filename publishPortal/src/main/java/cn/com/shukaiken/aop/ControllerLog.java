/**
 * @Title: ControllerLog.java 
* @Package cn.com.shukaiken.aop 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年12月17日 下午5:09:57 
* @version V1.0 
 */
package cn.com.shukaiken.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ControllerLog 
 * @Description: <p>TODO</p>
 * @date 2015年12月17日 下午5:09:57 
 * @author Zhao Xiang
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented
public @interface ControllerLog {
	
	public static final String SELECT = "5";
	public static final String ADD = "2";
	public static final String UPDATE = "0";
	public static final String DELETE = "1";
	public static final String CHECKED = "3";
	public static final String OTHERS = "4";
	
	public String description() default "";
	
	public String type() default "";
	
	public String category() default "";
}
