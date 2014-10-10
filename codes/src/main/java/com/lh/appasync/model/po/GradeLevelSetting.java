package com.lh.appasync.model.po;

import java.util.Date;


public class GradeLevelSetting implements java.io.Serializable {

	private static final long serialVersionUID = -1960734563715428045L;
	
	private String uid;
	private String name;
	private Integer type;
	private Integer exp;
	private Integer dayMax;
	private Integer requirement;
	private Date createdDate;
	private String remark;

	public GradeLevelSetting() {
	}


	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getExp() {
		return this.exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getDayMax() {
		return this.dayMax;
	}

	public void setDayMax(Integer dayMax) {
		this.dayMax = dayMax;
	}

	public Integer getRequirement() {
		return this.requirement;
	}

	public void setRequirement(Integer requirement) {
		this.requirement = requirement;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}