package com.xu.common.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonUtil {
	private JacksonUtil(){}
	private static final  Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	private static ObjectMapper objectMapper;

	/**
	 * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
	 * (1)转换为普通JavaBean：readValue(json,Student.class)
	 * (2)转换为List,如List<Student>,将第二个参数传递为Student
	 * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
	 * 
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	public static <T> T readValue(String jsonStr, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(jsonStr, valueType);
		} catch (Exception e) {
			logger.warn("泛型方法转换发生错误:",e);
		}

		return null;
	}
	
	/**
	 * json数组转List
	 * @param jsonStr
	 * @param valueTypeRef
	 * @return
	 */
	public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(jsonStr, valueTypeRef);
		} catch (Exception e) {
			logger.warn("json数组转List转换发生错误:",e);
		}

		return null;
	}

	/**
	 * 把JavaBean转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.warn("JavaBean转换为json字符串发生错误:",e);
		}

		return null;
	}

}