package cn.com.shukaiken.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	/**
	 * 发送http GET请求，并返回http响应字符串
	 * 
	 * @param urlstr
	 *            完整的请求url字符串
	 * @return
	 */
	public static String doGetRequest(String urlstr) {
		try {
			return Request.Get(urlstr).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			logger.debug(e + "");
		} catch (IOException e) {
			logger.debug(e + "");
		}
		return "";
	}


	public static String doPostRequest(String urlstr) {
		String urlstrf = StringUtils.substringBefore(urlstr, "?");
		String[] parts = StringUtils.splitByWholeSeparator(StringUtils.substringAfter(urlstr, "?"), "&");
		List<NameValuePair> strparts = new ArrayList<NameValuePair>();
		for (String s : parts) {
			strparts.add(new BasicNameValuePair(StringUtils.substringBefore(s, "="), StringUtils.substringAfter(s, "=")));

		}
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(strparts, "UTF-8");
			
			return doPostRequest(urlstrf, entity);
		} catch (UnsupportedEncodingException e) {
			logger.debug(e + "");
			return "fail";
		}

	}

	
	/**
	 * 发送http GET请求，并返回http响应字符串
	 * 
	 * @param urlstr
	 *            完整的请求url字符串
	 * @return
	 */
	public static String doPostRequest(String urlstr, HttpEntity parts) {
		try {
			return Request.Post(urlstr).body(parts).execute().returnContent().asString();
		} catch (ClientProtocolException e) {
			logger.debug(e + "");
		} catch (IOException e) {
			logger.debug(e + "");
		}
		return "";
		
	}

	

}
