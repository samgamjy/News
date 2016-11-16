package by.vasilevich.dao.impl;

import by.vasilevich.dao.ICommentatorDAO;
import by.vasilevich.dao.IUserDAO;
import by.vasilevich.dao.pool.SimpleBasicDataSource;
import by.vasilevich.dao.utils.DBUtils;
import by.vasilevich.entity.Commentator;
import by.vasilevich.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

public class JDBCCommentatorDAOImpl implements ICommentatorDAO {

	private SimpleBasicDataSource dataSource;
	
	
	
	public JDBCCommentatorDAOImpl() {
		this.dataSource = SimpleBasicDataSource.getInstance();
	}

	@Override
	public int createCommentator(Commentator commentator) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int commentatorID = INVALID_PARAM;
		
		try{
			connection = this.dataSource.getConection();
			User user = new User();
			
//		 	user = commentator.getUser();
		 	
		 	IUserDAO userDAO = new JDBCUserDAOImpl();
		 	int userID = userDAO.createUser(commentator);

			preparedStatement = connection.prepareStatement(SQL_INSERT_COMMMENTATOR, PreparedStatement.RETURN_GENERATED_KEYS);
//			preparedStatement.setInt(1, commentator.getId());
			preparedStatement.setString(1, commentator.getNickName());
			preparedStatement.setInt(2, userID);
			int res = preparedStatement.executeUpdate();

			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				commentatorID = resultSet.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}		
		
		return commentatorID;
	}

	@Override
	public void deleteCommentator(int commentatorID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 	
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_COMMENTATOR);
			preparedStatement.setInt(1, commentatorID);
			preparedStatement.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
	}

	@Override
	public Commentator getCommentator(int commentatorID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Commentator commentator = new Commentator();
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_COMMENTATOR);
			preparedStatement.setInt(1, commentatorID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				commentator.setCommentatorID(resultSet.getInt(1));
				commentator.setNickName(resultSet.getString(2));
				int userID = resultSet.getInt(3);
				
				User user = new User();
				IUserDAO userDAO = new JDBCUserDAOImpl();
				user = userDAO.getUser(userID);
				commentator.setUser(user);

			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return commentator;
	}

	@Override
	public void updateCommentator(Commentator commentator) {

	}

	@Override
	public List<Commentator> getAllCommentators() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Commentator> commentatorList = null;
		
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_ALL_COMMENTATORS);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			commentatorList = initCommentators(resultSet);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return commentatorList;
	}
	
    private List<Commentator> initCommentators(ResultSet resultSet) throws SQLException {
        List<Commentator> commentatorList = new ArrayList<Commentator>();
        while (resultSet.next()) {
        	Commentator commentator = new Commentator();
        	commentator.setId(resultSet.getInt(1));
            commentator.setNickName(resultSet.getString(2));
            commentatorList.add(commentator);
        }
        return commentatorList;
    }

}
