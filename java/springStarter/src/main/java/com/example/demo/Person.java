/**
 * 
 */
package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ntanwa
 *
 */
@Entity
public class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person() {
	
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
