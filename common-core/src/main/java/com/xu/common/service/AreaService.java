package com.xu.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.Area;

public interface AreaService extends BaseCRUDService<String, Area>{

	/**
	 * 查询某城市下地区
	 * @param:  cityId    
	 * @return: List<Area>
	 */
	public List<Area> getAreasByCityId(@Param("cityId")String cityId);
	
	public List<Area> getAreas();
}
