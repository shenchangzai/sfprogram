package com.xu.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xu.common.dao.AnybusDao;
import com.xu.common.model.Anybus;
import com.xu.common.service.AbstractCRUDBaseService;
import com.xu.common.service.AnybusService;

@Service
public class AnybusServiceImpl extends AbstractCRUDBaseService<String, Anybus, AnybusDao> implements AnybusService {

	public List<Anybus> getMkt() {
		return dao.getMkt();
	}
	
	public int updateBaseLog(String mktId,long lastTime){
		return dao.updateBaseLog(mktId, lastTime);
	}

}
