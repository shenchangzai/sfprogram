package com.xu.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xu.common.dao.DemoDao;
import com.xu.common.model.Demo;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.DemoService;

@Service
public class DemoServiceImpl extends AbstractCRUDBaseService<String, Demo, DemoDao> implements DemoService {

	@Override
	public Demo getDemo() {
		Demo d = new Demo();
		d.setId("123");
		d.setValue("456");
		return d;
	}
	
	public List<Demo> getDemo(String key) {
		return dao.getDemo(key);
	}
	

}
