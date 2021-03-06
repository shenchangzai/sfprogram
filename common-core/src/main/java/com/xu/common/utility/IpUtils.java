package com.xu.common.utility;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xu.common.controller.TeamUserController;

public class IpUtils {
	private static final String UNKNOWN= "unknown";
	private static final Logger logger = LoggerFactory.getLogger(IpUtils.class);
    private IpUtils() {
    }

    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return UNKNOWN;
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    public static String getHeaders(HttpServletRequest request) {
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		Enumeration<String> namesEnumeration = request.getHeaderNames();
		while (namesEnumeration.hasMoreElements()) {
			String name = namesEnumeration.nextElement();
			Enumeration<String> valueEnumeration = request.getHeaders(name);
			List<String> values = new ArrayList<String>();
			while (valueEnumeration.hasMoreElements()) {
				values.add(valueEnumeration.nextElement());
			}
			headers.put(name, values);
		}
		return JacksonUtil.toJSon(headers);
	}
    
    public static String getServerIpAddr(){
        try{
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress();
            String address = addr.getHostName();
            return (new StringBuilder(String.valueOf(address))).append("(").append(ip).append(")").toString();
        }
        catch(Exception e){
        	logger.error("getServerIpAddr异常",e);
        }
        return "";
    }
}
