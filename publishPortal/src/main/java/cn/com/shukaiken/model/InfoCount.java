package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class InfoCount implements Serializable {
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = -3247282630931128770L;

	private Integer countId;

    private Integer infoId;

    private Integer views;

    private Integer viewsMonth;

    private Integer viewsWeek;

    private Integer viewsDay;

    private Integer comments;

    private Integer commentsMonth;

    private Integer commentsWeek;

    private Integer commentsDay;

    private Integer downloads;

    private Integer downloadsMonth;

    private Integer downloadsWeek;

    private Integer downloadsDay;

    private Integer ups;

    private Integer upsMonth;

    private Integer upsWeek;

    private Integer upsDay;

    private Integer downs;

    private Integer downsMonth;

    private Integer downsWeek;

    private Integer downsDay;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date countDate;

    private String isValid;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getViewsMonth() {
        return viewsMonth;
    }

    public void setViewsMonth(Integer viewsMonth) {
        this.viewsMonth = viewsMonth;
    }

    public Integer getViewsWeek() {
        return viewsWeek;
    }

    public void setViewsWeek(Integer viewsWeek) {
        this.viewsWeek = viewsWeek;
    }

    public Integer getViewsDay() {
        return viewsDay;
    }

    public void setViewsDay(Integer viewsDay) {
        this.viewsDay = viewsDay;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getCommentsMonth() {
        return commentsMonth;
    }

    public void setCommentsMonth(Integer commentsMonth) {
        this.commentsMonth = commentsMonth;
    }

    public Integer getCommentsWeek() {
        return commentsWeek;
    }

    public void setCommentsWeek(Integer commentsWeek) {
        this.commentsWeek = commentsWeek;
    }

    public Integer getCommentsDay() {
        return commentsDay;
    }

    public void setCommentsDay(Integer commentsDay) {
        this.commentsDay = commentsDay;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getDownloadsMonth() {
        return downloadsMonth;
    }

    public void setDownloadsMonth(Integer downloadsMonth) {
        this.downloadsMonth = downloadsMonth;
    }

    public Integer getDownloadsWeek() {
        return downloadsWeek;
    }

    public void setDownloadsWeek(Integer downloadsWeek) {
        this.downloadsWeek = downloadsWeek;
    }

    public Integer getDownloadsDay() {
        return downloadsDay;
    }

    public void setDownloadsDay(Integer downloadsDay) {
        this.downloadsDay = downloadsDay;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getUpsMonth() {
        return upsMonth;
    }

    public void setUpsMonth(Integer upsMonth) {
        this.upsMonth = upsMonth;
    }

    public Integer getUpsWeek() {
        return upsWeek;
    }

    public void setUpsWeek(Integer upsWeek) {
        this.upsWeek = upsWeek;
    }

    public Integer getUpsDay() {
        return upsDay;
    }

    public void setUpsDay(Integer upsDay) {
        this.upsDay = upsDay;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Integer getDownsMonth() {
        return downsMonth;
    }

    public void setDownsMonth(Integer downsMonth) {
        this.downsMonth = downsMonth;
    }

    public Integer getDownsWeek() {
        return downsWeek;
    }

    public void setDownsWeek(Integer downsWeek) {
        this.downsWeek = downsWeek;
    }

    public Integer getDownsDay() {
        return downsDay;
    }

    public void setDownsDay(Integer downsDay) {
        this.downsDay = downsDay;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = ValidateUtils.isEmpty(isValid) ? null : isValid.trim();
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = ValidateUtils.isEmpty(resv1) ? null : resv1.trim();
    }

    public String getResv2() {
        return resv2;
    }

    public void setResv2(String resv2) {
        this.resv2 = ValidateUtils.isEmpty(resv2) ? null : resv2.trim();
    }

    public String getResv3() {
        return resv3;
    }

    public void setResv3(String resv3) {
        this.resv3 = ValidateUtils.isEmpty(resv3) ? null : resv3.trim();
    }

    public String getResv4() {
        return resv4;
    }

    public void setResv4(String resv4) {
        this.resv4 = ValidateUtils.isEmpty(resv4) ? null : resv4.trim();
    }
}