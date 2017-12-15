package com.xu.common.service;

import com.xu.common.model.TeamRule;

public interface TeamRuleService extends BaseCRUDService<String, TeamRule> {

	public TeamRule getTeamRule(String mktId,String rule);
}
