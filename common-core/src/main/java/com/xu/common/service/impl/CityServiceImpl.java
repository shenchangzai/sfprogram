package com.xu.common.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.xu.common.dao.CityDao;
import com.xu.common.model.City;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.CityService;

@Service
public class CityServiceImpl extends AbstractCRUDBaseService<String, City, CityDao> implements CityService {
	
	/**
	 * 查询某省|直辖市|自治区旗下城市
	 * @param:  provinceId  省份ID 
	 * @return: List<City>
	 */
	@Override
	public List<City> getCitiesByProvinceId(@Param("provinceId")String provinceId){
		return dao.getCitiesByProvinceId(provinceId);
	}
	
	/**
	 * 查询城市
	 */
	@Override
	public List<City> getCities(){
		return dao.getCities();
	}

}
