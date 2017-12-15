package com.xu.common.service;


import java.util.Map;

import com.xu.common.exception.MlsException;
import com.xu.common.model.TtTeam;

public interface TeamInfoService extends BaseCRUDService<String, TtTeam>{

	public Map<String,Object> getTeamInfo(String teamId) throws MlsException;
	
	public void insertTeam(TtTeam ttTeam) throws MlsException;
}
