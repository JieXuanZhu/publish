package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class InfoCheck implements Serializable {
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = -7975492879080944570L;

	private Integer checkId;

    private Integer infoId;

    private Integer userId;

    private String userName;

    private String opinion;

    private String isAgree;

    private String stage;
    
    private String stageStr;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = ValidateUtils.isEmpty(userName) ? null : userName.trim();
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

	/**
	 * @return the stageStr
	 */
	public String getStageStr() {
			if(!ValidateUtils.isEmpty(stage)){
				if("1101-1".equals(stage)){
					return "草稿";
				}else if("1101-2".equals(stage)){
					return "已保存，待确认";
				}else if("1102-1".equals(stage)){
					return "已确认,待初步审核";
				}else if("1102-2".equals(stage)){
					return "初步审核未通过";
				}else if("1102-3".equals(stage)){
					return "待复核";
				}else if("1102-4".equals(stage)){
					return "复核未通过";
				}else if("1102-5".equals(stage)){
					return "审核通过待发布";
				}else if("1103-1".equals(stage)){
					return "已发布";
				}else if("1103-2".equals(stage)){
					return "发布撤回";
				}else if("1102-6".equals(stage)){
					return "资讯已发布";
				}else if("1102-7".equals(stage)){
					return "资讯待编辑编排";
				}else if("1102-8".equals(stage)){
					return "首页编排完成,待发布审核";
				}
			}
		return stageStr;
	}

	/**
	 * @param stageStr the stageStr to set
	 */
	public void setStageStr(String stageStr) {
		this.stageStr = stageStr;
	}
    
}