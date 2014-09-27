package com.lh.appasync.model.po;

import java.sql.Timestamp;

public class PlayerPhoto implements java.io.Serializable {

	private static final long serialVersionUID = -5955286597093704739L;
	
	private String uid;
	private String createdBy;
	private Timestamp createdDate;
	private String lastModifiedBy;
	private Timestamp lastModifiedDate;
	private String deletedBy;
	private Timestamp deletedDate;
	private Short deletedFlag;
	private String photoName;
	private String photoAlbumId;
	private String photoPath;
	private Integer auditStatus;
	private String remarks;
	private Integer commentCount;
	private Integer shareCount;
	private Integer browseCount;
	private Integer isTop;
	private Integer giftCount;
	private Integer praiseCount;
	private Integer isHeadImg;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoAlbumId() {
		return photoAlbumId;
	}
	public void setPhotoAlbumId(String photoAlbumId) {
		this.photoAlbumId = photoAlbumId;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getShareCount() {
		return shareCount;
	}
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}
	public Integer getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
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
	public Integer getIsHeadImg() {
		return isHeadImg;
	}
	public void setIsHeadImg(Integer isHeadImg) {
		this.isHeadImg = isHeadImg;
	}

	
}