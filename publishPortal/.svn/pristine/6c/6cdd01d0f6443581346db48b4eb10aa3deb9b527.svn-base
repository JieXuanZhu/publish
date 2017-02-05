package cn.com.shukaiken.util.tree.ztree;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * dtree简单标签库
 * @author Yuanxulong
 *
 */
public class TreeNodeTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	protected Iterator<?> iterator = null;
	
	protected String scope = null;

	protected String name = null;

	protected String title = null;

	protected String check = null;

	//protected String write = null;

	protected String openAll = null;
	
	protected String valueName = null;
	
	private String ids = null;
	

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenAll() {
		return openAll;
	}

	public void setOpenAll(String openAll) {
		this.openAll = openAll;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public int doStartTag() throws JspException {
		Object treeDatas = null;
        if ("page".equalsIgnoreCase(scope)) {
            treeDatas = pageContext.getAttribute(name, PageContext.PAGE_SCOPE);
            if(valueName != null && valueName.trim().length() > 0) {
            	ids = (String)pageContext.getAttribute(valueName, PageContext.PAGE_SCOPE);
            }
        }
        else if ("request".equalsIgnoreCase(scope)) {
            treeDatas = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
            if(valueName != null && valueName.trim().length() > 0) {
            	ids = (String)pageContext.getAttribute(valueName, PageContext.REQUEST_SCOPE);
            }
        }
        else if ("session".equalsIgnoreCase(scope)) {
            treeDatas = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
            if(valueName != null && valueName.trim().length() > 0) {
            	ids = (String)pageContext.getAttribute(valueName, PageContext.SESSION_SCOPE);
            }
        }
        else if ("application".equalsIgnoreCase(scope)) {
            treeDatas = pageContext.getAttribute(name, PageContext.APPLICATION_SCOPE);
            if(valueName != null && valueName.trim().length() > 0) {
            	ids = (String)pageContext.getAttribute(valueName, PageContext.APPLICATION_SCOPE);
            }
        }

        if (treeDatas == null) {
            return (SKIP_BODY);
        }
        iterator = ((Collection<?>) treeDatas).iterator();

        StringBuffer sb = new StringBuffer();
        
        sb.append("<script type='text/javascript'>\n");
        sb.append("var " +  name+" = new dTree('"+name+"');\n");
        //sb.append(name+".config.inOrder = true;\n");
        //复选框
        if(check != null && "check".equals(check)) {
        	sb.append(name+".config.check = true;\n");
        }
        sb.append(name+".add('0','-1','"+title+"');");
        tree(iterator, sb);
        sb.append("document.write("+name+");\n");
        if(openAll != null) {
        	sb.append(name).append(".openAll()\n");
        }
        if(ids != null && ids.trim().length() > 0) {
        	sb.append(name).append(".checkByIds(\"").append(ids).append("\")\n");
        }
        sb.append("</script>\n");
        try {
            pageContext.getOut().print(sb.toString());
        }
        catch (IOException e) {
        	
        }
		return SKIP_BODY;
	}
	private void tree(Iterator<?> iter, StringBuffer sb) {
		while (iter.hasNext()) {
            TreeNode node = (TreeNode) iter.next();

            //d.add(1003,1001,'Node 1.1','example01.html');
            //因编号为001开始，需在编号前加1
            String ID = node.getID();
            String parentID = "0";
            if (node.getParentID() != null ) {
                parentID = node.getParentID();
            }
            sb.append(name+".add('" + ID + "','" + parentID + "',\"" +
                    node.getName() + "\",'',\"" + node.getTitle() + "\");\n");
        }
	}
	@Override
	public  void release() {
		this.check = null;
		this.id = null;
		this.ids = null;
		this.valueName = null;
		this.iterator = null;
		this.name = null;
		this.openAll = null;
		this.scope = null;
		this.title = null;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

}
