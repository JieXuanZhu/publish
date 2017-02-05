package cn.com.shukaiken.model;

import java.io.Serializable;
import java.util.Date;

import cn.com.shukaiken.util.ValidateUtils;

public class Log implements Serializable{
   
	private static final long serialVersionUID = 9097462874545664940L;

	private Integer id;//主键

    private Integer custId;//操作员Id

    private String name;//操作员姓名

    private Integer targetId;//被操作对象ID

    private String targetName;//被操作对象姓名

    private String behavior;//操作记录

    private Date createDate;//操作时间

    private String category;//日志分类，如客户分类等

    private String operateType;//操作类型，新增，更新，删除等

    private String logsType;//日志类型，正常还是错误类型等
    
    private String isValid;//0-有效,1-无效 
    
    private String logFrom;//日志是Controller的还是service的

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = ValidateUtils.isEmpty(name)  ? null : name.trim();
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = ValidateUtils.isEmpty(targetName)? null : targetName.trim();
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = ValidateUtils.isEmpty(behavior) ? null : behavior.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = ValidateUtils.isEmpty(category) ? null : category.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = ValidateUtils.isEmpty(operateType) ? null : operateType.trim();
    }

    public String getLogsType() {
        return logsType;
    }

    public void setLogsType(String logsType) {
        this.logsType = ValidateUtils.isEmpty(logsType) ? null : logsType.trim();
    }

	/**
	 * @return the isValid
	 */
	public String getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(String isValid) {
		this.isValid = ValidateUtils.isEmpty(isValid) ? null : isValid.trim();
	}

	/**
	 * @return the logFrom
	 */
	public String getLogFrom() {
		return logFrom;
	}

	/**
	 * @param logFrom the logFrom to set
	 */
	public void setLogFrom(String logFrom) {
		this.logFrom = ValidateUtils.isEmpty(logFrom) ? null : logFrom.trim();
	}
    
}