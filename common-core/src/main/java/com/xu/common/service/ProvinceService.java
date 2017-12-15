package com.xu.common.service;

import java.util.List;

import com.xu.common.model.Province;

public interface ProvinceService extends BaseCRUDService<String, Province>{

	/**
	 * 获取省份列表
	 * @param: @return      
	 * @return: List<Province>
	 */
	public List<Province> getProvinces();
}
