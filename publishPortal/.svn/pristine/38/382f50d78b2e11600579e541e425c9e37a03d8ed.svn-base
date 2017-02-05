package cn.com.shukaiken.util;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


public class JsoupUtil {
	
	//main方法
	public static void main(String[] args) {
		Document doc = getDocumentByURL("https://book.douban.com/");
		System.out.println(doc);
	/*	Document doc = getDocumentByURL("http://book.douban.com/subject/26320883/?icn=index-editionrecommend");
		String val = doc.select("span:containsOwn(作者)").first().parent().select("a[href]").first().text();
		System.out.println(val);
		
		System.out.println(doc.select("span:containsOwn(出版社)").first().parent().text());
		System.out.println(doc.select("span:containsOwn(出版社)").first().nextElementSibling());*/
		
		//String e = doc.select("span.pl").first().parent().select("a[href]").first().text();
		//System.out.println(doc.select("#info").html());
		//System.out.println(doc.select("#cbs").html());
		//Elements val3 = doc.select("span:containsOwn(出版社)").first().parent().children();
//		for(Element ele:val3){
//			System.out.println(ele.select(cssQuery));
//		}
	   // System.out.println(doc.html());
		
		/*Document doc = getDocumentByURL("http://mp.weixin.qq.com/s?__biz=MzAxNzY3OTI5MA==&mid=400226793&idx=3&sn=1379e7ff9469334e8b03dc8409d58699&3rd=MzA3MDU4NTYzMw==&scene=6#wechat_redirect");
		Element  wz_title = doc.getElementById("activity-name");
		Elements img = doc.getElementsByAttributeValue("class", "tn-Powered-by-XIUMI");
		
		 for (Element element :img) {
			// System.out.println(element);
             Elements imgs = element.getElementsByTag("img");
            // System.out.println(imgs);
             for (Element image : imgs) {
            	 //System.out.println(image);
                 String imageSrc = image.attr("data-src");
                 System.out.println(imageSrc);
             }
         }
		System.out.println(wz_title);
		System.out.println(wz_title.text());*/
	}
	
	
	public static void getDouBanDataByURL(String url){
		Document doc = getDocumentByURL("http://book.douban.com/subject/26320883/?icn=index-editionrecommend");
				
		//doc =getDocumentByURL("http://book.douban.com/subject/26592555/?icn=index-editionrecommend");
		Element ele = doc.select("h1>span[property=v:itemreviewed]").first();
		
		if(ele!=null){
			String title = ele.text().trim();
			System.out.println(title);
		}
		ele = doc.select("span:containsOwn(作者)").first().parent().select("a[href]").first();
		if(ele!=null){
			String author = ele.text().trim();
			System.out.println(author);
		}
		ele = doc.select("span:containsOwn(出版社)").first();
		if(ele!=null){
			//publisher
			System.out.println(ele.nextSibling().toString().trim());
		}
		ele= doc.select("span:containsOwn(原作名)").first();
		if(ele!=null){
			//original_titile
			System.out.println(ele.nextSibling().toString().trim());
		}
		ele= doc.select("span:containsOwn(译者)").first().parent().select("a[href]").first();
		if(ele!=null){
			//translator
			System.out.println(ele.text().trim());
		}
		ele= doc.select("span:containsOwn(出版年)").first();
		if(ele!=null){
			//publish_year
			System.out.println(ele.nextSibling().toString().trim());
		}
		ele= doc.select("span:containsOwn(页数)").first();
		if(ele!=null){
			//page_size
			System.out.println(ele.nextSibling().toString().trim());
		}
		ele= doc.select("span:containsOwn(定价)").first();
		if(ele!=null){
			//price
			System.out.println(ele.nextSibling().toString().trim());
		}
		
		ele= doc.select("span:containsOwn(装帧)").first();
		if(ele!=null){
			//bind
			System.out.println(ele.nextSibling().toString().trim());
		}
		
		ele= doc.select("span:containsOwn(ISBN)").first();
		if(ele!=null){
			//isbn
			System.out.println(ele.nextSibling().toString().trim());
		}
		
		ele= doc.select("div.intro").first();
		if(ele!=null){
			//content_brief
			if(!ele.text().endsWith("(展开全部)")){
				System.out.println(ele.html());
			}else{
				//System.out.println(doc.select("div.intro").get(1).text());
				//System.out.println(doc.select("div.intro").get(1).html());
			}
		}
	
		ele = doc.select("div.intro").last();
		if(ele!=null){
			//author_brief
			System.out.println(ele.html());
		}
				
	}
	
	public static void getDoubanDataByUrlAndSelector(String url,String selStr){
		Document doc = getDocumentByURL("http://book.douban.com/subject/26320883/?icn=index-editionrecommend");
		List<Node> nodes = doc.select("#info").first().childNodes();
		Elements eles = doc.select("#info").first().getAllElements();
		/*for(Element ele:eles){
			System.out.println(ele+"-----"+ele.nodeName());
		}*/
		for(Node node:nodes){
			//System.out.println(node+"-----"+node.nodeName());
			if("#text".equals(node.nodeName())){
				//node.wrap("<div></div>");
				Node n = node.wrap("<b></b>");
				//System.out.println(n+"---"+n.nodeName());
			}
			//System.out.println(node.wrap("<b></b>")+"-----"+node.wrap("<b></b>").nodeName());
		}
		//System.out.println(doc.select("#info"));
		System.out.println(doc.select("#info>span.pl:contains(出版社)"));
		System.out.println(doc.select("#info>span.pl:contains(出版社) + b").text());
		/*String h = "<p><b>This</b> is <b>jsoup</b></p>";
        Document doc1 = Jsoup.parse(h);
        doc1.select("b").wrap("<i></i>");
        System.out.println(doc1.body().html());
        System.out.println(doc1.select("b").wrap("<i></i>"));*/
        //assertEquals("<p><i><b>This</b></i> is <i><b>jsoup</b></i></p>", doc1.body().html());
		
	}
	
	/**
	 * 根据url抓取网页的文档对象
	 * @param url
	 * @return
	 */
	public static Document getDocumentByURL(String url){
		Document doc = null;
		 try {
			 if(url!=null && url.length()>0){
				 doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0").get(); 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return doc;
	}
	
	/**
	 * 根据url抓取网页的元数据信息
	 * @param url
	 * @return
	 */
	public static String captureBooKNameByURL(String url){
		Document doc = getDocumentByURL(url);
		String data = null;
		if(doc!=null){
			data = doc.data();
		}
		return data;
	}
	
	/**
	 * 根据url抓取网页的元数据信息
	 * @param url
	 * @return
	 */
	public static String captureDataByURL(String url){
		Document doc = getDocumentByURL(url);
		String data = null;
		if(doc!=null){
			data = doc.data();
		}
		return data;
	}
	
	/**
	 * 根据url抓取网页的主标题
	 * @param url
	 * @return
	 */
	public static String captureTitleByURL(String url){
		Document doc = getDocumentByURL(url);
		String title = null;
		if(doc!=null){
			title = doc.title();
		}
		return title;
	}
	
	/**
	 * 根据url抓取文章的文本内容
	 * @param url
	 * @return
	 */
	public static String captureHTMLByURL(String url){
		Document doc = getDocumentByURL(url);
		String text = null;
		if(doc!=null){
			text = doc.text();
		}
		return text;
	}
	
	

}
