package com.ns.yamlreader.config;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ConfigurableApplicationContext;

import com.ns.yamlreader.YamlObject;

public class YamlConfigurationPool {

	private ConfigurableApplicationContext configContext;

	public YamlConfigurationPool(ConfigurableApplicationContext configContext) {
		this.configContext = configContext;
	}

	public YamlObject getYaml(String env) {
		return (YamlObject) configContext.getBean(env);
	}

	public boolean addYamlObjectToPool(String name, YamlObject yamlObject) {
		if (yamlObject != null) {
			SingletonBeanRegistry beanRegistry = configContext.getBeanFactory();
			beanRegistry.registerSingleton(name, yamlObject);
			configContext.refresh();
			return true;
		} else {
			System.out.println("Yaml Object is null.");
			return false;
		}
	}
}
