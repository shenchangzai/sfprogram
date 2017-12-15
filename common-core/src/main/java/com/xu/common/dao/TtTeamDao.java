package com.xu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.TtTeam;

public interface TtTeamDao extends BaseCRUDDao<String, TtTeam>{
	public TtTeam getTtTeam(@Param("teamId") String teamId);
	
	public List<TtTeam> getTtTeamList();
	
	public TtTeam getTtTeamByMktId(TtTeam ttTeam);
}
