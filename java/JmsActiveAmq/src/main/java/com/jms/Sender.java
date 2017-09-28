/**
 * 
 */
package com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ntanwa
 *
 */
@RestController
public class Sender {
	private final JmsTemplate jmsTemplate;

	@Autowired
	public Sender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	//Send msg to spring starter applicaiton
	@GetMapping(name = "/")
	public void send(){
		 // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
	}
}
