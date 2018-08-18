/**
 * 
 */
package com.ns.yamlreader.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ns.yamlreader.YamlObject;

/**
 * @author natanwar
 *
 */
public abstract class BaseYamlReader implements YamlReader {

	/**
	 * 
	 */
	public BaseYamlReader() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.ns.yamlreader.reader.YamlReader#readYaml(java.lang.String)
	 */
	public YamlObject read(String fileName) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			return mapper.readValue(getClass().getClassLoader().getResource(fileName), YamlObject.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
