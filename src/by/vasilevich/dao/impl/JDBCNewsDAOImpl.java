package by.vasilevich.dao.impl;

import by.vasilevich.dao.INewsDAO;
import by.vasilevich.dao.pool.SimpleBasicDataSource;
import by.vasilevich.dao.utils.DBUtils;
import by.vasilevich.entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.vasilevich.resources.constants.Constants.*;

public class JDBCNewsDAOImpl implements INewsDAO {

	
	private SimpleBasicDataSource dataSource;
	
	
	
	public JDBCNewsDAOImpl() {
		this.dataSource = SimpleBasicDataSource.getInstance();
	}

	
	@Override
	public int createNews(News news) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int newsID = INVALID_PARAM;
		
		try{
			connection = this.dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_INSERT_NEWS, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getShortText());
			preparedStatement.setString(3, news.getFullText());
			preparedStatement.setDate(4, news.getCreationDate());
			preparedStatement.setDate(5, news.getModificationDate());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				newsID = resultSet.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		
		
		return newsID;	}

	@Override
	public News getNews(int newsID) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		News news = new News();
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_NEWS);
			preparedStatement.setInt(1, newsID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				news.setNewsID(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setShortText(resultSet.getString(3));
				news.setFullText(resultSet.getString(4));
				news.setCreationDate(resultSet.getDate(5));
				news.setModificationDate(resultSet.getDate(6));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return news;
	}

	@Override
	public void updateNews(News news) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNews(int newsID) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		 	
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_DELETE_NEWS);
			preparedStatement.setInt(1, newsID);
			preparedStatement.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
	}

	@Override
	public List<News> getAllNewsByAuthor(int authoeID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<News> getAllNews() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<News> newsList = null;
		
		
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_ALL_NEWS);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			newsList = initNews(resultSet);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return newsList;
	}
	
    private List<News> initNews(ResultSet resultSet) throws SQLException {
        List<News> newsList = new ArrayList<News>();
        while (resultSet.next()) {
        	News news = new News();
            news.setNewsID(resultSet.getInt(1));
            news.setTitle(resultSet.getString(2));
            news.setShortText(resultSet.getString(3));
            news.setFullText(resultSet.getString(4));
            news.setCreationDate(resultSet.getDate(5));
            news.setModificationDate(resultSet.getDate(6));
        	
           
        }
        return newsList;
    }

    public List<News> getLast10News() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		List<News> newsList = null;
		try {
			connection = dataSource.getConection();
			preparedStatement = connection.prepareStatement(SQL_GET_LAST_10_NEWS);
			ResultSet resultSet = preparedStatement.executeQuery();
			newsList = initNews(resultSet);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
		}
		return newsList;
	}


}
