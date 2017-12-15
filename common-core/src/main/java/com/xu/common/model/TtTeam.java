package com.xu.common.model;

import java.util.Date;

import org.apache.ibatis.type.JdbcType;

/**
 * 集货团基本信息表
 * @author 194129
 *
 */
public class TtTeam implements BaseModel<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 集货团ID
	 */
	private String teamId;
	/**
	 * 专业市场ID
	 */
	private String mktId;
	/**
	 * 集货团名称
	 */
	private String teamName;
	/**
	 * 状态  1进行中，2开团完成，3开团失败
	 */
	private String status;
	/**
	 *参团截止时间
	 */
	private Long endTime;
	/**
	 * 已参团人数
	 */
	private Integer ctNum;
	/**
	 * 创建时间
	 */
	private Date crtTime;
	
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getMktId() {
		return mktId;
	}
	public void setMktId(String mktId) {
		this.mktId = mktId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Integer getCtNum() {
		return ctNum;
	}
	public void setCtNum(Integer ctNum) {
		this.ctNum = ctNum;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	
	
	@Override
	public String toString() {
		return "TtTeam [teamId=" + teamId + ", mktId=" + mktId + ", teamName=" + teamName + ", status=" + status
				+ ", endTime=" + endTime + ", ctNum=" + ctNum + ", crtTime=" + crtTime + "]";
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
}
