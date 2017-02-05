package cn.com.shukaiken.model;

import java.util.Date;

public class Data {
    private Integer id;

    private Integer category_id;
    
    private String category_name;

    private String title;

    private String author;

    private String cover;

    private Date capture_date;

    private String publisher;

    private String sub_title;

    private String original_titile;

    private String translator;

    private Date publish_year;

    private Integer page_size;

    private Double price;

    private String bind;

    private String book_category;

    private String isbn;

    private String content_brief;

    private String author_brief;

    private String score_number;

    private String score_detail;

    private String where_buy;

    private String douban_label;

    private Integer reading_number;

    private Integer readed_numer;

    private Integer want_reading_number;

    private String subordinate_series;

    private Integer view_count;

    private Integer dianzan_count;

    private Integer status;

    private String vedio_image_url;

    private Integer is_valid;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Date getCapture_date() {
        return capture_date;
    }

    public void setCapture_date(Date capture_date) {
        this.capture_date = capture_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title == null ? null : sub_title.trim();
    }

    public String getOriginal_titile() {
        return original_titile;
    }

    public void setOriginal_titile(String original_titile) {
        this.original_titile = original_titile == null ? null : original_titile.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public Date getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(Date publish_year) {
        this.publish_year = publish_year;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind == null ? null : bind.trim();
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category == null ? null : book_category.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getContent_brief() {
        return content_brief;
    }

    public void setContent_brief(String content_brief) {
        this.content_brief = content_brief == null ? null : content_brief.trim();
    }

    public String getAuthor_brief() {
        return author_brief;
    }

    public void setAuthor_brief(String author_brief) {
        this.author_brief = author_brief == null ? null : author_brief.trim();
    }

    public String getScore_number() {
        return score_number;
    }

    public void setScore_number(String score_number) {
        this.score_number = score_number == null ? null : score_number.trim();
    }

    public String getScore_detail() {
        return score_detail;
    }

    public void setScore_detail(String score_detail) {
        this.score_detail = score_detail == null ? null : score_detail.trim();
    }

    public String getWhere_buy() {
        return where_buy;
    }

    public void setWhere_buy(String where_buy) {
        this.where_buy = where_buy == null ? null : where_buy.trim();
    }

    public String getDouban_label() {
        return douban_label;
    }

    public void setDouban_label(String douban_label) {
        this.douban_label = douban_label == null ? null : douban_label.trim();
    }

    public Integer getReading_number() {
        return reading_number;
    }

    public void setReading_number(Integer reading_number) {
        this.reading_number = reading_number;
    }

    public Integer getReaded_numer() {
        return readed_numer;
    }

    public void setReaded_numer(Integer readed_numer) {
        this.readed_numer = readed_numer;
    }

    public Integer getWant_reading_number() {
        return want_reading_number;
    }

    public void setWant_reading_number(Integer want_reading_number) {
        this.want_reading_number = want_reading_number;
    }

    public String getSubordinate_series() {
        return subordinate_series;
    }

    public void setSubordinate_series(String subordinate_series) {
        this.subordinate_series = subordinate_series == null ? null : subordinate_series.trim();
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getDianzan_count() {
        return dianzan_count;
    }

    public void setDianzan_count(Integer dianzan_count) {
        this.dianzan_count = dianzan_count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVedio_image_url() {
        return vedio_image_url;
    }

    public void setVedio_image_url(String vedio_image_url) {
        this.vedio_image_url = vedio_image_url == null ? null : vedio_image_url.trim();
    }

    public Integer getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}