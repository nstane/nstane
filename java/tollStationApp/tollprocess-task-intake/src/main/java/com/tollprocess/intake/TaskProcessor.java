/**
 * 
 */
package com.tollprocess.intake;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author natanwar
 *
 */
@Component
@EnableBinding(Source.class)
public class TaskProcessor {

	@Autowired
	private Source source;

	public void publish(String payload) {
		String url = "maven://com.tollprocess.tollprocess-task:tollprocess-task:jar:1.0";
		List<String> inputs = new ArrayList(Arrays.asList(payload.split(",")));
		TaskLaunchRequest taskRequest = new TaskLaunchRequest(url, inputs, null, null, null);
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<TaskLaunchRequest>(taskRequest);
		source.output().send(message);
	}

}
