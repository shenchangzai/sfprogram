package com.xu.common.dao;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.ProMarketBase;

public interface ProMarketBaseDao extends BaseCRUDDao<String, ProMarketBase>{
	public ProMarketBase getProMarketBase(@Param("mktId") String mktId);
}
