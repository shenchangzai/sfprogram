package com.xu.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xu.common.utility.IpUtils;
import com.xu.common.utility.JacksonUtil;

/**
 * 记录访问日志
 */
public class AccessLogFilter extends BaseFilter {
	Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		logAccess(request);
		chain.doFilter(request, response);
	}

	public void logAccess(HttpServletRequest request) {
		String jsessionId = request.getRequestedSessionId();
		String ip = IpUtils.getIpAddr(request);
		String url = request.getRequestURI();
		String params = getParams(request);
		String headers = getHeaders(request);

		StringBuilder s = new StringBuilder();
		s.append(getBlock("SessionID", jsessionId));
		s.append(getBlock("IP", ip));
		s.append(getBlock("URL", url));
		s.append(getBlock("参数", params));
		s.append(getBlock("Header", headers));
		logger.info(s.toString());
	}

	public static String getBlock(String key, Object msg) {
		return "\"" + key + "\":[" + msg.toString() + "]";
	}

	protected static String getParams(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap();
		return JacksonUtil.toJSon(params);
	}

	private static String getHeaders(HttpServletRequest request) {
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
}