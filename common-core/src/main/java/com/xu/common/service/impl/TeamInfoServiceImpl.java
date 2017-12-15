package com.xu.common.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xu.common.dao.ProMarketBaseDao;
import com.xu.common.dao.TtTeamDao;
import com.xu.common.exception.MlsException;
import com.xu.common.model.ProMarketBase;
import com.xu.common.model.TtTeam;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.TeamInfoService;
import com.xu.common.utility.BeanMapUtil;
import com.xu.common.utility.DateUtil;

@Service
public class TeamInfoServiceImpl extends AbstractCRUDBaseService<String, TtTeam, TtTeamDao> implements TeamInfoService {
	@Resource
	ProMarketBaseDao proMarketBaseDao;    
	public Map<String,Object> getTeamInfo(String teamId) throws MlsException{
		String endTimeKey="endTime";
		TtTeam  ttTeam=dao.getTtTeam(teamId);
		if(null==ttTeam){
			throw new MlsException("根据集货团ID查找不到对应的集货信息,请查证后再试!");
		}
		ProMarketBase proMarketBase=proMarketBaseDao.getProMarketBase(ttTeam.getMktId());
		if(null==proMarketBase){
			throw new MlsException("根据专业市场ID查找不到对应的市场信息,请查证后再试!");
		} 
		Map<String, Object> map=BeanMapUtil.beanToMap(ttTeam, null);
		BeanMapUtil.beanToMap(proMarketBase, map);
		if(null!=map &&  null!=map.get(endTimeKey)){
			map.put(endTimeKey, DateUtil.getTimeStringByLong(Long.parseLong(map.get(endTimeKey).toString()))); 
		}
		
		return map;
	}

	
	public void insertTeam(TtTeam ttTeam) throws MlsException {
		dao.insert(ttTeam);
	}
	
	public void updateTeam(TtTeam ttTeam)  throws MlsException {
		 dao.update(ttTeam);
	}
}
