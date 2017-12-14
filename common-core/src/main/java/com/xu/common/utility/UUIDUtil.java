package com.xu.common.utility;

import java.util.UUID;

public class UUIDUtil {
	   
	/* 生成32位编码  
	 * @return string  
	 */    
	public static String getUUID(){    
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");    
	    return uuid;    
	} 
}
