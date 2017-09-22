/**
 * 
 */
package com.sadp.orm.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ntanwa
 *
 */
@Entity
@Table(name = "SADP_USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	/**
	 * @param string
	 */
	public User(String name) {
		this.name = name;
	}
	
	private User() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
