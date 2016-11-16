package by.vasilevich.dao;

import by.vasilevich.entity.User;

import java.util.List;

public interface IUserDAO {
	
	int createUser(User user);
	void deleteUser(int userID);
	User getUser(int userID);
	void updateUser(User user);
	List<User> getAllUsers();	

	User loginUser(String login, String password);
//	void logoutUser();
	
}
