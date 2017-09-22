package com.sadp.hibernate.cascade.example;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity implements Serializable
{
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer           employeeId;
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String            firstName;
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String            lastName;
 
    @OneToMany(orphanRemoval = true, mappedBy = "employee")
    private Set<AccountEntity> accounts;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}