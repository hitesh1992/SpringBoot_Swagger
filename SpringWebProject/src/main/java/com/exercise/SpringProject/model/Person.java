package com.exercise.SpringProject.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonFilter("PersonFilter")
public class Person {
	
	
	private Integer ssn;
	private String name;
	private Integer age;
	private String gender;
	
	
	
	public Person(Integer ssn, String name, Integer age, String gender) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.gender=gender;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
