package com.xu.common.service;

import java.util.List;

import com.xu.common.model.Anybus;

public interface AnybusService extends BaseCRUDService<String, Anybus>{
	
	/**
	 * 获取所有集货信息
	 * @return
	 */
	public List<Anybus> getMkt();
	
	public int updateBaseLog(String mktId,long lastTime);

}
