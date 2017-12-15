package com.xu.common.service;

import java.util.List;

import com.xu.common.model.Anybus;

public interface AnybusService extends BaseCRUDService<String, Anybus>{
	
	/**
	 * 获取所有集货信息
	 * @return
	 */
	public List<Anybus> getMkt();
	
	/**
	 * 根据集货ID更新下次开团时间
	 * @param mktId
	 * @param lastTime
	 * @return
	 */
	public int updateBaseLog(String mktId,long lastTime);

}
