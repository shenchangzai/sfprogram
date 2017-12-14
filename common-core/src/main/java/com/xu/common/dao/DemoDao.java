package com.xu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.Demo;

public interface DemoDao extends BaseCRUDDao<String, Demo>{
	public List<Demo> getDemo(@Param("key")String key);
}
