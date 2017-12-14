package com.xu.common.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 暂时不使用
 * 
 * 自定义返回值拦截器,标注@ResponseBody方法 或者标注@RestController类 的所有请求返回前都会被此拦截.<br/>
 * 配置于spring-mvc.xml: <br/>
 * &lt;bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"&gt;<br/>
 * &lt;property name="responseBodyAdvice"&gt;<br/>
 * &lt;list&gt;<br/>
 * &lt;bean class="com.xu.common.advice.BaseResponseBodyAdvice" /&gt;<br/>
 * &lt;/list&gt;<br/>
 * &lt;/property&gt;<br/>
 * ...<br/>
 * &lt;/bean&gt;<br/>
 */
@Deprecated
public class BaseResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	private static Logger logger = LoggerFactory.getLogger(BaseResponseBodyAdvice.class);

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> httpMessageConverter) {
		if (logger.isDebugEnabled()) {
			logger.debug("supports contentType : {}", httpMessageConverter);
			logger.debug("supports returnType : {}", methodParameter);
		}
		return MappingJackson2HttpMessageConverter.class.isAssignableFrom(httpMessageConverter);
	}

	@Override
	public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> clazz, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

		if (logger.isDebugEnabled()) {
			logger.debug("request method : {}", serverHttpRequest.getMethod());
			logger.debug("supports mediaType :{}", mediaType);
			logger.debug("return entity : {}", null == object ? "null" : object.getClass().getName());
			logger.debug("supports method : {}", methodParameter.getMethod());
		}
		// 把所有返回封装到Result里返回到页面.
		// return Result.succeed(object);
		return object;
	}
}
