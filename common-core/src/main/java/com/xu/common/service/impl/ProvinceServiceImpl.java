package com.xu.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xu.common.dao.ProvinceDao;
import com.xu.common.model.Province;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.ProvinceService;

@Service
public class ProvinceServiceImpl extends AbstractCRUDBaseService<String, Province, ProvinceDao> implements ProvinceService {

	
	/**
	 * 获取省份列表
	 * @param: @return      
	 * @return: List<Province>
	 */
	@Override
	public List<Province> getProvinces(){
		return dao.getProvinces();
	}
	

}
