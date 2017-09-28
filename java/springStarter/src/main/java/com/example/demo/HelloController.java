/**
 * 
 */
package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ntanwa
 *
 */
@RestController
@RequestMapping("api/v1")
public class HelloController {
	/*@Autowired
	HelloRepository repo;*/
	
	@Autowired
	HelloRepo hRepo;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public List<Person> printHello(){
		return hRepo.findAll();
	}
	
	@RequestMapping(value = "/message/{message}", method = RequestMethod.GET)
	public Person printHello(@PathParam("message") String message){
		return hRepo.save(new Person(message));
	}
	
	@RequestMapping("/")
	public String home(HttpServletResponse response){
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			System.out.println("Error : "+e.getMessage());
		}
		return "Errro while redirecting to home URL";
	}
}
