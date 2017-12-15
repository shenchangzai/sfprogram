package com.xu.common.service;

import com.xu.common.model.TeamUser;

public interface TeamUserService extends BaseCRUDService<String, TeamUser>{

	/**
	 * 添加参团人员
	 * @param: teamUser      
	 * @return: void
	 */
	public void addTeamUser(TeamUser teamUser);
}
