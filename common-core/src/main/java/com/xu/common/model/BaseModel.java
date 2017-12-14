package com.xu.common.model;

import java.io.Serializable;

/**
 * 基础模型接口
 */
public interface BaseModel<PK extends Serializable> extends Serializable {

	PK getId();

	void setId(PK id);
}
