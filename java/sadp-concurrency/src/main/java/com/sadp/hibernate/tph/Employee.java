package com.sadp.hibernate.tph;  
import javax.persistence.*;  
 //CREATE TABLE EMPLOYEE101(id float,type varchar(255), name varchar(255), salary float, bonus float, pay_per_hour float, contract_duration varchar(55)) 
@Entity  
@Table(name = "employee101")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="employee")  
  
public class Employee {  
@Id  
@GeneratedValue(strategy = GenerationType.AUTO)

      
@Column(name = "id")  
private int id;  
  
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name = "name")  
private String name;  
  
//setters and getters  
} 