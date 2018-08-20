/**
 * 
 */
package com.readYaml.dto;

import java.util.Map;

/**
 * @author Shiva
 */
public class AppConfiguration {

	private String appName;

	private boolean bdOverride;

	private Map<String, String> attributes;

	private Map<String, String> values;

	public AppConfiguration(String appName, boolean bdOverride, Map<String, String> attributes) {
		this.appName = appName;
		this.bdOverride = bdOverride;
		this.attributes = attributes;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public boolean isBdOverride() {
		return bdOverride;
	}

	public void setBdOverride(boolean bdOverride) {
		this.bdOverride = bdOverride;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}
}