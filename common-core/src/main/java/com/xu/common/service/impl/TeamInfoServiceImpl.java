package com.xu.common.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.xu.common.dao.ProMarketBaseDao;
import com.xu.common.dao.TtTeamDao;
import com.xu.common.exception.ParameterErrorException;
import com.xu.common.model.ProMarketBase;
import com.xu.common.model.TtTeam;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.TeamInfoService;

@Service
public class TeamInfoServiceImpl extends AbstractCRUDBaseService<String, TtTeam, TtTeamDao> implements TeamInfoService {
	@Resource
	ProMarketBaseDao proMarketBaseDao;    
	@Resource
	TtTeamDao ttTeamDao;
	public Map<String,Object> getTeamInfo(String teamId) throws Exception{
		TtTeam  ttTeam=ttTeamDao.getTtTeam(teamId);
		if(null==ttTeam){
			throw new ParameterErrorException("根据集货团ID查找不到对应的集货信息,请查证后再试!");
		}
		ProMarketBase proMarketBase=proMarketBaseDao.getProMarketBase(ttTeam.getMktId());
		if(null==proMarketBase){
			throw new ParameterErrorException("根据专业市场ID查找不到对应的市场信息,请查证后再试!");
		} 
		Map<String, Object> map=beanToMap(ttTeam, null);
		beanToMap(proMarketBase, map);
		return map;
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
	            map.put(key+"", beanMap.get(key));  
	        }             
	    }  
	    return map;  
	} 
	@Override
	public void insertTeam(TtTeam ttTeam) throws Exception {
		ttTeamDao.insert(ttTeam);
	}
}
