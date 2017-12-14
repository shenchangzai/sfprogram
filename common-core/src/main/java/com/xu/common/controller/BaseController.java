package com.xu.common.controller;

import java.beans.PropertyEditorSupport;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.xu.common.DateFormat;
import com.xu.common.model.BaseModel;

/**
 * 基础控制器
 * 
 * @author xu
 *
 */
public abstract class BaseController<PK extends Serializable, M extends BaseModel<PK>> {
	protected Logger logger = LoggerFactory.getLogger(getClass());// 日志
	protected Class<M> entityClass = null;// 保存Model的类型,以便转json等用途

	/**
	 * 构造函数 获取泛型的类(Class)
	 */
	@SuppressWarnings("unchecked")
	public BaseController() {
		Type genType = getClass().getGenericSuperclass();
		Type[] paramTypes = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<M>) paramTypes[1];
	}

	/**
	 * 日期转换
	 *
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				try {
					setValue(DateUtils.parseDate(text, DateFormat.DATE_TIME, DateFormat.DATE, DateFormat.TIME));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
