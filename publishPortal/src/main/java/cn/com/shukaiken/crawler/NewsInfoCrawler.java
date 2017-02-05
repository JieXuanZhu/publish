/**
 * @Title: NewsInfoCrawler.java 
* @Package cn.com.shukaiken.crawler 
* @Description: <p>TODO</p> 
* @author zhaox   
* @date 2015年11月30日 下午7:00:32 
* @version V1.0 
 */
package cn.com.shukaiken.crawler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.shukaiken.model.CrawlNewsInfo;
import cn.com.shukaiken.model.CrawlNewsInfoConfig;
import cn.com.shukaiken.model.CrawlNewsInfoSource;
import cn.com.shukaiken.service.ICrawlNewsInfoService;
import cn.com.shukaiken.util.ConfigurationUtils;
import cn.com.shukaiken.util.Constant;
import cn.com.shukaiken.util.DateTimeUtils;
import cn.com.shukaiken.util.RedisUtils;
import cn.com.shukaiken.util.ReflectUtil;
import cn.com.shukaiken.util.SeleniumHttpRequest;
import cn.com.shukaiken.util.ValidateUtils;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;
import redis.clients.jedis.ShardedJedis;

/**
 * @ClassName: NewsInfoCrawler 
 * @Description: <p>TODO</p>
 * @date 2015年11月30日 下午7:00:32 
 * @author Zhao Xiang
 *
 */
public class NewsInfoCrawler extends BreadthCrawler{
	Logger logger = LoggerFactory.getLogger(NewsInfoCrawler.class);
	static RegexRule regexRule = new RegexRule();
	String searchUrl = null;
	//CrawlNewsInfoSource source = null;
	List<CrawlNewsInfoSource> sourceList = new ArrayList<CrawlNewsInfoSource>();
	//List<CrawlNewsInfoConfig> configs = null;
	List<List<CrawlNewsInfoConfig>> configsList = new ArrayList<List<CrawlNewsInfoConfig>>();
	
	
	private ICrawlNewsInfoService crawlNewsInfoService;
	/**
	 * @param crawlNewsInfoService2 
	 * @param sourcesList 
	 */
	public NewsInfoCrawler(String crawlPath,ICrawlNewsInfoService crawlNewsInfoService2, List<CrawlNewsInfoSource> sourcesList) {
		
		super(crawlPath,true);
		//configs = sourcesList.getInfoConfigs();
		crawlNewsInfoService = crawlNewsInfoService2;
		sourceList =sourcesList; 
		//source = sourcesList;
		if(sourcesList!=null && sourcesList.size()>0){
			for(int i=0;i<sourcesList.size();i++){
				CrawlNewsInfoSource source = sourcesList.get(i);
				configsList.add(source.getInfoConfigs());//将Config放到List中，按照顺序排列，根据索引查找
				Integer startPage = Integer.valueOf((ValidateUtils.isEmpty(source.getResv2())?"0":source.getResv2()));
				System.out.println(startPage);
				Integer endPage = Integer.valueOf((ValidateUtils.isEmpty(source.getResv3())?"1000":source.getResv3()));
				System.out.println(endPage);
				for(int j=startPage;j<endPage;j++){
					String startUrl = createStartUrl(j,source.getStartUrl(),source.getResv4());
					CrawlDatum datum = new CrawlDatum(startUrl);
					datum.putMetaData("srcId",Integer.toString(source.getId()))//放当前Source的Id
					.putMetaData("index", Integer.toString(i));//放的是当前所在的所有，为了方便找到Source和Config
					addSeed(datum);
				}
				regexRule.addRule(source.getSiteUrl());
			}
			regexRule.addRule(".*(jpg|png|jpeg|gif).*");//同时对网站上的图片进行抓取
		}
		
        //regexRule.addRule("-.*jpg.*");
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public HttpResponse getResponse(CrawlDatum datum) throws Exception {
    	return new SeleniumHttpRequest().getResponse(datum);
    }
	

	/* (non-Javadoc)
	 * <p>Title: visitAndGetNextLinks</p> 
	 * <p>Description: </p> 
	 * @param arg0
	 * @return 
	 * @see cn.edu.hfut.dmic.webcollector.fetcher.Visitor#visitAndGetNextLinks(cn.edu.hfut.dmic.webcollector.model.Page) 
	 */
	@Override
	public void visit(Page page,CrawlDatums next) {
		
		Document doc = page.getDoc();
		int index = Integer.parseInt(page.getMetaData("index"));
        //String title = doc.title();
        //System.out.println("URL:" + page.getUrl() + "  标题:" + title);
        //System.out.println(doc);
        if(Pattern.matches(sourceList.get(index).getSiteUrl(), page.getUrl())){
        	ShardedJedis shardedJedis = new RedisUtils().getShardedJedis();
        	if(!shardedJedis.exists(page.getUrl())){
        	
        	CrawlNewsInfo info = new CrawlNewsInfo();
            //List<TableInfo> tableInfos = crawlNewsInfoService.selectTableInfo("t_news_info");
            List<String> attrs = ReflectUtil.getAllAttributes(CrawlNewsInfo.class);
            //System.out.println(attrs.size());
            for(int i = 0;i<configsList.get(index).size();i++){
            	//Map<String,String> jsDataMap = new HashMap<String,String>();//将js的结果放到这个Map中，防止重复发送请求，影响效率
            	CrawlNewsInfoConfig config = configsList.get(index).get(i);
            	for(int j=0;j<attrs.size();j++){
            		String attr = attrs.get(j);
            		//System.out.println(attr);
            		//System.out.println(config.getProp());
            		if(ReflectUtil.formatAttr(attr).equals(ReflectUtil.formatAttr(config.getProp()))){//如果实体中的去掉下划线和数据库中的一致，那么设置
            			String value = "";
            			if("1".equals(config.getResv1())){//如果是附件,那么就下载
            				Elements elements = doc.select(config.getSelector());
            				for(int k = 0;k<elements.size();k++){
            					Element e = elements.get(k);
            					String url = e.attr("abs:src");
            					System.err.println(url);
            					try {
            						
            						String osname = System.getProperty("os.name");
            						String savePath = "";
            						if(osname.toLowerCase().indexOf("linux")>-1){
            							savePath = ConfigurationUtils.readValue("linux.info.images.upload.path", "config.properties");
            						}else if(osname.toLowerCase().indexOf("windows")>-1){
            							savePath = ConfigurationUtils.readValue("windows.info.images.upload.path", "config.properties");
            						}
									FileUtils.writeFileWithParent(savePath+DateTimeUtils.customDateTime(new Date(),"yyyyMMdd" )
									+ "/"+DateTimeUtils.customDateTime(new Date(), "yyyyMMddHHmmss")+"_banner_"+(new Random()).nextInt(1000000)+
									(url.substring(url.lastIndexOf("."))), getFileFromURL(url));
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
            					//System.error.println(url);
            				}
            			}else{
            				/*if("1".equals(config.getResv2())){
            					if(jsDataMap.containsKey(config.getSelector())){
            						value = jsDataMap.get(config.getSelector());
            					}else {
            						
            						value = SeleniumHttpRequest.getDocumentByJs(config.getSelector(), page.getCrawlDatum());
            						jsDataMap.put(config.getSelector(), value);
            					}
            					
            					if(ValidateUtils.isEmpty(value)&&!ValidateUtils.isEmpty(config.getOrSelector())){
            						if(jsDataMap.containsKey(config.getOrSelector())){
                						value = jsDataMap.get(config.getOrSelector());
                					}else {
                						value = SeleniumHttpRequest.getDocumentByJs(config.getOrSelector(), page.getCrawlDatum());
                						jsDataMap.put(config.getOrSelector(), value);
                					}
            					}
            				}else {*/
            					if("1".equals(config.getIsResvHtml()) && !ValidateUtils.isEmpty(config.getSelector())){
                    				value=doc.select(config.getSelector()).text();
                    			}else if("0".equals(config.getIsResvHtml()) && !ValidateUtils.isEmpty(config.getSelector())){
                    				//Elements eles = doc.select(config.getSelector());
                    				doc = prependServerInfo4ImageUrl(doc);//全路径 img src
                    				value = doc.select(config.getSelector()).html();
                    			}
                    			
                    			if(!ValidateUtils.isEmpty(value) && !ValidateUtils.isEmpty(config.getOrSelector())){
                    				if("1".equals(config.getIsResvHtml())){
                    					value = doc.select(config.getOrSelector()).text();
                        			}else if("0".equals(config.getIsResvHtml())){
                        				//Elements eles = doc.select(config.getOrSelector());
                        				doc = prependServerInfo4ImageUrl(doc);
                        				value = doc.select(config.getOrSelector()).html();
                        			}
                    			}
            				//}
            				
                			
                			if(!ValidateUtils.isEmpty(config.getSubReg())){
                				Pattern p = Pattern.compile(config.getSubReg());
                				Matcher m = p.matcher(value);
                				if(m.find()){
                					if(m.groupCount()>=1){
                						value=m.group(1);
                					}
                				}else {
                					value="";
                				}
                				//System.out.println(m.group(1));
                			}
                			//System.out.println(attr);
                			ReflectUtil.setAttrValue(attr, value, CrawlNewsInfo.class, info);
            			}
            			
            		}
            	}
            }
            info.setCrawlertime(DateTimeUtils.currentDateTime());
            info.setCrawlerurl(page.getUrl());
            info.setCrawleroriginal(doc.title());
            info.setIsValid(Constant.VALID);
            info.setLabelId(sourceList.get(index).getLabelId());
            info.setResv1(sourceList.get(index).getId()+"");
            /*将数据插入mysql*/
            int infoId = crawlNewsInfoService.addNewsInfo(info,sourceList.get(index));
            logger.info("新增info成功：id="+infoId);
            shardedJedis.set(page.getUrl(), page.getUrl());
        	}else {
        		logger.info(page.getUrl()+"---has exists");
        	}
        }else {
        	/*下面是2.0版本新加入的内容*/
            /*抽取page中的链接返回，这些链接会在下一轮爬取时被爬取。 不用担心URL去重，爬虫会自动过滤重复URL。*/
        	
            Links nextLinks = new Links();
           // System.out.println(regexRule);
            /*我们只希望抽取满足正则约束的URL，
             Links.addAllFromDocument为我们提供了相应的功能*/
            nextLinks.addByRegex(doc, regexRule);
            if(nextLinks!=null && nextLinks.size()>0){
            	for(int ni = 0;ni<nextLinks.size();ni++){
            		CrawlDatum datum = new CrawlDatum(nextLinks.get(ni))
            				.putMetaData("srcId", page.getMetaData("srcId")).putMetaData("index", page.getMetaData("index"));
            		next.add(datum);
            	}
            }
           // next.add(nextLinks);

            /*Links类继承ArrayList<String>,可以使用add、addAll等方法自己添加URL
             如果当前页面的链接中，没有需要爬取的，可以return null
             例如如果你的爬取任务只是爬取seed列表中的所有链接，这种情况应该return null
             */
            //return nextLinks;
        }
        
        //return null;
       
        
	}
	
	public byte[] getFileFromURL(String urlStr) throws Exception{
		//byte[] content = new byte[1024*512];
		URL url = new URL(urlStr);
		URLConnection uc = url.openConnection(); 
		InputStream   is   =   uc.getInputStream();
		//is.read(content);
		
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[1024];  
        int rc = 0;  
        while ((rc = is.read(buff, 0, 1024)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] content = swapStream.toByteArray();  
		
		return content;
	}
	
	/*public static void startCrawler(){
		CrawlNewsInfoSource source = new CrawlNewsInfoSource();
		source.setIsValid(Constant.VALID);
		List<CrawlNewsInfoSource> sourcesList = crawlNewsInfoService.getSourceList(source);
		if(sourcesList!=null && sourcesList.size()>0){
			for(int i = 0;i<sourcesList.size();i++){
				String searchUrl = sourcesList.get(i).getSiteUrl();
				//regexRule.addRule(searchUrl);
				NewsInfoCrawler crawler = new NewsInfoCrawler("F:\\tests", searchUrl,sourcesList.get(i).getInfoConfigs());
				crawler.setThreads(50);
		        crawler.addSeed("http://www.gapp.gov.cn/news/1656.shtml");
		        crawler.setResumable(false);
			}
		}
	}*/
	
	public Document prependServerInfo4ImageUrl(Document doc){
		logger.info("替换图片的URL地址,");
		Elements eles = doc.getAllElements();
		if(eles!=null && eles.size()>0){
			for(int i=0;i<eles.size();i++){
				Element ele = eles.get(i);
				if(ele.hasAttr("href")){
                    String absHref=ele.attr("abs:href");
                    ele.attr("href",absHref);
                }
				if(ele.hasAttr("src")){
                    String absSrc=ele.attr("abs:src");
                    ele.attr("src",absSrc);
                }
			}
		}
		return doc;
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
	private String createStartUrl(int pagenum, String startUrl, String pageReg) {
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
	}

}
