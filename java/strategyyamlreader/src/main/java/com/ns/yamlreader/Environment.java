package com.ns.yamlreader;
/**
 * 
 */

/**
 * @author natanwar
 *
 */
public enum Environment {
	INT("int.yaml"), DEV("dev.yaml"), TEST("test.yaml"), PROD("prod.yaml");

	private String envFileName;

	Environment(String envFileName) {
		this.envFileName = envFileName;
	}

	public String getEnvFileName() {
		return envFileName;
	}
}
