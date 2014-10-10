package com.lh.appasync.model.po;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Player entity. @author MyEclipse Persistence Tools
 */

public class Player implements java.io.Serializable {

	private static final long serialVersionUID = -4808501620985642419L;

	private String uid;
	private String userId;
	private String nickName;
	private String signature;
	private Timestamp lastLoginTime;
	private String headImgPath;
	private String originalImage;
	private Integer songer;
	private String songerGrade;
	private String songerLogo;
	private Integer nextSongerGrade;
	private Integer wealth;
	private String wealthGrade;
	private String wealthLogo;
	private Integer nextWealthGrade;
	private Integer honor;
	private String honorGrade;
	private String honorLogo;
	private Double experience;
	private Double songerPopular;
	private Timestamp lastSysmsgTime;
	private Timestamp createdDate;
	private String logonDevice;
	private String deletedBy;
	private Timestamp deletedDate;
	private Short deletedFlag;
	private Short useFlag;
	private Short fromType;
	private Short gender;
	private Date bornDate;
	private String city;
	private Double latitude;
	private Double longitude;
	private Double gold;
	private Double goldBean;
	private Integer vipGrade;
	private String vipLogo;
	private String familyName;
	private Double giftMoney;
	private Integer giftCount;
	private Integer praiseCount;
	private Integer compositionCount;
	private Integer publicCompositonCount;
	private Integer focusCount;
	private Integer funsCount;
	private Integer isSinger;//1:认证歌手0:不是
	private Integer isTop;
	private String certification;
	private String guid;
	private Double SongerGradeTotal;//歌手等级的等级共需要
	private Double WealthGradeTotal;//财富等级的等级共需要
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public String getOriginalImage() {
		return originalImage;
	}
	public void setOriginalImage(String originalImage) {
		this.originalImage = originalImage;
	}
	public Integer getSonger() {
		return songer;
	}
	public void setSonger(Integer songer) {
		this.songer = songer;
	}
	public String getSongerGrade() {
		return songerGrade;
	}
	public void setSongerGrade(String songerGrade) {
		this.songerGrade = songerGrade;
	}
	public String getSongerLogo() {
		return songerLogo;
	}
	public void setSongerLogo(String songerLogo) {
		this.songerLogo = songerLogo;
	}
	public Integer getNextSongerGrade() {
		return nextSongerGrade;
	}
	public void setNextSongerGrade(Integer nextSongerGrade) {
		this.nextSongerGrade = nextSongerGrade;
	}
	public Integer getWealth() {
		return wealth;
	}
	public void setWealth(Integer wealth) {
		this.wealth = wealth;
	}
	public String getWealthGrade() {
		return wealthGrade;
	}
	public void setWealthGrade(String wealthGrade) {
		this.wealthGrade = wealthGrade;
	}
	public String getWealthLogo() {
		return wealthLogo;
	}
	public void setWealthLogo(String wealthLogo) {
		this.wealthLogo = wealthLogo;
	}
	public Integer getNextWealthGrade() {
		return nextWealthGrade;
	}
	public void setNextWealthGrade(Integer nextWealthGrade) {
		this.nextWealthGrade = nextWealthGrade;
	}
	public Integer getHonor() {
		return honor;
	}
	public void setHonor(Integer honor) {
		this.honor = honor;
	}
	public String getHonorGrade() {
		return honorGrade;
	}
	public void setHonorGrade(String honorGrade) {
		this.honorGrade = honorGrade;
	}
	public String getHonorLogo() {
		return honorLogo;
	}
	public void setHonorLogo(String honorLogo) {
		this.honorLogo = honorLogo;
	}
	public Double getExperience() {
		return experience;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}
	public Double getSongerPopular() {
		return songerPopular;
	}
	public void setSongerPopular(Double songerPopular) {
		this.songerPopular = songerPopular;
	}
	public Timestamp getLastSysmsgTime() {
		return lastSysmsgTime;
	}
	public void setLastSysmsgTime(Timestamp lastSysmsgTime) {
		this.lastSysmsgTime = lastSysmsgTime;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getLogonDevice() {
		return logonDevice;
	}
	public void setLogonDevice(String logonDevice) {
		this.logonDevice = logonDevice;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public Timestamp getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}
	public Short getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(Short deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public Short getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(Short useFlag) {
		this.useFlag = useFlag;
	}
	public Short getFromType() {
		return fromType;
	}
	public void setFromType(Short fromType) {
		this.fromType = fromType;
	}
	public Short getGender() {
		return gender;
	}
	public void setGender(Short gender) {
		this.gender = gender;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getGold() {
		return gold;
	}
	public void setGold(Double gold) {
		this.gold = gold;
	}
	public Double getGoldBean() {
		return goldBean;
	}
	public void setGoldBean(Double goldBean) {
		this.goldBean = goldBean;
	}
	public Integer getVipGrade() {
		return vipGrade;
	}
	public void setVipGrade(Integer vipGrade) {
		this.vipGrade = vipGrade;
	}
	public String getVipLogo() {
		return vipLogo;
	}
	public void setVipLogo(String vipLogo) {
		this.vipLogo = vipLogo;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Double getGiftMoney() {
		return giftMoney;
	}
	public void setGiftMoney(Double giftMoney) {
		this.giftMoney = giftMoney;
	}
	public Integer getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(Integer giftCount) {
		this.giftCount = giftCount;
	}
	public Integer getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}
	public Integer getCompositionCount() {
		return compositionCount;
	}
	public void setCompositionCount(Integer compositionCount) {
		this.compositionCount = compositionCount;
	}
	public Integer getPublicCompositonCount() {
		return publicCompositonCount;
	}
	public void setPublicCompositonCount(Integer publicCompositonCount) {
		this.publicCompositonCount = publicCompositonCount;
	}
	public Integer getFocusCount() {
		return focusCount;
	}
	public void setFocusCount(Integer focusCount) {
		this.focusCount = focusCount;
	}
	public Integer getFunsCount() {
		return funsCount;
	}
	public void setFunsCount(Integer funsCount) {
		this.funsCount = funsCount;
	}
	public Integer getIsSinger() {
		return isSinger;
	}
	public void setIsSinger(Integer isSinger) {
		this.isSinger = isSinger;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Double getSongerGradeTotal() {
		return SongerGradeTotal;
	}
	public void setSongerGradeTotal(Double songerGradeTotal) {
		SongerGradeTotal = songerGradeTotal;
	}
	public Double getWealthGradeTotal() {
		return WealthGradeTotal;
	}
	public void setWealthGradeTotal(Double wealthGradeTotal) {
		WealthGradeTotal = wealthGradeTotal;
	}
	
	
}