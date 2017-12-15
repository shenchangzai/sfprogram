package com.xu.common.service;


import java.util.Map;

import com.xu.common.model.Demo;

public interface TeamInfoService extends BaseCRUDService<String, Demo>{

	public Map<String,Object> getTeamInfo(String teamId);
	
}
