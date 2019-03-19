/**
 * 
 */
package com.tollprocess.intake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author natanwar
 *
 */
@RestController
public class TaskController {

	@Autowired
	private TaskProcessor processor;

	@PostMapping("/tasks")
	public @ResponseBody String lanchTask(@RequestBody String request) {
		try {
			processor.publish(request);
		} catch (Exception e) {
			return "error :" + e.getMessage();
		}
		return "sucess";
	}
}
