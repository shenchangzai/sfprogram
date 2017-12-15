package com.xu.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xu.common.dao.DemoDao;
import com.xu.common.dao.TeamInfoDao;
import com.xu.common.model.Demo;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.DemoService;
import com.xu.common.service.TeamInfoService;

@Service
public class TeamInfoServiceImpl extends AbstractCRUDBaseService<String, Demo, TeamInfoDao> implements TeamInfoService {

//	@Override
//	public Demo getDemo() {
//		Demo d = new Demo();
//		d.setId("123");
//		d.setValue("456");
//		return d;
//	}
	
//	public List<Demo> getDemo(String key) {
//		return dao.getDemo(key);
//	}
	public Map<String,Object> getTeamInfo(String teamId){
		dao
	}

}
