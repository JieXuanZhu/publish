package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import cn.com.shukaiken.util.JSONHelper;
import cn.com.shukaiken.util.UploadImageUtil;
import cn.com.shukaiken.webService.IAppCustWebService;

/**
* 把一个文件转化为byte[]数据,然后把字节写入一个新文件里面
* @author spring sky
* Email:vipa1888@163.com
*QQ:840950105
*
*/
public class TestFileUpload {
	
	public static void main(String[] args) {
		File file = new File("D:/uploadImg/giftImg/IMAG0286.jpg");
		try {
			byte[] b = getByte(file);
			String base64Str = UploadImageUtil.encode(b);
			Service serviceModel = new ObjectServiceFactory().create(IAppCustWebService.class);
			IAppCustWebService service;
			try {
				service = (IAppCustWebService) new XFireProxyFactory().create(serviceModel,"http://42.96.165.121:8086/service/IAppCustWebService");
				//service = (IAppCustWebService) new XFireProxyFactory().create(serviceModel,"http://192.168.1.186:8080/publish/service/IAppCustWebService");
				// 参数：文件的字节数组，上传目的地路径，文件名称
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("cust_id", 2);
				map.put("data", base64Str);
				String jsonStr = JSONHelper.getJsonByMap(map);
			    jsonStr = service.setCustHeadImg(jsonStr);
				// 打印返回值
				System.out.println("jsonStr=" + jsonStr);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		

	}


		@SuppressWarnings("resource")
		public static byte[] getByte(File file) throws Exception{
			
			byte[] bytes = null;
			
			if(file!=null){
				
				InputStream is = new FileInputStream(file);
				
				int length = (int) file.length();
				//当文件的长度超过了int的最大值
				if(length>Integer.MAX_VALUE){
					System.out.println("this file is max ");
					return null;
				}
			
				bytes = new byte[length];
			
				int offset = 0;
				
				int numRead = 0;
				
				 while(offset<bytes.length&&(numRead=is.read(bytes,offset,bytes.length-offset))>=0)
		            {
		                offset+=numRead;
		            }
				//如果得到的字节长度和file实际的长度不一致就可能出错了
				 if(offset<bytes.length){
					System.out.println("file length is error");
					return null;
				}
				is.close();
			}
			return bytes;
		}
		
}