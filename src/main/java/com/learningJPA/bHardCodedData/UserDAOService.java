package com.learningJPA.bHardCodedData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class UserDAOService {
	@Getter
	@Setter
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
}
