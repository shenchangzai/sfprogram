package com.xu.common.utility;

import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

import com.google.common.collect.Maps;

public class BeanMapUtil {
	private BeanMapUtil(){
	}
	/* 将对象装换为map 
	 * @param bean 
	 * @return  
	 */  
	public static <T> Map<String, Object> beanToMap(T bean,Map<String,Object> map) {  
		if(null== map){
			map=Maps.newHashMap();
		}
		if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(key+"", beanMap.get(key));  
	        }             
	    }  
	    return map;  
	} 
}
