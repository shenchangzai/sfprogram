package com.xu.common.service;

import java.util.List;

import com.xu.common.model.Demo;

public interface DemoService extends BaseCRUDService<String, Demo>{

	public Demo getDemo();
	
	public List<Demo> getDemo(String key);
}
