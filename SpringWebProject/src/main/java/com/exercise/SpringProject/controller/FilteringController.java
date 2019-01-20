package com.exercise.SpringProject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.SpringProject.model.Person;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	
	@GetMapping("/filter")
	public MappingJacksonValue getPerson() {
		Person person =  new Person(44680,"Tom",40,"Male");
		MappingJacksonValue mapping = new MappingJacksonValue(person);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("name","age");
		FilterProvider filters = new SimpleFilterProvider().addFilter("PersonFilter", filter );
		mapping.setFilters(filters);
		return mapping;
	}
	
	
	
	
	@GetMapping("/filter-list")
	public MappingJacksonValue getPersons() {
		List<Person> list = Arrays.asList(new Person(9999, "Roy", 28, "Male"), new Person(8888, "Laurel", 32, "Female"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("name","gender");
		FilterProvider filters = new SimpleFilterProvider().addFilter("PersonFilter", filter );
		mapping.setFilters(filters);
		return mapping;
	}

}
