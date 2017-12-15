package com.xu.common.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.xu.common.dao.AreaDao;
import com.xu.common.model.Area;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.AreaService;

@Service
public class AreaServiceImpl extends AbstractCRUDBaseService<String, Area, AreaDao> implements AreaService {

	/**
	 * 查询某城市下地区
	 * @param:  cityId    
	 * @return: List<Area>
	 */
	@Override
	public List<Area> getAreasByCityId(@Param("cityId")String cityId){
		return dao.getAreasByCityId(cityId);
	}
	
	/**
	 * 查询地区
	 */
	@Override
	public List<Area> getAreas(){
		return dao.getAreas();
	}
}
