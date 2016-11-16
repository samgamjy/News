package by.vasilevich.service;

import by.vasilevich.entity.User;

import java.util.List;


public interface IUserService {

	int createUser(User user);
	void deleteUser(int userID);
	User getUser(int userID);
	void updateUser(User user);
	List<User> getAllUsers();
	
	User login(String login, String password);
}
