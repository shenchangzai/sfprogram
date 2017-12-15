package com.xu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.Area;

/**
 * 地区Dao层
 * @ClassName:  AreaDao  
 * @author: 01368614
 * @date:   2017年12月15日 下午1:01:36
 */
public interface AreaDao extends BaseCRUDDao<String, Area>{
	/**
	 * 查询某城市下地区
	 * @param:  cityId    
	 * @return: List<Area>
	 */
	public List<Area> getAreasByCityId(@Param("cityId")String cityId);
	
	public List<Area> getAreas();
}
