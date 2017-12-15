package com.xu.common.service.impl;

import org.springframework.stereotype.Service;

import com.xu.common.dao.TeamUserDao;
import com.xu.common.model.TeamUser;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.TeamUserService;

@Service
public class TeamUserServiceImpl extends AbstractCRUDBaseService<String, TeamUser, TeamUserDao> implements TeamUserService {

	/**
	 * 添加参团人员
	 * @param: teamUser      
	 * @return: void
	 */
	public void addTeamUser(TeamUser teamUser){
		dao.addTeamUser(teamUser);
	}
}
