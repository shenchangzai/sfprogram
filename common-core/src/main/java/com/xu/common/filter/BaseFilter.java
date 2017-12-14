package com.xu.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * whiteListURLs:白名单,需要过滤的URL<br/>
 * blackListURLs:黑名单,不需要过滤的URL
 */
public abstract class BaseFilter implements Filter {

	private FilterConfig config = null;

	private final String[] NULL_STRING_ARRAY = new String[0];
	private final String URL_SPLIT_PATTERN = "[, ;\r\n]";// 逗号 空格 分号 换行

	private final PathMatcher pathMatcher = new AntPathMatcher();

	/**
	 * 白名单:需要过滤的URL
	 */
	private String[] includes = null;

	/**
	 * 黑名单:不需要过滤的URL
	 */
	private String[] excludes = null;

	@Override
	public final void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.initConfig();
		this.init();
	}

	public void init() throws ServletException {
		/**
		 * 设置时区
		 */
		final TimeZone zone = TimeZone.getTimeZone("GMT+8");
		TimeZone.setDefault(zone);
	}

	/**
	 * 1、黑名单匹配 2、白名单匹配
	 */
	@Override
	public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String currentURL = httpRequest.getServletPath();

		//logger.debug("当前请求URL:[{}]", currentURL);

		if (isBlackURL(currentURL)) {
			chain.doFilter(request, response);
			return;
		}

		if (!isWhiteURL(currentURL)) {
			chain.doFilter(request, response);
			return;
		}
		doFilter(httpRequest, httpResponse, chain);
		return;
	}

	private boolean isWhiteURL(String currentURL) {
		for (String include : includes) {
			if (pathMatcher.match(include, currentURL)) {
				//logger.debug("白名单:当前请求路径: [{}] 匹配到 [{}].", currentURL, include);
				return true;
			}
		}
		//logger.debug("白名单:当前请求路径: [{}] 匹配不到任何资源 [{}]", currentURL, Arrays.toString(includes));
		return false;
	}

	private boolean isBlackURL(String currentURL) {
		for (String exclude : excludes) {
			if (pathMatcher.match(exclude, currentURL)) {
				//logger.debug("黑名单:当前请求路径: [{}] 匹配到 [{}].", currentURL, exclude);
				return true;
			}
		}
		//logger.debug("黑名单:当前请求路径: [{}] 匹配不到任何资源 [{}]", currentURL, Arrays.toString(excludes));
		return false;
	}

	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

	@Override
	public void destroy() {
	}

	private void initConfig() {
		String includeURLString = this.config.getInitParameter("includes");
		includes = strToArray(includeURLString);

		String excludeURLString = this.config.getInitParameter("excludes");
		excludes = strToArray(excludeURLString);
	}

	private String[] strToArray(String urlStr) {
		if (urlStr == null) { return NULL_STRING_ARRAY; }
		String[] urlArray = urlStr.split(URL_SPLIT_PATTERN);

		List<String> urlList = new ArrayList<String>();

		for (String url : urlArray) {
			url = url.trim();
			if (url.length() == 0) {
				continue;
			}
			urlList.add(url);
		}

		return urlList.toArray(NULL_STRING_ARRAY);
	}

	public FilterConfig getConfig() {
		return config;
	}
}
