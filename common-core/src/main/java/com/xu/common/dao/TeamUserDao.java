package com.xu.common.dao;

import com.xu.common.model.TeamUser;

/**
 * 参团人员详情Dao层
 * @ClassName:  TeamUserDao  
 * @author: 01368614
 * @date:   2017年12月15日 下午1:58:39
 */
public interface TeamUserDao extends BaseCRUDDao<String, TeamUser>{
	/**
	 * 添加参团人员
	 * @param: teamUser      
	 * @return: void
	 */
	public void addTeamUser(TeamUser teamUser);
}
