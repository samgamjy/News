package by.vasilevich.service.impl;

import by.vasilevich.dao.INewsDAO;
import by.vasilevich.dao.impl.JDBCNewsDAOImpl;
import by.vasilevich.entity.News;
import by.vasilevich.service.INewsService;

import java.util.List;

public class NewsServiceImpl implements INewsService {

	private INewsDAO newsDAO = new JDBCNewsDAOImpl(); 
	
	@Override
	public int createNews(News news) {
		// TODO Auto-generated method stub
		return newsDAO.createNews(news);
	}

	@Override
	public News getNews(int newsID) {
		// TODO Auto-generated method stub
		return newsDAO.getNews(newsID);
	}

	@Override
	public void updateNews(News news) {
		newsDAO.updateNews(news);
	}

	@Override
	public void deleteNews(int newsID) {
		newsDAO.deleteNews(newsID);
	}

	@Override
	public List<News> getAllNewsByAuthor(int authorID) {
		// TODO Auto-generated method stub
		return newsDAO.getAllNewsByAuthor(authorID);
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.getAllNews();
	}

	@Override
	public List<News> getLast10News() {
		return newsDAO.getLast10News();
	}
}
