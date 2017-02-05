package cn.com.shukaiken.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class InfoBanner implements Serializable {
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = -8732593649334499463L;

	private Integer banId;

    private Integer infoId;

    private Integer contentId;

    private String url;

    private String banName;

    private String banType;

    private BigDecimal banSize;

    private String isHeader;//如果isHeader为0,那么在首页展示,如果有多个，那么按照时间更新的时间倒序排列,取前面的几个

    private Integer order;

    private String isShow;//存放的LabelId,表示展示的模块
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String isValid;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    public Integer getBanId() {
        return banId;
    }

    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = ValidateUtils.isEmpty(url) ? null : url.trim();
    }

    public String getBanName() {
        return banName;
    }

    public void setBanName(String banName) {
        this.banName = ValidateUtils.isEmpty(banName) ? null : banName.trim();
    }

    public String getBanType() {
        return banType;
    }

    public void setBanType(String banType) {
        this.banType = ValidateUtils.isEmpty(banType) ? null : banType.trim();
    }

    public BigDecimal getBanSize() {
        return banSize;
    }

    public void setBanSize(BigDecimal banSize) {
        this.banSize = banSize;
    }

    public String getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(String isHeader) {
        this.isHeader = ValidateUtils.isEmpty(isHeader) ? null : isHeader.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = ValidateUtils.isEmpty(isShow) ? null : isShow.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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