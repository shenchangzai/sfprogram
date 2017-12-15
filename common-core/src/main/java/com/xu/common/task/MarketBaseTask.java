package com.xu.common.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xu.common.CommonContants;
import com.xu.common.exception.MlsException;
import com.xu.common.model.Anybus;
import com.xu.common.model.TtTeam;
import com.xu.common.service.AnybusService;
import com.xu.common.service.TeamInfoService;
import com.xu.common.service.TeamRuleService;

@Service
public class MarketBaseTask {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	AnybusService anybusService;

	@Resource
	TeamRuleService teamRuleService;

	@Resource
	TeamInfoService teamInfoService;

	public void marketBaseTask() {
		// 查询出所有的集货信息
		List<Anybus> mktList = anybusService.getMkt();
		if (mktList.isEmpty()) {
			return;
		}
		for (Anybus mkt : mktList) {
			try {
				TtTeam ttTeam = new TtTeam();
				long sysTime = System.currentTimeMillis();
				long lastTime = mkt.getLastTime();
				if (lastTime == 0) {// 初次开团
					teamInfoService.createTeam(mkt);
				} else {
					// 根据mktid获得团
					ttTeam.setMktId(mkt.getMktId());
					ttTeam.setStatus(CommonContants.STATUS_INIT);
					ttTeam = teamInfoService.getTtTeamByMktId(ttTeam);
					if (sysTime >= ttTeam.getEndTime()) {//开团超时
						ttTeam.setStatus(CommonContants.STATUS_ERR);
						teamInfoService.updateTeam(ttTeam);
						teamInfoService.createTeam(mkt);
					}else if (mkt.getGroupLimit() == ttTeam.getCtNum()){//开团完成
						ttTeam.setStatus(CommonContants.STATUS_END);
						teamInfoService.updateTeam(ttTeam);
						teamInfoService.createTeam(mkt);
					}
				}
			} catch (MlsException e) {
				logger.error(e.getMessage(), e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

}
