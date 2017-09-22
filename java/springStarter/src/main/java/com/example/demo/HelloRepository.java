/**
 * 
 *//*
package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

*//**
 * @author ntanwa
 *
 *//*
@Repository
public class HelloRepository extends HibernateDaoSupport{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Hello getHelloFromDB(){
		Session session = sessionFactory.openSession();
		session.save(new Hello("Hi Narender"));
		Hello hello = (Hello) session.get("select p from Hello p",Hello.class);
		session.close();
		return hello;
	}
}
*/