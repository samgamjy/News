package by.vasilevich.dao.impl;

import by.vasilevich.dao.IAuthorDAO;
import by.vasilevich.dao.IUserDAO;
import by.vasilevich.dao.pool.SimpleBasicDataSource;
import by.vasilevich.dao.utils.DBUtils;
import by.vasilevich.entity.Author;
import by.vasilevich.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

;

public class JDBCAuthorDAOImpl implements IAuthorDAO {

	private SimpleBasicDataSource dataSource;
	
	
	
	public JDBCAuthorDAOImpl() {
		this.dataSource = SimpleBasicDataSource.getInstance();
	}

	@Override
	public int createAuthor(Author author) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int authorID = INVALID_PARAM;
		
		try {
			
			
			IUserDAO userDAO = new JDBCUserDAOImpl();
//			int userID = userDAO.createUser(author.getUser());
			int userID = userDAO.createUser(author);

			
			connection = this.dataSource.getConection();
			
			preparedStatement = connection.prepareStatement(SQL_INSERT_AUTHOR, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, author.getFirstName());
			preparedStatement.setString(2, author.getLastName());
			preparedStatement.setString(3, author.getShortName());
			preparedStatement.setInt(4,  userID);
			
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
			 	authorID = resultSet.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		
		
		return authorID;
	}

	@Override
	public void deleteAuthor(int authorID) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 	
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_AUTHOR);
			preparedStatement.setInt(1, authorID);
			preparedStatement.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
	}

	@Override
	public Author getAuthor(int authorID) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Author author = new Author();
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_AUTHOR);
			preparedStatement.setInt(1, authorID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				author.setAuthorID(resultSet.getInt(1));
				author.setFirstName(resultSet.getString(2));
				author.setLastName(resultSet.getString(3));
				author.setShortName(resultSet.getString(4));
				int userID = resultSet.getInt(5);
				
				User user = new User();
				IUserDAO userDAO = new JDBCUserDAOImpl();
				user = userDAO.getUser(userID);
				author.setUser(user);
				/*
				preparedStatement = connection.prepareStatement(SQL_GET_USER);
				preparedStatement.setInt(1, userID);
				resultSet = preparedStatement.executeQuery(); 
				if (resultSet.next()) {
					user.setId(resultSet.getInt(1));
					user.setLogin(resultSet.getString(2));
					
				}
				*/
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return author;
	}

	@Override
	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Author> authorList = null;
		
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_ALL_AUTHOR);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			authorList = initAuthors(resultSet);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return authorList;
	}
	
    private List<Author> initAuthors(ResultSet resultSet) throws SQLException {
        List<Author> authorList = new ArrayList<Author>();
        while (resultSet.next()) {
            Author author = new Author();
            author.setAuthorID(resultSet.getInt(1));
            author.setFirstName(resultSet.getString(2));
            author.setLastName(resultSet.getString(3));
            author.setShortName(resultSet.getString(4));
            authorList.add(author);
        }
        return authorList;
    }

	@Override
	public int createUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(int userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
