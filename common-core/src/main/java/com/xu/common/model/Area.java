package com.xu.common.model;

public class Area implements BaseModel<String>{

	private static final long serialVersionUID = 1L;

	private String id;
	
	/** 地区Id*/
	private String areaId;

	/** 地区名称*/
	private String areaName;
	
	/** 城市ID*/
	private String cityId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
