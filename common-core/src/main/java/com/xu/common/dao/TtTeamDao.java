package com.xu.common.dao;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.TtTeam;

public interface TtTeamDao extends BaseCRUDDao<String, TtTeam>{
	public TtTeam getTtTeam(@Param("teamId") String teamId);
	
}
