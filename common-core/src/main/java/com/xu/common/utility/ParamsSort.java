package com.xu.common.utility;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ParamsSort {
	
	public static String getSortedValuesString(Map<String,String> params){
		Set<String> keys = params.keySet();
		String[] perSortKeys = keys.toArray(new String[]{});
		Arrays.sort(perSortKeys);  
		StringBuilder values = new StringBuilder();
		for(String key : perSortKeys){
			values.append(params.get(key));
		}
		return values.toString();
	}
}
