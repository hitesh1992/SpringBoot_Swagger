package com.exercise.SpringProject.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All details about the user.")
public class User {
	
	private Integer id;
	private Integer age;
	
	//using java validation API (javax.validation)
	@Size(min=2, message="Name should have atleast 2 characters")	
	@ApiModelProperty(notes="Name should have atleast 2 characters.")
	private String name;
	
	@Past
	@ApiModelProperty(notes="BirthDate should be in the past.")
	private Date dob;
	
	
	User(){
		
	}
	
	public User(Integer id, Integer age, String name, Date dob) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.dob=dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	

}
