package com.xu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.City;

/**
 * 城市Dao层
 * @ClassName:  CityDao  
 * @author: 01368614
 * @date:   2017年12月15日 上午11:59:13
 */
public interface CityDao extends BaseCRUDDao<String, City>{
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
