package com.xu.common.model;

public class City implements BaseModel<String>{

	private static final long serialVersionUID = 1L;

	private String id;
	
	/** 城市ID*/
	private String cityId;
	
	/** 城市名称*/
	private String cityName;

	/** 省份/直辖市/自治区Id*/
	private String provinceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
}
