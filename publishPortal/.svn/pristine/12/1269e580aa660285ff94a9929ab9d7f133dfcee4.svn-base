package cn.com.shukaiken.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PictureCheckCodeUtil {
	private static int lineSize = 40;//干扰线数量
	private static int stringNum = 4;//随机产生字符数量
	private static String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串
	private static Random random = new Random();
	/**
	 * 获取随机颜色
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	public static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param width（图片的宽度）
	 * @param height（图片的高度）
	 * @param x（字符在图片的x坐标）
	 * @param y（字符在图片的y坐标）
	 * @param fontSize（字符的大小）
	 * @return
	 */
	public static BufferedImage getCode(HttpServletRequest request,
			HttpServletResponse response,int width,int height,int x,int y,int fontSize) {
		// 禁止缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		//BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();//产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(110, 133));
		//绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g,width,height);
		}
		//绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}
		
		//	System.out.println(randomString);
			g.dispose();
		
		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		//Encode encode = new Encode(); // 声明并实例化Encode的实例
		session.setAttribute("validCode", randomString.toUpperCase());
		session.setMaxInactiveInterval(Constant.SESSION_VAL);
		g.dispose();
		return image;
	}
	
	/*
	 * 获得字体
	 */
	private static Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}
	
	/*
	 * 绘制字符串
	 */
	private static String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
				.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(randString
				.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return randomString;
	}

	/*
	 * 绘制干扰线
	 */
	private static void drowLine(Graphics g,int width,int height) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/*
	 * 获取随机的字符
	 */
	public static String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
}
