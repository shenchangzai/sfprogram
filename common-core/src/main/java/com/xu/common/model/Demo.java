package com.xu.common.model;

public class Demo implements BaseModel<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String id;
	
	private String value;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
