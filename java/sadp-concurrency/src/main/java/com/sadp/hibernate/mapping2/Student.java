/**
 * 
 */
package com.sadp.hibernate.mapping2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author ntanwa
 *
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	//private List<Course> cources;

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

	/**
	 * @param id
	 * @param name
	 */
	public Student(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public Student() {
	}

	
	
}
