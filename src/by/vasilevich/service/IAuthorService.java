package by.vasilevich.service;

import by.vasilevich.entity.Author;

import java.util.List;

public interface IAuthorService {
	int createAuthor(Author author);
	void deleteAuthor(int authorID);
	Author getAuthor(int authorID);
	void updateAuthor(Author author);
	List<Author> getAllAuthors();
	
	

}
