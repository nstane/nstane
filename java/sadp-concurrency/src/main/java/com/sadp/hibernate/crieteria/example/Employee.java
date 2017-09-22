package com.sadp.hibernate.crieteria.example;
import javax.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
//@Immutable
@Table(name = "EMPLOYEE")
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "EMP_ID")
   private long id;


   @Column(name = "NAME", nullable = false)
   private String name;

   @Column(name = "DESIGNATION")
   private String designation;

   @Column(name="SALARY")
   private int salary;
   
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

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "DPT_ID")
   private Department department;

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", designation="
			+ designation + ", salary=" + salary + ", department=" + department
			+ "]";
}

   // Getter and Setter methods
}