package com.xu.common.model;

public class TeamUser implements BaseModel<String>{

	private static final long serialVersionUID = 1L;

	/** ID*/
	private String id;

	/** 团ID*/
	private String teamId;
	
	/** 用户ID*/
	private String userId;
	
	/** 所在地区*/
	private String userBq;
	
	/** 详细地址*/
	private String userAdd;
	
	/** 寄件人姓名*/
	private String sendUser;
	
	/** 寄件人电话*/
	private String sendPh;
	
	/** 寄件量*/
	private Long sendNum;
	
	/** 平均重量*/
	private double sendWeight;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserBq() {
		return userBq;
	}

	public void setUserBq(String userBq) {
		this.userBq = userBq;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public String getSendUser() {
		return sendUser;
	}

	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}

	public String getSendPh() {
		return sendPh;
	}

	public void setSendPh(String sendPh) {
		this.sendPh = sendPh;
	}

	public Long getSendNum() {
		return sendNum;
	}

	public void setSendNum(Long sendNum) {
		this.sendNum = sendNum;
	}

	public double getSendWeight() {
		return sendWeight;
	}

	public void setSendWeight(double sendWeight) {
		this.sendWeight = sendWeight;
	}
}
