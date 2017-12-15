package com.xu.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.City;


public interface CityService extends BaseCRUDService<String, City>{

	/**
	 * 查询某省|直辖市|自治区旗下城市
	 * @param:  provinceId  省份ID 
	 * @return: List<City>
	 */
	public List<City> getCitiesByProvinceId(@Param("provinceId")String provinceId);
	
	/**
	 * 查询城市
	 */
	public List<City> getCities();
}
