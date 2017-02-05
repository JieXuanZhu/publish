/**
 * @Title: NewsInfoCrawlerJob.java 
* @Package cn.com.shukaiken.crawler 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年12月1日 下午1:26:25 
* @version V1.0 
 */
package cn.com.shukaiken.crawler;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.service.ICrawlNewsInfoService;
import cn.com.shukaiken.util.ConfigurationUtils;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.ValidateUtils;

/**
 * @ClassName: NewsInfoCrawlerJob 
 * @Description: <p>TODO</p>
 * @date 2015年12月1日 下午1:26:25 
 * @author Zhao Xiang
 *
 */
@Service
public class NewsInfoCrawlerJob {
	Logger logger = LoggerFactory.getLogger(NewsInfoCrawlerJob.class);
	@Autowired
	private ICrawlNewsInfoService crawlNewsInfoService;
	static int threads = 50;
	static int visitInterval = 4000;
	static int retryInterval = 3000;
	static {
		String threadNum = ConfigurationUtils.readValue("news_crawl_threads", "crawl_config.properties");
		String visit = ConfigurationUtils.readValue("news_crawl_thread_sleep_time", "crawl_config.properties");
		String retry = ConfigurationUtils.readValue("news_crawl_retry_time", "crawl_config.properties");
		if(!ValidateUtils.isEmpty(threadNum)){
			threads = Integer.valueOf(threadNum);
		}
		if(!ValidateUtils.isEmpty(visit)){
			visitInterval = Integer.valueOf(visit);
		}
		if(!ValidateUtils.isEmpty(retry)){
			retryInterval = Integer.valueOf(retry);
		}
	}
	public void startCrawl() throws Exception{
		System.err.println("开始执行抓取");
		CrawlNewsInfoSource source = new CrawlNewsInfoSource();
		source.setIsValid(Constant.VALID);
		List<CrawlNewsInfoSource> sourcesList = crawlNewsInfoService.getSourceList(source);
		if(sourcesList!=null && sourcesList.size()>0){
			System.err.println("开始");
			//for(int i = 0;i<sourcesList.size();i++){
				 //CrawlNewsInfoSource sr = sourcesList.get(i);
				String osname = System.getProperty("os.name");
				String crawlPath = "";
				if(osname.toLowerCase().indexOf("linux")>-1){
					crawlPath = ConfigurationUtils.readValue("linux.crawl.path", "config.properties");
				}else if(osname.toLowerCase().indexOf("windows")>-1){
					crawlPath = ConfigurationUtils.readValue("windows.crawl.path", "config.properties");
				}
				NewsInfoCrawler crawler = new NewsInfoCrawler(crawlPath,crawlNewsInfoService,sourcesList);
				crawler.setThreads(threads);
		        crawler.setResumable(false);
		        crawler.setVisitInterval(visitInterval);
		        crawler.setRetryInterval(retryInterval);
		        
		        crawler.start(3);
		       //sr.setLastCrawlTime(new Date());
		       crawlNewsInfoService.updateNewsInfoSourceById(sourcesList);
		       
			//}
		}
	}

	/**
	 * @Title: createStartUrl 
	 * @Description: TODO
	 * @param @param j
	 * @param @param startUrl
	 * @param @param resv4
	 * @param @return
	 * @return String
	 * @throws 
	 */
/*	private String createStartUrl(int pagenum, String startUrl, String pageReg) {
		if(pagenum==1){
			startUrl = startUrl.replace("{{page}}", "");
		}else {
			logger.info("pagenum="+pagenum);
			pageReg = pageReg.replace("{{pagenum}}", Integer.toString(pagenum));
			logger.info("pageReg"+pageReg);
			startUrl = startUrl.replace("{{page}}", pageReg);
			logger.info("startUrl"+startUrl);
		}
		return startUrl;
	}*/
}
