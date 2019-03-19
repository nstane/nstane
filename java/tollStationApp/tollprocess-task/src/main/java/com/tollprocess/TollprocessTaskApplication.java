package com.tollprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TollprocessTaskApplication {
	private static final Logger LOG = LoggerFactory.getLogger(TollprocessTaskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TollprocessTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessTask tollProcessTask() {
		return new TollProcessTask();
	}

	public class TollProcessTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			if (null != args) {
				LOG.info("Task Parameters size {} Station : {}, licence Number : {} and time : {}", args.length, args[1], args[2], args[3]);
			}
		}

	}
}
