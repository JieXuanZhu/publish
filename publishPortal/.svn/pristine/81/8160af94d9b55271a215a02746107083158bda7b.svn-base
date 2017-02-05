/**
 * @Title: SeleniumHttpRequest.java 
* @Package cn.com.shukaiken.util 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年12月16日 下午1:33:40 
* @version V1.0 
 */
package cn.com.shukaiken.util;

import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;

/**
 * @ClassName: SeleniumHttpRequest 
 * @Description: <p>TODO</p>
 * @date 2015年12月16日 下午1:33:40 
 * @author Zhao Xiang
 *
 */
public class SeleniumHttpRequest {
	  static {
	        Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");
	        logger.setLevel(Level.OFF);
	    }

	    public HttpResponse getResponse(CrawlDatum datum) throws Exception {
	        HtmlUnitDriver driver = new HtmlUnitDriver();

	        driver.setJavascriptEnabled(true);

	        try {
	            driver.get(datum.getUrl());
	            //HttpRequest request = new HttpRequest(datum);
	            //request.setProxy(new Proxys().nextRandom());
	            //request.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0");
	            HttpResponse response = new HttpResponse(new URL(datum.getUrl()));
	            //HttpResponse response = request.getResponse();
	            response.setUrl(new URL(datum.getUrl()));
	            response.setCode(200);
	            String html = driver.getPageSource();
	            response.setHtml(html);
	            response.addHeader("Content-Type", "text/html");
	            return response;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw ex;
	        }

	    }
	    
	    public static String getDocumentByJs(String select,CrawlDatum datum){
	    	HtmlUnitDriver driver = new HtmlUnitDriver();

	        driver.setJavascriptEnabled(true);
	        
	        driver.get(datum.getUrl());
	        WebElement ele = driver.findElementByCssSelector(select);
	        return ele.getText();
	    }
}
