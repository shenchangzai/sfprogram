package com.xu.common.utility;

import java.util.Map;

import org.springframework.cglib.beans.BeanMap;


public class BeanMapUtil {
	private BeanMapUtil(){
	}
	/* 将对象装换为map 
	 * @param bean 
	 * @return  
	 */  
	public static <T> Map<String, Object> beanToMap(T bean,Map<String,Object> map) {  
		if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(key+"", beanMap.get(key));  
	        }             
	    }  
	    return map;  
	} 
}
