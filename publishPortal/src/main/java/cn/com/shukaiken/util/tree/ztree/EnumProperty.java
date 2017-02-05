package cn.com.shukaiken.util.tree.ztree;

import java.util.ArrayList;
import java.util.List;

public enum EnumProperty {
	//总类（所有HTML文件都有的）
	prop_id("id","ID", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_name("name", "NAME", new String[]{}, new String[]{"description","generator","author","copyright"}, new ArrayList<EnumNodeTag>()),
	prop_value("value", "VALUE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_align("align", "ALIGN", new String[]{}, new String[]{"texttop","absmiddle","baseline","basebottom","top","bottom","middle","left","center","right","justify"}, new ArrayList<EnumNodeTag>()),
	prop_valign("valign", "VALIGN", new String[]{}, new String[]{"top","bottom","middle"}, new ArrayList<EnumNodeTag>()),
	prop_size("size", "SIZE", new String[]{}, new String[]{"1","2","3","4","5","6","7","+1","+2","+3","+4","+5","+6","+7","-1","-2","-3","-4","-5","-6","-7","0"}, new ArrayList<EnumNodeTag>()),
	prop_color("color", "COLOR", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_bgcolor("bgcolor", "BGCOLOR", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_bordercolor("bordercolor", "BORDERCOLOR", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_bordercolorlight("bordercolorlight", "BORDERCOLORLIGHT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_bordercolordark("bordercolordark", "BORDERCOLORDARK", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_href("href", "HREF", new String[]{}, new String[]{"nohref",}, new ArrayList<EnumNodeTag>()),
	prop_url("url", "URL", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_link("link", "LINK", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_alink("alink", "ALINK", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_vlink("vlink", "VLINK", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_src("src", "SRC", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_target("target", "TARGET", new String[]{}, new String[]{"_self","_parent","_top","_blank"}, new ArrayList<EnumNodeTag>()),
	prop_alt("alt", "ALT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_usemap("usemap", "USEMAP", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_shape("shape", "SHAPE", new String[]{}, new String[]{"poly","circle","rect"}, new ArrayList<EnumNodeTag>()),
	prop_coords("coords", "coords", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_width("width", "WIDTH", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_height("height", "HEIGHT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_border("border", "BORDER", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_hspace("hspace", "HSPACE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_vspace("vspace", "VSPACE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_content("content", "CONTENT", new String[]{}, new String[]{"text/html;charset=gb2312", "1;url=http://www.sina.com.cn", "Mon,12,May,2007 00:00:00 GMT","_top", "_blank", "_parent", "_self"}, new ArrayList<EnumNodeTag>()),
	prop_httpequiv("http-equiv", "HTTP-EQUIV", new String[]{}, new String[]{"Content-Type","Refresh","Expires","Windows-Target"}, new ArrayList<EnumNodeTag>()),
	prop_clear("clear", "CLEAR", new String[]{}, new String[]{"left","right","all"}, new ArrayList<EnumNodeTag>()),
	prop_type("type", "TYPE", new String[]{}, new String[]{"disc","circle","square","A","a","I","i","1","text","password","checkbox","radio","image","hidden","submit","reset","button","file"}, new ArrayList<EnumNodeTag>()),
	prop_background("background", "BACKGROUND", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_text("text", "TEXT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_title("title", "TITLE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_action("action", "ACTION", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_method("method", "METHOD", new String[]{}, new String[]{"get","post"}, new ArrayList<EnumNodeTag>()),
	prop_enctype("enctype", "ENCTYPE", new String[]{}, new String[]{"multipart/form-data"}, new ArrayList<EnumNodeTag>()),
	prop_checked("checked", "CHECKED", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_maxlength("maxlength", "MAXLENGTH", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_multiple("multiple", "MULTIPLE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_selected("selected", "SELECTED", new String[]{}, new String[]{"selected"}, new ArrayList<EnumNodeTag>()),
	prop_rows("rows", "ROWS", new String[]{}, new String[]{"selected"}, new ArrayList<EnumNodeTag>()),
	prop_cols("cols", "COLS", new String[]{}, new String[]{"selected"}, new ArrayList<EnumNodeTag>()),
	prop_wrap("wrap", "WRAP", new String[]{}, new String[]{"off","virtual","physical"}, new ArrayList<EnumNodeTag>()),
	prop_cellspacing("cellspacing", "CELLSPACING", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_cellpadding("cellpadding", "CELLPADDING", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_colspan("colspan", "COLSPAN", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_rowspan("rowspan", "ROWSPAN", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_marginwidth("marginwidth", "MARGINWIDTH", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_marginHeight("marginHeight", "MARGINHEIGHT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrolling("scrolling", "SCROLLING", new String[]{}, new String[]{"YES","NO","AUTO"}, new ArrayList<EnumNodeTag>()),
	prop_prompt("prompt", "PROMPT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_rev("rev", "REV", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_rel("rel", "REL", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_noshade("noshade", "NOSHADE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_noresize("noresize", "NORESIZE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_readonly("readonly", "READONLY", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_disable("disable", "DISABLE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrollamount("scrollamount", "SCROLLAMOUNT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrolldelay("scrolldelay", "SCROLLDELAY", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrollHeight("scrollHeight", "SCROLLHEIGHT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrollLeft("scrollLeft", "SCROLLLEFT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_scrollTop("scrollTop", "SCROLLTOP", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_direction("direction", "DIRECTION", new String[]{}, new String[]{"left", "right", "up", "down"}, new ArrayList<EnumNodeTag>()),
	prop_style("style", "STYLE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_rules("style", "STYLE", new String[]{}, new String[]{"none"}, new ArrayList<EnumNodeTag>()),
	prop_autostart("autostart", "AUTOSTART", new String[]{}, new String[]{"true", "false"}, new ArrayList<EnumNodeTag>()),
	prop_starttime("starttime", "STARTTIME", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_loop("loop", "LOOP", new String[]{}, new String[]{"true", "false", "-1"}, new ArrayList<EnumNodeTag>()),
	prop_volume("volume", "VOLUME", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_hidden("hidden", "HIDDEN", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_controls("controls", "CONTROLS", new String[]{}, new String[]{"comsole", "smallconsole"}, new ArrayList<EnumNodeTag>()),
	prop_accesskey("accesskey", "ACCESSKEY", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_accept("accept", "ACCEPT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_tabindex("tabindex", "TABINDEX", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_disabled("disabled", "DISABLED", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_noreset("noreset", "NORESET", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_onsubmit("onsubmit", "ONSUBMIT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_onfocus("onfocus", "ONFOCUS", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_onblur("onblur", "ONBLUR", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_onselect("onselect", "ONSELECT", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_onchang("onchang", "ONCHANGE", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_frameborder("frameborder", "FRAMEBORDER", new String[]{}, new String[]{"0", "1"}, new ArrayList<EnumNodeTag>()),
	prop_behavior("behavior", "BEHAVIOR", new String[]{}, new String[]{"slide", "scroll", "alternate"}, new ArrayList<EnumNodeTag>()),
	prop_topmargin("topmargin", "TOPMARGIN", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>()),
	prop_leftmargin("leftmargin", "LEFTMARGIN", new String[]{}, new String[]{}, new ArrayList<EnumNodeTag>());


	private String name;//属性名
	@SuppressWarnings("unused")
	private String nameB;//属性名
	private String[] values;//属性值
	private String[] dValues;//默认属性值
	private List<EnumNodeTag> tagList;//应用标签列表
	

	private EnumProperty(String name, String nameB, String[] values, String[] dValues,
			List<EnumNodeTag> tagList) {
		this.name = name;
		this.nameB = nameB;
		this.values = values;
		this.dValues = dValues;
		this.tagList = tagList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String[] getdValues() {
		return dValues;
	}

	public void setdValues(String[] dValues) {
		this.dValues = dValues;
	}

	public List<EnumNodeTag> getTagList() {
		return tagList;
	}

	public void setTagList(List<EnumNodeTag> tagList) {
		this.tagList = tagList;
	}

	public static void main(String[] args) {
		EnumProperty test = EnumProperty.prop_accept; 
        switch (test) { 
        case prop_accept: 
            System.out.println("今天是星期一"); 
            break; 
        case prop_action: 
            System.out.println("今天是星期二"); 
            break; 
        // ... ... 
        default: 
            System.out.println(test); 
            break; 
        } 
	}
}
