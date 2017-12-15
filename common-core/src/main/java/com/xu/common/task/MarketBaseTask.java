package com.xu.common.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xu.common.DateFormat;
import com.xu.common.model.Anybus;
import com.xu.common.model.TeamRule;
import com.xu.common.model.TtTeam;
import com.xu.common.service.AnybusService;
import com.xu.common.service.TeamRuleService;
import com.xu.common.utility.UUIDUtil;

@Service 
public class MarketBaseTask {
	@Resource
	AnybusService anybusService;
	
	@Resource
	TeamRuleService teamRuleService;
	
	public void marketBaseTask() {
//		AnybusService anybusService = SpringContextUtil.getBean(AnybusService.class);
		
		//查询出所有的集货信息
		List<Anybus> mktList =  anybusService.getMkt();
		if(mktList.isEmpty()){
			return;
		}
		for (Anybus mkt : mktList) {
			long sysTime = System.currentTimeMillis();
			long lastTime = mkt.getLastTime() ;
			if(lastTime == 0){//初次开团
				createTeam(mkt);
			}else if(sysTime <= (lastTime+mkt.getGroupDuration()*60*1000)){
							
			}else{
				
			}
		}
		
	}
	
	private boolean createTeam(Anybus mkt){
		try {
			String teamId = UUIDUtil.getUUID();
			TtTeam team = new TtTeam();
			team.setTeamId(teamId);
			team.setTeamName(getTeamName(mkt));
			team.setEndTime(System.currentTimeMillis()+mkt.getGroupDuration()*60*1000);
			team.setStatus("1");				
			team.setMktId(mkt.getMktId());	
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
	/**
	 * 格式化时间字符串
	 * @return
	 */
	private String getDate(){
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat.DATE_YYYYMMDD);
		return sf.format(new Date());
	}
	
	private String getTeamName(Anybus mkt){
		String date = getDate();
		TeamRule teamRule = teamRuleService.getTeamRule(mkt.getMktId(),date);
		if(null == teamRule){
			teamRule = new TeamRule();
			teamRule.setMktId(mkt.getMktId());
			teamRule.setRule(date);
			teamRule.setIncr(1);
			teamRuleService.add(teamRule);
		}else{
			teamRuleService.edit(teamRule);
		}
		
		StringBuilder teamName = new StringBuilder();
		teamName.append(mkt.getMktNameShow()).append(" ");
		teamName.append(date).append(" ");
		teamName.append(teamRule.getIncr());
		teamName.append("期");
		return "";
	}
}
