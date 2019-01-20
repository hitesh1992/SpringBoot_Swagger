package com.exercise.SpringProject.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exercise.SpringProject.exceptions.UserNotFoundException;
import com.exercise.SpringProject.model.User;
import com.exercise.SpringProject.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource  messageSource;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userService.getUsers();
		
	}
	
	@GetMapping(path="/users/{userId}", consumes= {"application/json","application/xml"}, produces={"application/json","application/xml"})
	public Resource<User> getUser(@PathVariable int userId) {
		User user =  userService.getUser(userId);
		if(user == null)
			throw new UserNotFoundException("id - "+userId);
		
		//implementing HATEOAS (Hypermedia As The Engine of Application State)
		
		Resource<User> resource = new Resource(user);
		ControllerLinkBuilder linkTo=
				ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	//Using java validation API @Valid of javax.validation
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser =  userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").
		buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		User user =  userService.deleteUserById(userId);
		if(user == null)
			throw new UserNotFoundException("id - "+userId);
		
	}
	
	
	/*@GetMapping("/hello-world-internationalized")
	public String sayHello(@RequestHeader(name="Accept-Language", required=false) Locale locale){
		
		return messageSource.getMessage("good.morning.message",null, locale);
		
	}*/
	
	@GetMapping("/hello-world-internationalized")
	public String sayHello(){
		
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
		
	}
	
}
