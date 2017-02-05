package cn.com.shukaiken.util.tree.ztree;

public enum EnumNodeTag {
	//总类（所有HTML文件都有的）
	tag_html("html","HTML", 2, "", "","", new Property()),
	tag_title("title","TITLE", 2, "", "","", new Property()),
	tag_head("head","HEAD", 2, "", "","", new Property()),
	tag_body("body","BODY", 2, "", "","", new Property()),

	//结构性定义（由浏览器控制的显示风格）
	tag_h1("h1","H1", 2, "", "","", new Property()),
	tag_h2("h2","H2", 2, "", "","", new Property()),
	tag_h3("h3","H3", 2, "", "","", new Property()),
	tag_h4("h4","H4", 2, "", "","", new Property()),
	tag_h5("h5","H5", 2, "", "","", new Property()),
	tag_h6("h6","H6", 2, "", "","", new Property()),
	tag_div("div","DIV", 2, "", "","", new Property()),
	tag_blockquote("blockquote","BLOCKQUOTE", 2, "", "","", new Property()),
	tag_em("em","EM", 2, "", "","", new Property()),
	tag_strong("strong","STRONG", 2, "", "","", new Property()),
	tag_cite("cite","CITE", 2, "", "","", new Property()),
	tag_code("code","CODE", 2, "", "","", new Property()),
	tag_samp("samp","SAMP", 2, "", "","", new Property()),
	tag_kbd("kbd","KBD", 2, "", "","", new Property()),
	tag_var("var","VAR", 2, "", "","", new Property()),
	tag_address("address","ADDRESS", 2, "", "","", new Property()),
	tag_big("big","BIG", 2, "", "","", new Property()),
	tag_small("small","SMALL", 2, "", "","", new Property()),
	
	//与外观相关的标签（作者自订的表现方式）
	tag_b("b","B", 2, "", "","", new Property()),
	tag_i("i","I", 2, "", "","", new Property()),
	tag_u("u","U", 2, "", "","", new Property()),
	tag_s("s","S", 2, "", "","", new Property()),
	tag_sub("sub","SUB", 2, "", "","", new Property()),
	tag_sup("sup","SUP", 2, "", "","", new Property()),
	tag_tt("tt","TT", 2, "", "","", new Property()),
	tag_pre("pre","PRE", 2, "", "","", new Property()),
	tag_center("center","CENTER", 2, "", "","", new Property()),
	tag_blink("blink","BLINK", 2, "", "","", new Property()),
	tag_font("font","FONT", 2, "", "","", new Property()),
	tag_basefont("basefont","BASEFONT", 2, "", "","", new Property()),
	
	//链接与图形
	tag_a("a","A", 2, "", "","", new Property()),
	tag_img("img","IMG", 1, "", "","", new Property()),
	tag_map("map","MAP", 2, "", "","", new Property()),
	tag_area("area","AREA", 2, "", "","", new Property()),
	tag_meta("meta","META", 2, "", "","", new Property()),
	tag_embed("embed","EMBED", 2, "", "","", new Property()),
	tag_marquee("marquee","MARQUEE", 2, "", "","", new Property()),
	tag_bgsound("bgsound","BGSOUND", 2, "", "","", new Property()),
	
	//分隔
	tag_p("p","P", 2, "", "","", new Property()),
	tag_br("br","BR", 1, "", "","", new Property()),
	tag_hr("hr","HR", 1, "", "","", new Property()),
	tag_nobr("nobr","NOBR", 1, "", "","", new Property()),
	tag_wbr("wbr","WBR", 1, "", "","", new Property()),
	
	
	//列举（可以巢状列举）
	tag_ul("ul","UL", 2, "", "","", new Property()),
	tag_ol("ol","OL", 2, "", "","", new Property()),
	tag_li("li","LI", 2, "", "","", new Property()),
	tag_dl("dl","DL", 2, "", "","", new Property()),
	tag_dd("dd","DD", 2, "", "","", new Property()),
	tag_dt("dt","DT", 2, "", "","", new Property()),
	tag_menu("menu","MENU", 2, "", "","", new Property()),
	tag_dir("dir","DIR", 2, "", "","", new Property()),
	
	//特殊字元（以下标签需用小写）
	tag_dlt("&lt;","&LT;", 1,"<", "", "", new Property()),
	tag_dgt("&gt;","&GT;", 1, ">", "","", new Property()),
	tag_damp("&amp;","&AMP;", 1, "&", "","", new Property()),
	tag_dquot("&quot;","&QUOT;", 1, "''", "","", new Property()),
	tag_dreg("&reg;","&REG;", 1, "TM", "","", new Property()),
	tag_dcopy("&copy;","&COPY;", 1, "", "","", new Property()),
	
	//表单（通常需要与CGI程式配合）
	tag_form("form","FORM", 2, "", "","", new Property()),
	tag_input("input","INPUT", 1, "", "","", new Property()),
	tag_select("select","SELECT", 2, "", "","", new Property()),
	tag_option("option","OPTION", 1, "", "","", new Property()),
	tag_textarea("textarea","TEXTAREA", 2, "", "","", new Property()),

	//表格
	tag_table("table","TABLE", 2, "", "","", new Property()),
	tag_th("th","TH", 2, "", "","", new Property()),
	tag_tr("tr","TR", 2, "", "","", new Property()),
	tag_td("td","TD", 2, "", "","", new Property()),
	tag_caption("caption","CAPTION", 2, "", "","", new Property()),

	//视框（定义与控制萤幕上的特定区域）
	tag_frameset("frameset","FRAMESET", 2, "", "","", new Property()),
	tag_frame("frame","FRAME", 2, "", "","", new Property()),
	tag_noframes("noframes","NOFRAMES", 2, "", "","", new Property()),
	tag_iframe("iframe","IFRAME", 2, "", "","", new Property()),
	
	//杂项
	tag_doctype("caption","!DOCTYPE", 1, "", "","", new Property()),
	tag_isindex("isindex","ISINDEX", 2, "", "","", new Property()),
	tag_base("base","BASE", 2, "", "","", new Property()),
	tag_link("link","LINK", 2, "", "","", new Property());

	
	private String tag;//标签
	private String tagB;//大写
	private String tagZY;//转义
	private Integer type;//类型
	private String text;//文本
	private String html;//内容html
	private Property property;
	
	private EnumNodeTag(String tag, String tagB, Integer type, String tagZY, String text, String html, Property property) {
		this.tag = tag;
		this.type = type;
		this.text = text;
		this.html = html;
		this.property = property;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTagB() {
		return tagB;
	}

	public void setTagB(String tagB) {
		this.tagB = tagB;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	
	public String getTagZY() {
		return tagZY;
	}

	public void setTagZY(String tagZY) {
		this.tagZY = tagZY;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public static void main(String[] args) {
		EnumNodeTag test = EnumNodeTag.tag_a; 
        switch (test) { 
        case tag_a: 
            System.out.println("今天是星期一"); 
            break; 
        case tag_p: 
            System.out.println("今天是星期二"); 
            break; 
        // ... ... 
        default: 
            System.out.println(test); 
            break; 
        } 
	}
}
