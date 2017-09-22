package com.sadp.hibernate.tpc;  
  
import javax.persistence.*;  
  
@Entity  
@Table(name="regularemployee102")  
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="name", column=@Column(name="name"))  
})  
public class Regular_Employee extends Employee{  
      
@Column(name="salary")    
private float salary;  
  
public float getSalary() {
	return salary;
}

@Override
public String toString() {
	return "Regular_Employee [salary=" + salary + ", bonus=" + bonus + "]";
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