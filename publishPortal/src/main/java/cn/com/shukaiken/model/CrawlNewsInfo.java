package cn.com.shukaiken.model;

public class CrawlNewsInfo {
    private Integer id;

    private String title;

    private String subtitle;

    private String releasetime;

    private String author;

    private String newstype;

    private String attachments;

    private String viewcount;

    private String newsoriginal;

    private String crawleroriginal;

    private String crawlertime;

    private String indexnum;

    private String themetype;

    private String publishorgan;

    private String publishdate;

    private String name;

    private String themeword;

    private String docnum;

    private String fromunit;

    private String approvalfilename;

    private String approvaldocnum;

    private String approvaltime;

    private String crawlerurl;

    private String isValid;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    private String content;
    
    private Integer labelId;
    
    private Label label;
    
    private CrawlNewsInfoSource source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime == null ? null : releasetime.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype == null ? null : newstype.trim();
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments == null ? null : attachments.trim();
    }

    public String getViewcount() {
        return viewcount;
    }

    public void setViewcount(String viewcount) {
        this.viewcount = viewcount;
    }

    public String getNewsoriginal() {
        return newsoriginal;
    }

    public void setNewsoriginal(String newsoriginal) {
        this.newsoriginal = newsoriginal == null ? null : newsoriginal.trim();
    }

    public String getCrawleroriginal() {
        return crawleroriginal;
    }

    public void setCrawleroriginal(String crawleroriginal) {
        this.crawleroriginal = crawleroriginal == null ? null : crawleroriginal.trim();
    }

    public String getCrawlertime() {
        return crawlertime;
    }

    public void setCrawlertime(String crawlertime) {
        this.crawlertime = crawlertime == null ? null : crawlertime.trim();
    }

    public String getIndexnum() {
        return indexnum;
    }

    public void setIndexnum(String indexnum) {
        this.indexnum = indexnum == null ? null : indexnum.trim();
    }

    public String getThemetype() {
        return themetype;
    }

    public void setThemetype(String themetype) {
        this.themetype = themetype == null ? null : themetype.trim();
    }

    public String getPublishorgan() {
        return publishorgan;
    }

    public void setPublishorgan(String publishorgan) {
        this.publishorgan = publishorgan == null ? null : publishorgan.trim();
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getThemeword() {
        return themeword;
    }

    public void setThemeword(String themeword) {
        this.themeword = themeword == null ? null : themeword.trim();
    }

    public String getDocnum() {
        return docnum;
    }

    public void setDocnum(String docnum) {
        this.docnum = docnum == null ? null : docnum.trim();
    }

    public String getFromunit() {
        return fromunit;
    }

    public void setFromunit(String fromunit) {
        this.fromunit = fromunit == null ? null : fromunit.trim();
    }

    public String getApprovalfilename() {
        return approvalfilename;
    }

    public void setApprovalfilename(String approvalfilename) {
        this.approvalfilename = approvalfilename == null ? null : approvalfilename.trim();
    }

    public String getApprovaldocnum() {
        return approvaldocnum;
    }

    public void setApprovaldocnum(String approvaldocnum) {
        this.approvaldocnum = approvaldocnum == null ? null : approvaldocnum.trim();
    }

    public String getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(String approvaltime) {
        this.approvaltime = approvaltime == null ? null : approvaltime.trim();
    }

    public String getCrawlerurl() {
        return crawlerurl;
    }

    public void setCrawlerurl(String crawlerurl) {
        this.crawlerurl = crawlerurl == null ? null : crawlerurl.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = resv1 == null ? null : resv1.trim();
    }

    public String getResv2() {
        return resv2;
    }

    public void setResv2(String resv2) {
        this.resv2 = resv2 == null ? null : resv2.trim();
    }

    public String getResv3() {
        return resv3;
    }

    public void setResv3(String resv3) {
        this.resv3 = resv3 == null ? null : resv3.trim();
    }

    public String getResv4() {
        return resv4;
    }

    public void setResv4(String resv4) {
        this.resv4 = resv4 == null ? null : resv4.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	/**
	 * @return the labelId
	 */
	public Integer getLabelId() {
		return labelId;
	}

	/**
	 * @param labelId the labelId to set
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public CrawlNewsInfoSource getSource() {
		return source;
	}

	public void setSource(CrawlNewsInfoSource source) {
		this.source = source;
	}
    
    
}