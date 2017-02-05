package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
    static String url="http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	
    	test();
        //BolgBody();
        // article();
        //Blog();
        /*
         * Document doc = Jsoup.connect("http://www.oschina.net/")
         * .data("query", "Java") // 请求参数 .userAgent("I ’ m jsoup") // 设置
         * User-Agent .cookie("auth", "token") // 设置 cookie .timeout(3000) //
         * 设置连接超时时间 .post();
         */// 使用 POST 方法访问 URL

        /*
         * // 从文件中加载 HTML 文档 File input = new File("D:/test.html"); Document doc
         * = Jsoup.parse(input,"UTF-8","http://www.oschina.net/");
         */
    }
    
    public static void test() throws IOException{
        Document doc = Jsoup.connect("http://www.dongyicaifu.com/front/contactus/aboutUs").get();
    	Element body = doc.body();
    	Elements AllA = body.getElementsByTag("a");
    	 for (Element element :AllA) {
             Elements links = element.getElementsByTag("a");
             for (Element link : links) {
                 String linkHref = link.attr("abs:href");
                 linkHref = link.absUrl("href");
                 String linkText = link.text().trim();
                 System.out.println(linkHref);
                 System.out.println(linkText);
             }
         }
    	System.out.println(body);
    	Element input = doc.getElementById("currentPageInfo");
    	String input_value = doc.getElementById("currentPageInfo").val();
    	System.out.println(input);
		System.out.println(input_value);
    	
    	String title = doc.title();
    	String text = doc.text();
        System.out.println(title);  
        System.out.println(text);
    }

    /**
     * 获取指定HTML 文档指定的body
     * @throws IOException
     */
    @SuppressWarnings("unused")
	private static void BolgBody() throws IOException {
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
        
        
        // 从 URL 直接加载 HTML 文档
        Document doc2 = Jsoup.connect(url).get();
        String title = doc2.body().toString();
        System.out.println(title);
    }

    /**
     * 获取博客上的文章标题和链接
     */
    public static void article() {
        Document doc;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get();
            System.out.println(doc);
            Elements ListDiv = doc.getElementsByAttributeValue("class","postTitle");
            for (Element element :ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim();
                    System.out.println(linkHref);
                    System.out.println(linkText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取指定博客文章的内容
     */
    public static void Blog() {
        Document doc;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html").get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","postBody");
            for (Element element :ListDiv) {
                System.out.println(element.html());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
