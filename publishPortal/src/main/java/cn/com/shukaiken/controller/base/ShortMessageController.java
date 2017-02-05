/** 
 * Project Name:zyStock 
 * File Name:ShortMessageController.java 
 * Package Name:cn.com.shukaiken.controller.base 
 * Date:2015-9-9上午11:41:45 
 * Copyright (c) 2015, 上海中亿国星 All Rights Reserved. 
 * 
 */
package cn.com.shukaiken.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shukaiken.util.SMSUtils;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * 发送短信Controller
 * 创建日期 2015-9-9
 */
@Controller(value="shortMessageController")
public class ShortMessageController {
	
	Logger logger = LoggerFactory.getLogger(ShortMessageController.class);
	
	@RequestMapping(value="/front/sendMessage")
	@ResponseBody
	public Map<String,Object> sendMessage(RequestContext rc,ModelMap model){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean sendSuccess = false;
		try {
			String phone = rc.get("p");//手机号码
			String messageType= rc.get("t");//手机短信类型，注册的，找回密码的等等
			String code = SMSUtils.genrateCode(6);
			String messageContent = this.getContent(messageType,code);
			logger.info("发送短信:phoneNumber="+phone+",短信内容:"+messageContent);
			sendSuccess = SMSUtils.send(phone, messageContent);
			//sendSuccess = true;
			rc.getSession().setAttribute(phone, code);//将短信验证码放到session中
			//map.put("verifyCode", code);
			map.put("success", sendSuccess);
		} catch (Exception e) {
			map.put("success", false);
			e.printStackTrace();
		}
		return map;
	}
	
	private String getContent(String type,String code){
		String message = "";
		if("0".equals(type)){
			message = "【亿阳指财富官网】 您正在绑定该手机，验证码为"+code+"，如非本人操作请致电021-61299140）"; 
		} else if("1".equals(type)){
			message = "【亿阳指财富官网】您正在进行亿阳指ID找回密码操作，验证码为"+code+"，请在15分钟内使用"; 
		}else if("2".equals(type)){
			message = "【亿阳指财富官网】您的验证码是"+code+"，如非本人操作，请忽略本短信"; 
		}
		return message;
	}
	
	@RequestMapping(value="checkVerifyCode")
	@ResponseBody
	public Map<String,Object> checkVerifyCode(RequestContext rc,ModelMap model){
		Map<String,Object> map = new HashMap<String,Object>();
		String phone = rc.get("phone");
		String code = rc.get("code");
		if(ValidateUtils.isEmpty(phone)||ValidateUtils.isEmpty(code)){//如果手机号或者验证码为空那么验证失败
			map.put("success", false);
		}else{
			String phoneInSession = (String) rc.getSession().getAttribute(phone);
			if(ValidateUtils.isEmpty(phoneInSession)){//如果该手机号在session中不存在对应的值，那么验证失败
				map.put("success", false);
			}else if(!phoneInSession.equalsIgnoreCase(code)){//如果手机号对应的值与传过来的code值不同，那么验证失败
				map.put("success", false);
			}else {
				map.put("success", true);
			}
		}
		return map;
	}
	
}
