/**
 * 
 */
package com.readYaml.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.readYaml.bdtype.BDType;
import com.readYaml.dto.AppConfiguration;
import com.readYaml.dto.Application;
import com.readYaml.reader.Reader;

/**
 * @author natanwar
 *
 */
@Component
public class AppConfigBuilder {

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	private Reader reader;

	public AppConfiguration getAppConfiguration(BDType type) {
		return getOrBuildBDTypeBasedAppConfig(type);
	}

	public AppConfiguration getOrBuildBDTypeBasedAppConfig(BDType type) {
		AppConfiguration appConfig = null;
		try {
			appConfig = (AppConfiguration) context.getBean(type.getType());
		} catch (Exception e) {
			System.out.println("Bean not present");
		}
		if (appConfig == null) {
			Application app = reader.readYaml();
			if (app != null) {
				Map staticValues = app.getStaticValues();
				Map<String, String> attributes = (Map<String, String>) staticValues.get("attributes");
				staticValues.remove("attributes");
				boolean bdOverride = (boolean) staticValues.get("bdOverride");
				Map<String, String> values = staticValues;
				values.putAll((Map<String, String>) app.getDynamicValues());
				if (bdOverride) {
					Map<?, ?> bdOverridenValues = null;
					if (type == BDType.CAN) {
						bdOverridenValues = (Map<?, ?>) app.getBdOverride().getCan();
					} else if (type == BDType.CIS) {
						bdOverridenValues = (Map<?, ?>) app.getBdOverride().getCis();
					}
					attributes = (Map<String, String>) bdOverridenValues.get("attributes");
					bdOverridenValues.remove("attributes");
					values.putAll((Map<? extends String, ? extends String>) bdOverridenValues);
				}
				appConfig = new AppConfiguration(app.getAppName(), bdOverride, attributes);
				appConfig.setValues(values);
				//addAppConfigToContext(appConfig, type.getType());
			} else {
				System.out.println("Appplication Config not loaded from file.");
			}
		}
		return appConfig;
	}

	public boolean addAppConfigToContext(AppConfiguration appConfig, String name) {
		if (appConfig != null) {
			SingletonBeanRegistry beanRegistry = context.getBeanFactory();
			beanRegistry.registerSingleton(name, appConfig);
			context.refresh();
			return true;
		} else {
			System.out.println("AppConfig is null");
			return false;
		}
	}

}
