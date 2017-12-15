package com.xu.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xu.common.CommonContants;
import com.xu.common.DateFormat;
import com.xu.common.dao.ProMarketBaseDao;
import com.xu.common.dao.TtTeamDao;
import com.xu.common.exception.MlsException;
import com.xu.common.model.Anybus;
import com.xu.common.model.ProMarketBase;
import com.xu.common.model.TeamRule;
import com.xu.common.model.TtTeam;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.AnybusService;
import com.xu.common.service.TeamInfoService;
import com.xu.common.service.TeamRuleService;
import com.xu.common.utility.BeanMapUtil;
import com.xu.common.utility.DateUtil;
import com.xu.common.utility.UUIDUtil;

@Service
public class TeamInfoServiceImpl extends AbstractCRUDBaseService<String, TtTeam, TtTeamDao> implements TeamInfoService {
	@Resource
	ProMarketBaseDao proMarketBaseDao; 
	
	@Resource
	TeamRuleService teamRuleService;
	
	@Resource
	AnybusService anybusService;
	
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
		Map<String, Object> map=new HashMap<>();
		BeanMapUtil.beanToMap(ttTeam, map);
		BeanMapUtil.beanToMap(proMarketBase, map);
		if(null!=map &&  null!=map.get(endTimeKey)){
			map.put(endTimeKey, DateUtil.getTimeStringByLong(Long.parseLong(map.get(endTimeKey).toString()))); 
		}
		
		return map;
	}
	
	@Override
	public boolean createTeam(Anybus mkt) throws MlsException {
		long sysTime = System.currentTimeMillis();
		String teamId = UUIDUtil.getUUID();
		TtTeam team = new TtTeam();
		team.setTeamId(teamId);
		team.setTeamName(getTeamName(mkt));
		team.setEndTime(sysTime + mkt.getGroupDuration() * 60 * 1000);
		team.setStatus(CommonContants.STATUS_INIT);
		team.setMktId(mkt.getMktId());
		team.setCtNum(0);
		dao.insert(team);
		anybusService.updateBaseLog(mkt.getMktId(), sysTime);
		return false;
	}

	/**
	 * 根据专业市场ID和状态查询集货团信息
	 */
	public TtTeam getTtTeamByMktId(TtTeam ttTeam) throws MlsException {
		return dao.getTtTeamByMktId(ttTeam);
	}
	
	
	public List<TtTeam> getTtTeamList() throws MlsException {
		return dao.getTtTeamList();
	}
	
	
	public void updateTeam(TtTeam ttTeam)  throws MlsException {
		 dao.update(ttTeam);
	}

	private String getTeamName(Anybus mkt) {
		String date = getDate();
		TeamRule teamRule = teamRuleService.getTeamRule(mkt.getMktId(), date);
		if (null == teamRule) {
			teamRule = new TeamRule();
			teamRule.setMktId(mkt.getMktId());
			teamRule.setRule(date);
			teamRule.setIncr(1);
			teamRuleService.add(teamRule);
		} else {
			teamRuleService.updateRule(mkt.getMktId(), teamRule.getRule());
		}
		StringBuilder teamName = new StringBuilder();
		teamName.append(mkt.getMktNameShow()).append(" ");
		teamName.append(date).append(" ");
		teamName.append(teamRule.getIncr());
		teamName.append("期");
		return teamName.toString();
	}
	
	/**
	 * 格式化时间字符串
	 * 
	 * @return
	 */
	private String getDate() {
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat.DATE_YYYYMMDD);
		return sf.format(new Date());
	}

}
