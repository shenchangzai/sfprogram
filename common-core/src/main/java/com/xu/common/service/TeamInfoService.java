package com.xu.common.service;


import java.util.Map;

import com.xu.common.model.TtTeam;

public interface TeamInfoService extends BaseCRUDService<String, TtTeam>{

	public Map<String,Object> getTeamInfo(String teamId) throws Exception;
	
	public Map<String,Object> insertTeam(TtTeam ttTeam) throws Exception;
}
