package com.lh.appasync.model.po;

import java.sql.Timestamp;

public class Composition implements java.io.Serializable {
	private static final long serialVersionUID = -5550348290192648071L;
	
	private String uid;
	private String songId;
	private String playerNickName;
	private String playerId;
	private String songName;
	private Timestamp uploadDate;
	private Integer playedTimes;
	private Integer sharedTimes;
	private Integer listenTimes;
	private Integer likeCount;
	private Integer collected;
	private Integer rank;
	private Double score;
	private String path;
	private String audioPath;
	private String mediaType;
	private Short online;
	private String remark;
    private String deletedBy;
    private Timestamp deletedDate;
    private Byte deletedFlag;
    private Timestamp expirationTime;
	private Integer auditStatus;
	private Integer rankCommentCount;
	private Integer commentCount;
    private String compositionTags;
    private Integer isShare;
    private Integer isOriginal;
    private String deviceDetail;
    private Integer giftCount;
    private Integer praiseCount;
    private Integer isCar;
    private String city;
    private Integer isTop;
    private String frontCover;
    private String activityTags;
    private Integer transcoderStatus;
    
    
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Integer getPlayedTimes() {
		return playedTimes;
	}
	public void setPlayedTimes(Integer playedTimes) {
		this.playedTimes = playedTimes;
	}
	public Integer getSharedTimes() {
		return sharedTimes;
	}
	public void setSharedTimes(Integer sharedTimes) {
		this.sharedTimes = sharedTimes;
	}
	public Integer getListenTimes() {
		return listenTimes;
	}
	public void setListenTimes(Integer listenTimes) {
		this.listenTimes = listenTimes;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Integer getCollected() {
		return collected;
	}
	public void setCollected(Integer collected) {
		this.collected = collected;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public Short getOnline() {
		return online;
	}
	public void setOnline(Short online) {
		this.online = online;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Byte getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(Byte deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public Timestamp getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Timestamp expirationTime) {
		this.expirationTime = expirationTime;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getRankCommentCount() {
		return rankCommentCount;
	}
	public void setRankCommentCount(Integer rankCommentCount) {
		this.rankCommentCount = rankCommentCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public String getCompositionTags() {
		return compositionTags;
	}
	public void setCompositionTags(String compositionTags) {
		this.compositionTags = compositionTags;
	}
	public Integer getIsShare() {
		return isShare;
	}
	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}
	public Integer getIsOriginal() {
		return isOriginal;
	}
	public void setIsOriginal(Integer isOriginal) {
		this.isOriginal = isOriginal;
	}
	public String getDeviceDetail() {
		return deviceDetail;
	}
	public void setDeviceDetail(String deviceDetail) {
		this.deviceDetail = deviceDetail;
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
	public Integer getIsCar() {
		return isCar;
	}
	public void setIsCar(Integer isCar) {
		this.isCar = isCar;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public String getFrontCover() {
		return frontCover;
	}
	public void setFrontCover(String frontCover) {
		this.frontCover = frontCover;
	}
	public String getActivityTags() {
		return activityTags;
	}
	public void setActivityTags(String activityTags) {
		this.activityTags = activityTags;
	}
	public Integer getTranscoderStatus() {
		return transcoderStatus;
	}
	public void setTranscoderStatus(Integer transcoderStatus) {
		this.transcoderStatus = transcoderStatus;
	}
	public String getPlayerNickName() {
		return playerNickName;
	}
	public void setPlayerNickName(String playerNickName) {
		this.playerNickName = playerNickName;
	}
	
}