package by.vasilevich.dao.impl;

import static by.vasilevich.resources.constants.Constants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.vasilevich.dao.ICommentDAO;
import by.vasilevich.dao.pool.SimpleBasicDataSource;
import by.vasilevich.dao.utils.DBUtils;
import by.vasilevich.entity.Comment;

public class JDBCCommentDAOImpl implements ICommentDAO {

	private SimpleBasicDataSource dataSource;
	
	
	
	public JDBCCommentDAOImpl() {
		this.dataSource = SimpleBasicDataSource.getInstance();
	}

	@Override
	public int createComment(Comment comment) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int commentID = INVALID_PARAM;
		
		try{
			connection = this.dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_INSERT_COMMENT, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, comment.getCommentText());
			preparedStatement.setDate(2, comment.getCreationDate());
			preparedStatement.setInt(3, comment.getNewsID());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				commentID = resultSet.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}		
		return commentID;
	}

	@Override
	public Comment getComment(int commentID) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Comment comment = new Comment();
		
		try{
			connection = this.dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_COMMENT);
			preparedStatement.setInt(1, commentID);
			preparedStatement.setString(2, comment.getCommentText());
			preparedStatement.setDate(3, comment.getCreationDate());
			preparedStatement.setInt(4, comment.getNewsID());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				comment.setCommentID(resultSet.getInt(1));
				comment.setCommentText(resultSet.getString(2));
				comment.setCreationDate(resultSet.getDate(3));
				comment.setNewsID(resultSet.getInt(4));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}		
		return comment;
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		/*
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try{
			connection = this.dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_COMMENT);
			preparedStatement.setInt(1, commentID);
			preparedStatement.getString(2, comment.getCommentText());
			preparedStatement.getDate(3, comment.getCreationDate());
			preparedStatement.getInt(4, comment.getNewsID());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				comment.setCommentID(resultSet.getInt(1));
				comment.setCommentText(resultSet.getString(2));
				comment.setCreationDate(resultSet.getDate(3));
				comment.setNewsID(resultSet.getInt(4));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}		
		return comment;
		*/
	}

	@Override
	public void deleteComment(int commentID) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
				
		try{
			connection = this.dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_COMMENT);
			preparedStatement.setInt(1, commentID);
			preparedStatement.executeQuery();			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}		
	}

	@Override
	public List<Comment> getAllComments(int newsID) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<Comment> commentList = null;
		
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_ALL_COMMENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			commentList = initComments(resultSet);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return commentList;
	}

    private List<Comment> initComments(ResultSet resultSet) throws SQLException {
        List<Comment> commentList = new ArrayList<Comment>();
        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setCommentID(resultSet.getInt(1));
            comment.setCommentText(resultSet.getString(2));
            comment.setCreationDate(resultSet.getDate(3));
            comment.setNewsID(resultSet.getInt(4));
            commentList.add(comment);
        }
        return commentList;
    }


}
