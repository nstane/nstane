package com.sadp.hibernate.tph;  
  
import javax.persistence.*;  
  
@Entity  
@DiscriminatorValue("regularemployee")  
public class Regular_Employee extends Employee{  
      
@Column(name="salary")    
private float salary;  
  
public float getSalary() {
	return salary;
}

public void setSalary(float salary) {
	this.salary = salary;
}

public int getBonus() {
	return bonus;
}

public void setBonus(int bonus) {
	this.bonus = bonus;
}

@Column(name="bonus")     
private int bonus;  
  
//setters and getters  
} 