/**
 * 
 */
package com.ns.yamlreader.reader;

import com.ns.yamlreader.YamlObject;

/**
 * @author natanwar
 *
 */
public class DevYamlReader extends BaseYamlReader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ns.yamlreader.YamlReader#readYaml(java.lang.String)
	 */
	public YamlObject readYaml(String fileName) {
		YamlObject yaml = read(fileName);
		//TODO : Do something
		return yaml;
	}

}
