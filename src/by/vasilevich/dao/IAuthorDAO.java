package by.vasilevich.dao;

import by.vasilevich.entity.Author;

import java.util.List;

public interface IAuthorDAO extends IUserDAO{

	int createAuthor(Author author);
	void deleteAuthor(int authorID);
	Author getAuthor(int authorID);
	void updateAuthor(Author author);
	List<Author> getAllAuthors();
	
	
}
