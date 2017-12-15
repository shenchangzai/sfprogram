package com.xu.common.service.impl;

import org.springframework.stereotype.Service;

import com.xu.common.dao.AnybusDao;
import com.xu.common.model.Anybus;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.AnybusService;

@Service
public class AnybusServiceImpl extends AbstractCRUDBaseService<String, Anybus, AnybusDao> implements AnybusService {

	@Override
	public String getUserAge(String user) {
		// TODO Auto-generated method stub
		return "12345";
	}

}
