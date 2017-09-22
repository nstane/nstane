package com.sadp.hibernate.tpc;  
  
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
  
@Entity  
@Table(name="contractemployee102")  
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="name", column=@Column(name="name"))  
})   
public class Contract_Employee extends Employee{  
      
    public float getPay_per_hour() {
		return pay_per_hour;
	}

	@Override
	public String toString() {
		return "Contract_Employee [pay_per_hour=" + pay_per_hour
				+ ", contract_duration=" + contract_duration + ", getId()="
				+ getId() + ", getName()=" + getName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

	@Column(name="pay_per_hour")  
    private float pay_per_hour;  
      
    @Column(name="contract_duration")  
    private String contract_duration;  
  
    //setters and getters  
}  