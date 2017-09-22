package com.example.demo;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ntanwa
 *
 */

@Entity
public class Hello {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String message;
	public Hello(String string) {
		this.message = string;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hello [id=" + id + ", message=" + message + "]";
	}
	
	
}
