package com.xu.common.model;

public class Anybus implements BaseModel<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436881208070091162L;
	
	private String key;
	private String name;
	private int age;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
