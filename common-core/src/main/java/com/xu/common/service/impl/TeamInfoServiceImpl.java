package com.xu.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
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
		dao.get(teamId);
		return null;
	}

	/* 将对象装换为map 
	 * @param bean 
	 * @return 
	 */  
	private static <T> Map<String, Object> beanToMap(T bean,Map<String,Object> map) {  
		if(null== map){
			map=Maps.newHashMap();
		}
		if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(key+"", beanMap.get(key)==null?"":beanMap.get(key));  
	        }             
	    }  
	    return map;  
	} 
}
