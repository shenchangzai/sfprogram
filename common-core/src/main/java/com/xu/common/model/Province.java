package com.xu.common.model;

public class Province implements BaseModel<String>{

	private static final long serialVersionUID = 1L;

	private String id;
	
	/** 省份/直辖市/自治区Id*/
	private String provinceId;
	
	/** 省份/直辖市/自治区*/
	private String provinceName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceid(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}	
}
