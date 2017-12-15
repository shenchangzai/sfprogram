package com.xu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.Anybus;

public interface AnybusDao extends BaseCRUDDao<String, Anybus>{

	public List<Anybus> getMkt();
	
	public int updateBaseLog(@Param("mktId")String mktId,@Param("lastTime")String lastTime);
}
