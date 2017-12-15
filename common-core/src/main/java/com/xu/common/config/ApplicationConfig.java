package com.xu.common.config;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 配置文件
 */
public class ApplicationConfig extends PropertyPlaceholderConfigurer {

	private static Properties properties;
	public void setEncrypt(boolean encrypt) {
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties properties) throws BeansException {
		super.processProperties(beanFactoryToProcess, properties);
		ApplicationConfig.properties = properties;
	}

	/**
	 * 获取指定配置信息
	 * 
	 * @param name
	 *            名称
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public String getProperty(String name, String defaultValue) {
		String value = null == properties ? "" : properties.getProperty(name);
		return StringUtils.isEmpty(value) ? defaultValue : value;
	}

	/**
	 * 获取指定配置信息
	 * 
	 * @param name
	 *            名称
	 * @return
	 */
	public String getProperty(String name) {
		String value = null == properties ? "" : properties.getProperty(name);
		return StringUtils.isEmpty(value) ? "" : value;
	}

	public void setProperty(String name, String value) {
		properties.setProperty(name, value);
	}

}
