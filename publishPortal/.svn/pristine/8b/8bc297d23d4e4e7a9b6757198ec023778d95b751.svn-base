package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class InfoView implements Serializable {
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = 8512473856316880774L;

	private Integer viewId;

    private Integer infoId;

    private Integer userId;

    private String user;

    private String ip;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date viewTime;

    private String isComment;

    private String isForward;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = ValidateUtils.isEmpty(user) ? null : user.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ValidateUtils.isEmpty(ip) ? null : ip.trim();
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = ValidateUtils.isEmpty(isComment) ? null : isComment.trim();
    }

    public String getIsForward() {
        return isForward;
    }

    public void setIsForward(String isForward) {
        this.isForward = ValidateUtils.isEmpty(isForward) ? null : isForward.trim();
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