package com.xu.common.service;


import java.util.List;
import java.util.Map;

import com.xu.common.exception.MlsException;
import com.xu.common.model.Anybus;
import com.xu.common.model.TtTeam;

public interface TeamInfoService extends BaseCRUDService<String, TtTeam>{

	public Map<String,Object> getTeamInfo(String teamId) throws MlsException;
	
	public void updateTeam(TtTeam ttTeam) throws MlsException;
	
	public List<TtTeam> getTtTeamList() throws MlsException;
	
	public TtTeam getTtTeamByMktId(TtTeam ttTeam) throws MlsException;
	
	public boolean createTeam(Anybus mkt) throws MlsException;
	
	
}
