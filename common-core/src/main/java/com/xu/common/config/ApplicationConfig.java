package com.xu.common.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.xu.common.utility.AESUtil;

import java.util.Properties;

/**
 * 配置文件
 */
public class ApplicationConfig extends PropertyPlaceholderConfigurer {

	private static Properties properties;
	private boolean encrypt;

	public void setEncrypt(boolean encrypt) {
		this.encrypt = encrypt;
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

	/**
	 * 配置文件中得数据库密码已做加密处理,重写了父类方法进行解密传递给数据库连接器.
	 * 
	 * @see AESUtil
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (this.encrypt) {
			if ("jdbc.password".equals(propertyName) || "jdbc.username".equals(propertyName)) { return AESUtil.decrypt(propertyValue); }
		}
		return propertyValue;
	}

}
