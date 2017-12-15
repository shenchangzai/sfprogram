package com.xu.common.service.impl;

import org.springframework.stereotype.Service;

import com.xu.common.dao.TeamRuleDao;
import com.xu.common.model.TeamRule;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.TeamRuleService;

@Service
public class TeamRuleServiceImpl extends AbstractCRUDBaseService<String, TeamRule, TeamRuleDao> implements TeamRuleService {

	@Override
	public TeamRule getTeamRule(String mktId,String rule) {
		return dao.getTeamRule(mktId,rule);
	}

	@Override
	public int updateRule(String mktId, String rule) {
		dao.updateRule(mktId, rule);
		return 0;
	}

}
