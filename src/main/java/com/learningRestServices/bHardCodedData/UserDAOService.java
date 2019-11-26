package com.learningRestServices.bHardCodedData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Nitin", new Date()));
		users.add(new User(2, "Kirti", new Date()));
	}

	// Retrieve all users
	public List<User> findAll() {
		return getUsers();
	}
	
	// Retrieve users by Id
	public User findById(int id) {
		if(getUsers().get(id) == null) {
			return null;
		}
		
		return getUsers().get(id);
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserDAOService.users = users;
	}
}
