package com.xu.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 在web.xml中配置此过滤器,使服务器可以支持跨域访问.
 * </p>
 * <ul>
 * 使用场景:
 * <li>提供跨域API接口</li>
 * <li>前后端分开部署</li>
 * <li>APP接口通讯</li>
 * </ul>
 */
public class CrossMainFilter extends BaseFilter {

	public final String HTTP_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	public final String HTTP_ALLOW_METHOD = "Access-Control-Allow-Methods";
	public final String HTTP_ALLOW_HEARDERS = "Access-Control-Allow-Headers";
	public final String HTTP_ALLOW_MAX_AGE = "Access-Control-Max-Age";
	public final String HTTP_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 设置Access-Control-Allow-Origin为*，支持跨域请求
		response.addHeader(HTTP_ALLOW_ORIGIN, "*");
		// 设置Access-Control-Allow-Headers为Origin, X-Requested-With, Content-Type, Accept，支持跨域请求
		response.setHeader(HTTP_ALLOW_HEARDERS, "Origin, X-Requested-With, Content-Type, Accept");
		// 设置Access-Control-Request-Methods为GET,POST,PUT,DELETE，支持跨域请求方法
		response.addHeader(HTTP_ALLOW_METHOD, "GET, POST, PUT, OPTIONS, DELETE");
		
		response.setHeader(HTTP_ALLOW_MAX_AGE, "3600");
		// 设置Access-Control-Allow-Headers为Authorization，支持跨域请求
		//response.addHeader(HTTP_ALLOW_HEARDERS, "Authorization, X-Requested-With, Content-Type");
		chain.doFilter(request, response);
		
	}
}