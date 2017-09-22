package com.sadp.hibernate.crieteria.example;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "DEPARTMENT")
@Immutable
public class Department {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "DPT_ID")
   private long id;

   @Column(name = "NAME", nullable = false, unique = true)
   private String name;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
   private List<Employee> employees = new ArrayList<>();

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Employee> getEmployees() {
	return employees;
}

public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}

   
   
}