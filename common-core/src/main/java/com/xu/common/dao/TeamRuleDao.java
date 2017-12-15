package com.xu.common.dao;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.TeamRule;

public interface TeamRuleDao  extends BaseCRUDDao<String, TeamRule>{

	public TeamRule getTeamRule(@Param("mktId")String mktId,@Param("rule")String rule);
	
	public void updateRule(@Param("mktIdtm")String mktIdtm,@Param("ruletm")String ruletm);
}
