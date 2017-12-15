package com.xu.common.dao;

import java.util.List;

import com.xu.common.model.Province;

/**
 * 省份Dao层
 * @ClassName:  ProvinceDao  
 * @author: 01368614
 * @date:   2017年12月15日 上午11:59:36
 */
public interface ProvinceDao extends BaseCRUDDao<String, Province>{
	/**
	 * 获取省份列表
	 * @param: @return      
	 * @return: List<Province>
	 */
	public List<Province> getProvinces();
}
