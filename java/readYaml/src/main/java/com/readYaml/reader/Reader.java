/**
 * 
 */
package com.readYaml.reader;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.readYaml.dto.Application;

/**
 * @author natanwar
 *
 */
@Component
public class Reader {
	
	private static final String APP_CONFIG_FILE = "appConfig.yaml";

	public static void main(String... a) {
		Application app = new Reader().readYaml();
		System.out.println(app);
	}

	public Application readYaml() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			return mapper.readValue(getClass().getClassLoader().getResource(APP_CONFIG_FILE), Application.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
