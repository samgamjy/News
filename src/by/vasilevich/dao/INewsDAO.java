package by.vasilevich.dao;

import by.vasilevich.entity.News;

import java.util.List;

public interface INewsDAO {
	int createNews(News news);
	News getNews(int newsID);
	void updateNews(News news);
	void deleteNews(int newsID);
	List<News> getAllNewsByAuthor(int authoeID);
	List<News> getAllNews();
	List<News> getLast10News();

}
