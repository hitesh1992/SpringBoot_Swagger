package com.exercise.SpringProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.SpringProject.model.User;

@Service
public class UserService {
	
	private static List<User> lst = new ArrayList<>();
	
	private static int count=3;
	
	static {
		lst.add(new User(1, 22, "Sam", new Date()));
		lst.add(new User(2, 25, "Oliver",new Date()));
		lst.add(new User(3, 20, "Thea",new Date()));
	}
	
	public List<User> getUsers(){
		return lst;
	}
	
	public User getUser(int userId) {
		for(User user : lst) {
			if(user.getId() == userId)
				return user;
		}
		return null;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null)
			user.setId(++count);
		lst.add(user);
		return user;
	}
	
	public User deleteUserById(int id) {
		
		Iterator<User> iterator = lst.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
