package com.xu.common.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.xu.common.model.BaseModel;
import com.xu.common.service.BaseCRUDService;

/**
 * 符合REST通用的CRUD Controller
 * 
 *
 * @param <PK>
 *            模型的主键类型
 * @param <M>
 *            模型model
 * @param <S>
 *            服务Service
 */
public abstract class BaseCRUDController<PK extends Serializable, M extends BaseModel<PK>, S extends BaseCRUDService<PK, M>> extends BaseController<PK, M> {
	protected S service = null;// 继承BaseService的服务类,提供对DAO进行通用的CRUD操作.
	protected static int CACHE_RECORD_TOTAL = -1;// dataTable每次分页查询都需要表的总行数,缓存总行数减少数据库访问次数.

	public S getService() {
		return service;
	}

	@Autowired
	public void setService(S service) {
		this.service = service;
	}
}
