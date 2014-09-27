package com.lh.appasync.model.po;

import java.sql.Timestamp;


public class PlayerGradeInfo implements java.io.Serializable {

	private static final long serialVersionUID = 179330421303950239L;
	private Integer gradeId;
	private Short gradeType;
	private Integer gradeNum;
	private String gradeName;
	private String gradeLogo;
	private Double gradeRules;
	private Integer honorFocus;
	private Integer honorListen;
	private Integer honorSongerGrade;
	private Integer goodNum;
	private Integer roleId;
	private Timestamp createDate;

	public PlayerGradeInfo() {
	}

	public Integer getGradeId() {
		return gradeId;
	}


	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}


	public Short getGradeType() {
		return gradeType;
	}


	public void setGradeType(Short gradeType) {
		this.gradeType = gradeType;
	}


	public Integer getGradeNum() {
		return gradeNum;
	}


	public void setGradeNum(Integer gradeNum) {
		this.gradeNum = gradeNum;
	}


	public String getGradeName() {
		return gradeName;
	}


	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}


	public String getGradeLogo() {
		return gradeLogo;
	}


	public void setGradeLogo(String gradeLogo) {
		this.gradeLogo = gradeLogo;
	}


	public Double getGradeRules() {
		return gradeRules;
	}


	public void setGradeRules(Double gradeRules) {
		this.gradeRules = gradeRules;
	}


	public Integer getHonorFocus() {
		return honorFocus;
	}


	public void setHonorFocus(Integer honorFocus) {
		this.honorFocus = honorFocus;
	}


	public Integer getHonorListen() {
		return honorListen;
	}


	public void setHonorListen(Integer honorListen) {
		this.honorListen = honorListen;
	}


	public Integer getHonorSongerGrade() {
		return honorSongerGrade;
	}


	public void setHonorSongerGrade(Integer honorSongerGrade) {
		this.honorSongerGrade = honorSongerGrade;
	}


	public Integer getGoodNum() {
		return goodNum;
	}


	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	
	
}