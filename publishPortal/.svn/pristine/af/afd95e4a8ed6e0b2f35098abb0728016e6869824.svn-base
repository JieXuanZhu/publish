package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.shukaiken.util.ValidateUtils;

public class Info implements Serializable{
    /**
	 * @Fields serialVersionUID : <p> TODO</p>
	 */
	private static final long serialVersionUID = 8780031434200702553L;

	private Integer infoId;

    private Integer authorId;

    private String authorType;

    private String authorName;

    private Integer tagId;//类别的Id labelId

    private String hasBanner;

    private String hasImage;

    private String hasVideo;

    private String hasFlash;

    private String searchWord;

    private String searchTag;

    private String origin;

    private String originUrl;

    private String originName;

    private String stage;

    private String status;
    
    private String statusStr;

    private String isValid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rollbackTime;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;
    
    private int imageSize;//传的图片的张数
    
    private List<InfoBanner> infoBanners;
    
    private InfoContent infoContent;
    
    private List<InfoCheck> infoChecks;
    
    private InfoComment infoComment;
    
    private InfoView infoView;
    
    private List<Tag> infoTags;//对应标签
    
    private List<InfoSearchWord> searchWords;
    
    private String searchWordStr;
    
	private Map<String,String> statusMap;
	
	private Label infoLabel;
	
	private String infoTagNames;
	
	private String labelName;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = ValidateUtils.isEmpty(authorType) ? null : authorType.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = ValidateUtils.isEmpty(authorName ) ? null : authorName.trim();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getHasBanner() {
        return hasBanner;
    }

    public void setHasBanner(String hasBanner) {
        this.hasBanner = ValidateUtils.isEmpty(hasBanner ) ? null : hasBanner.trim();
    }

    public String getHasImage() {
        return hasImage;
    }

    public void setHasImage(String hasImage) {
        this.hasImage = ValidateUtils.isEmpty(hasImage ) ? null : hasImage.trim();
    }

    public String getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(String hasVideo) {
        this.hasVideo = ValidateUtils.isEmpty(hasVideo ) ? null : hasVideo.trim();
    }

    public String getHasFlash() {
        return hasFlash;
    }

    public void setHasFlash(String hasFlash) {
        this.hasFlash = ValidateUtils.isEmpty(hasFlash ) ? null : hasFlash.trim();
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = ValidateUtils.isEmpty(searchWord ) ? null : searchWord.trim();
    }

    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = ValidateUtils.isEmpty(searchTag ) ? null : searchTag.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = ValidateUtils.isEmpty(origin ) ? null : origin.trim();
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = ValidateUtils.isEmpty(originUrl) ? null : originUrl.trim();
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = ValidateUtils.isEmpty(originName) ? null : originName.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = ValidateUtils.isEmpty(stage) ? null : stage.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = ValidateUtils.isEmpty(status) ? null : status.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = ValidateUtils.isEmpty(isValid) ? null : isValid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getRollbackTime() {
        return rollbackTime;
    }

    public void setRollbackTime(Date rollbackTime) {
        this.rollbackTime = rollbackTime;
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
        this.resv2 = ValidateUtils.isEmpty(resv2 ) ? null : resv2.trim();
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
	 * @return the infoBanners
	 */
	public List<InfoBanner> getInfoBanners() {
		return infoBanners;
	}

	/**
	 * @param infoBanners the infoBanners to set
	 */
	public void setInfoBanners(List<InfoBanner> infoBanners) {
		this.infoBanners = infoBanners;
	}

	/**
	 * @return the infoContent
	 */
	public InfoContent getInfoContent() {
		return infoContent;
	}

	/**
	 * @param infoContent the infoContent to set
	 */
	public void setInfoContent(InfoContent infoContent) {
		this.infoContent = infoContent;
	}

	
	/**
	 * @return the infoChecks
	 */
	public List<InfoCheck> getInfoChecks() {
		return infoChecks;
	}

	/**
	 * @param infoChecks the infoChecks to set
	 */
	public void setInfoChecks(List<InfoCheck> infoChecks) {
		this.infoChecks = infoChecks;
	}

	/**
	 * @return the infoComment
	 */
	public InfoComment getInfoComment() {
		return infoComment;
	}

	/**
	 * @param infoComment the infoComment to set
	 */
	public void setInfoComment(InfoComment infoComment) {
		this.infoComment = infoComment;
	}

	/**
	 * @return the infoView
	 */
	public InfoView getInfoView() {
		return infoView;
	}

	/**
	 * @param infoView the infoView to set
	 */
	public void setInfoView(InfoView infoView) {
		this.infoView = infoView;
	}

	/**
	 * @return the imageSize
	 */
	public int getImageSize() {
		return imageSize;
	}

	/**
	 * @param imageSize the imageSize to set
	 */
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}

	/**
	 * @return the statusStr
	 */
	public String getStatusStr() {
		if(!ValidateUtils.isEmpty(status)){
			if("1101-1".equals(status)){
				return "草稿";
			}else if("1101-2".equals(status)){
				return "待确认";
			}else if("1102-1".equals(status)){
				return "待初步审核";
			}else if("1102-2".equals(status)){
				return "初步审核未通过";
			}else if("1102-3".equals(status)){
				return "待复核";
			}else if("1102-4".equals(status)){
				return "复核未通过";
			}else if("1102-5".equals(status)){
				return "审核通过未发布";
			}else if("1103-1".equals(status)){
				return "已发布";
			}else if("1103-2".equals(status)){
				return "发布撤回";
			}else if("1102-6".equals(status)){
				return "资讯已发布";
			}else if("1102-7".equals(status)){
				return "资讯待编辑编排";
			}else if("1102-8".equals(status)){
				return "首页编排完成,待发布审核";
			}
		}
		return statusStr;
	}

	/**
	 * @param statusStr the statusStr to set
	 */
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public List<Tag> getInfoTags() {
		return infoTags;
	}

	public void setInfoTags(List<Tag> infoTags) {
		this.infoTags = infoTags;
	}

	/**
	 * @return the searchWords
	 */
	public List<InfoSearchWord> getSearchWords() {
		return searchWords;
	}

	/**
	 * @param searchWords the searchWords to set
	 */
	public void setSearchWords(List<InfoSearchWord> searchWords) {
		this.searchWords = searchWords;
	}

	/**
	 * @return the searchWordStr
	 */
	public String getSearchWordStr() {
		if(searchWords!=null&&searchWords.size()>0){
			StringBuffer wordStr = new StringBuffer("");
			for(int i=0;i<searchWords.size();i++){
				wordStr.append(searchWords.get(i).getWord()+",");
			}
			return wordStr.substring(0, wordStr.length()-1);
		}
		return searchWordStr;
	}

	/**
	 * @param searchWordStr the searchWordStr to set
	 */
	public void setSearchWordStr(String searchWordStr) {
		this.searchWordStr = searchWordStr;
	}

	/**
	 * @return the statusMap
	 */
	public Map<String, String> getStatusMap() {
		return statusMap;
	}

	/**
	 * @param statusMap the statusMap to set
	 */
	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
	}

	public Label getInfoLabel() {
		return infoLabel;
	}

	public void setInfoLabel(Label infoLabel) {
		this.infoLabel = infoLabel;
	}

	public String getInfoTagNames() {
		return infoTagNames;
	}

	public void setInfoTagNames(String infoTagNames) {
		this.infoTagNames = infoTagNames;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
	
}