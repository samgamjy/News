package by.vasilevich.service.impl;

import java.util.List;

import by.vasilevich.dao.IUserDAO;
import by.vasilevich.dao.impl.JDBCUserDAOImpl;
import by.vasilevich.entity.User;
import by.vasilevich.service.IUserService;

public class UserServiceImpl implements IUserService {

	
	private IUserDAO userDAO = new JDBCUserDAOImpl(); 
	
	@Override
	public int createUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.createUser(user);
	}

	@Override
	public void deleteUser(int userID) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(userID);

	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return userDAO.getUser(userID);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

	@Override
	public User login(String login, String password) {
		// TODO Auto-generated method stub
		return userDAO.loginUser(login, password);
	}

}
