package com.readYaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.readYaml.bdtype.BDType;
import com.readYaml.dto.AppConfiguration;
import com.readYaml.factory.AppConfigBuilder;

@SpringBootApplication
public class ReadYamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadYamlApplication.class, args);
	}
}

@Component
class UserComponent implements CommandLineRunner {

	@Autowired
	Environment env;
	
	@Autowired
	private AppConfigBuilder appConfigBuilder;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Application Started");
		System.out.println(env.getProperty("destinationEndPoint"));
		
		AppConfiguration appConfig = appConfigBuilder.getAppConfiguration(BDType.CIS);
		System.out.println(appConfig.isBdOverride());

	}
}