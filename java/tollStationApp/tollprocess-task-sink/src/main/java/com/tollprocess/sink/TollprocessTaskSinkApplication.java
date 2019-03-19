package com.tollprocess.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
@EnableBinding(Source.class)
public class TollprocessTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollprocessTaskSinkApplication.class, args);
	}
}
