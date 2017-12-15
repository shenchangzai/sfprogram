package com.xu.common.utility;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Signature {

	private static final String HMAC_SHA1 = "HmacSHA1";

	/**
	 * 
	 * @param key 加密的key
	 * @param data 要加密的数据
	 * @return	返回加密后的byte数组
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String getHmacSHA1Signature(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1);
		Mac mac = Mac.getInstance(HMAC_SHA1);
		mac.init(signingKey);
		return new String(Base64.encodeBase64(mac.doFinal(data.getBytes())));
	}
	
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
