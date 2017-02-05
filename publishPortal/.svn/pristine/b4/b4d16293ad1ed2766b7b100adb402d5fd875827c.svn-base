package cn.com.shukaiken.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.github.pagehelper.PageInfo;


/**
 * 标签类 用于分页查询,使用PageInfo
 * @author 
 *
 */
public class PageInfoTag extends TagSupport {
	/**  
	*  序列化 
	*/
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private PageInfo pageinfo;

	@Override
	@SuppressWarnings({ "static-access", "unused" })
	public int doStartTag() {
		////标签开始时调用的方法
		try {
			StringBuilder sb=new StringBuilder();
			JspWriter out = pageContext.getOut();
			Integer pagersize=null;
			if(pageinfo!=null)
			{
				 pagersize=pageinfo.getPageSize();
			}
			
			sb.append("<div class='pages'><span>");
			
			if(pageinfo==null){
				sb.append("共0条</span></div>");
				out.print(sb.toString());
				out.flush();
				return super.SKIP_BODY;
			}else if(pageinfo.getTotal()==0){
				sb.append("共0条</span></div>");
				out.print(sb.toString());
				out.flush();
				return super.SKIP_BODY;
			}
			
			
			sb.append("共"
					+ (pageinfo.getTotal()) + "条,当前");
		    sb.append(pageinfo.getPageNum());
			sb.append("/"+  pageinfo.getPages() +"页</span>");
			

			if (pageinfo.getPageNum() != 1) {
				sb.append("&nbsp;&nbsp;<a href='javascript:void(0);' onclick='gotoPage(1,this)");
				sb.append("'>首页</a>&nbsp;&nbsp;");
				
				
				sb.append("&nbsp;&nbsp;<a href='javascript:void(0);' onclick='gotoPage("+pageinfo.getPrePage()+",this)");
				sb.append("'>上一页</a>&nbsp;&nbsp;");
			}


			if (pageinfo.getPageNum()!=pageinfo.getPages() && !pageinfo.isIsLastPage() && pageinfo.getPages() != 0) {
				sb.append("&nbsp;&nbsp;<a href='javascript:void(0);' onclick='gotoPage("+pageinfo.getNextPage()+",this)"); 
				sb.append("'>下一页</a>&nbsp;&nbsp;");
				sb.append("&nbsp;&nbsp;<a href='javascript:void(0);' onclick='gotoPage("+pageinfo.getPages()+",this)"); 
				sb.append("'>末页</a>&nbsp;&nbsp;");
			}
			
			sb.append("<input type='text' size='5' id='goPage' class='w60' />&nbsp;&nbsp;");
			sb.append("&nbsp;&nbsp;<input  type='button' value='确定' onclick='gotoInputPage(this)' /></div>");
			sb.append("\n<script type='text/javascript'>");
	        sb.append(" function gotoPage(pageNum,selector){\n");
	        sb.append("var formId = $(selector).closest('form').attr('id');\n");
	        sb.append("$('#'+formId).append('<input type=\"hidden\" id=\"pageNum\" name=\"pageNum\">');\n");
	        sb.append("$('#'+formId+' #pageNum').val(pageNum);\n");
	        sb.append("$('#'+formId).submit();\n");
	        sb.append("}\n");
	        sb.append("\n");
	        sb.append(" function gotoInputPage(selector){\n");
	        sb.append("var p=document.getElementById('goPage').value;\n");
	        sb.append("if(p==null || p=='') {alert('请输入一个有效的页数！'); return;}\n");
	        sb.append("	if(checkInputNumber(p)) {\n");
	        sb.append("gotoPage(p,selector);\n");
	        sb.append("	} else {\n");
	        sb.append("		alert('请输入一个有效的页数！');\n");
	        sb.append("	}\n");
	        sb.append("}\n");
			
			sb.append(" function checkInputNumber(str) {\n");
		    sb.append("	var comp = '0123456789';\n");
		    sb.append("	var flag = true;\n");
	        sb.append("	for(var i=0; i<str.length; i++) {\n");
	        sb.append("		if(comp.indexOf(str.substr(i,1)) == -1) {\n");
	        sb.append("			flag = false;\n");
	        sb.append("			break;\n");
	        sb.append("		}\n");
	        sb.append("	}\n");
	        sb.append("	if(flag) {\n");
	        sb.append("		if(parseInt(str) <= 0 || parseInt(str) > " + pageinfo.getPages() + ") {\n");
	        sb.append("			flag = false;\n");
	        sb.append("		}\n");
	        sb.append("	}\n");
	        sb.append("	return flag;\n");
	        sb.append("}\n");
			
			sb.append("</script>");
			out.print(sb.toString());
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return super.SKIP_BODY;//表示不显示标签间的文字
	}

	@Override
	@SuppressWarnings("static-access")
	public int doEndTag() {
		//标签结束时调用的方法
		return super.EVAL_PAGE;//表示JSP页面继续运行
	}

	@SuppressWarnings("rawtypes")
	public PageInfo getPageinfo() {
		return pageinfo;
	}

	@SuppressWarnings("rawtypes")
	public void setPageinfo(PageInfo pageinfo) {
		this.pageinfo = pageinfo;
	}
	
}
