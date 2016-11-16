package by.vasilevich.dao.impl;

import by.vasilevich.dao.IUserDAO;
import by.vasilevich.dao.pool.SimpleBasicDataSource;
import by.vasilevich.dao.utils.DBUtils;
import by.vasilevich.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

public class JDBCUserDAOImpl implements IUserDAO {

	private SimpleBasicDataSource dataSource;

	public JDBCUserDAOImpl() {
		this.dataSource = SimpleBasicDataSource.getInstance();
	}

	@Override
	public int createUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int userID = INVALID_PARAM;
		
		try{
			connection = this.dataSource.getConection();

//			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_CHECK_USER_ITEM);
			preparedStatement.setString(1, user.getLogin());
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            preparedStatement.setString(2, encodedPass);
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				PreparedStatement preparedStatementCreateUser = connection.prepareStatement(SQL_INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatementCreateUser.setString(1, user.getLogin());
				String password = user.getPassword();
				String encodedPass = md5Appache(password);
				preparedStatementCreateUser.setString(2, encodedPass);
				preparedStatementCreateUser.executeUpdate();
				ResultSet resultSetCreateUser = preparedStatementCreateUser.getGeneratedKeys();
				if (resultSetCreateUser.next()) {
					userID = resultSetCreateUser.getInt(1);
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		
		
		return userID;
	}

	@Override
	public void deleteUser(int userID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 	
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
			preparedStatement.setInt(1, userID);
			preparedStatement.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
	}

	@Override
	public User getUser(int userID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		User user = new User();
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_USER);
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setLogin(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				//user.setNickName(resultSet.getString(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return user;	
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<User> userList = null;
		
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_ALL_USER);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			userList = initUsers(resultSet);			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return userList;
	}
	
    private List<User> initUsers(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            userList.add(user);
        }
        return userList;
    }
    

	public String md5Appache(String st) {
		return DigestUtils.md5Hex(st);
	}

    @Override
    public User loginUser(String login, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        // Check function password
        
        try {
//        	String salt = "CheCkPass1843<!";
        	String encodedPass = md5Appache(password);
//        	String encodedPass = makeHash(password, salt);

            connection = dataSource.getConection();
            preparedStatement = connection.prepareStatement(SQL_CHECK_USER_ITEM);
            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, encodedPass);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
//				String tmp = resultSet.getString(3);
				if (encodedPass.equals(resultSet.getString(3))) {
					user = new User();
					user.setId(resultSet.getInt(1));
					user.setLogin(resultSet.getString(2));
				}
                }
            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(preparedStatement, connection);
        }
        return user;
    }


    
    

}
