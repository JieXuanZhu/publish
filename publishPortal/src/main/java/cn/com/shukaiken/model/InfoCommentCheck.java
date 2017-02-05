package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class InfoCommentCheck implements Serializable {
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = 2325522102552684411L;

	private Integer checkId;

    private Integer commentId;

    private Integer infoId;

    private String opinion;

    private String isAgree;

    private String stage;

    private Integer userId;

    private String user;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    private String isValid;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = ValidateUtils.isEmpty(opinion) ? null : opinion.trim();
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = ValidateUtils.isEmpty(isAgree) ? null : isAgree.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = ValidateUtils.isEmpty(stage) ? null : stage.trim();
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

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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