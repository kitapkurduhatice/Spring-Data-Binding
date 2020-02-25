package com.hatice.springdemo;

import java.sql.Date;

public class Employees {
	int employeesId;
	String firstName;
	String lastName;
	int salary;
	
	
	public int getEmployeesId() {
		return employeesId;
	}
	public void setEmployeesId(int employeesId) {
		this.employeesId = employeesId;
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
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employees(int employeesId, String firstName, String lastName, int salary) {
		super();
		this.employeesId = employeesId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	
	
	
	

}
