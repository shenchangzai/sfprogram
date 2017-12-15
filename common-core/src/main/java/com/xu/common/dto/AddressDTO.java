package com.xu.common.dto;

public class AddressDTO {
	
	private String name;
	
	private String value;
	
	private String parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public AddressDTO(String name, String value,String parent) {
		this.name = name;
		this.value = value;
		this.parent= parent;
	}
	
	public AddressDTO(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
