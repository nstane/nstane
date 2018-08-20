/**
 * 
 */
package com.readYaml.dto;

import java.util.Map;

/**
 * @author natanwar
 *
 */
public class Application {

	private String appName;
	private Map<?,?> staticValues;
	private Map<?,?> dynamicValues;
	private BDOverride bdOverride;

	public BDOverride getBdOverride() {
		return bdOverride;
	}

	public void setBdOverride(BDOverride bdOverride) {
		this.bdOverride = bdOverride;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Map<?, ?> getStaticValues() {
		return staticValues;
	}

	public void setStaticValues(Map<?, ?> staticValues) {
		this.staticValues = staticValues;
	}

	public Map<?, ?> getDynamicValues() {
		return dynamicValues;
	}

	public void setDynamicValues(Map<?, ?> dynamicValues) {
		this.dynamicValues = dynamicValues;
	} 
}