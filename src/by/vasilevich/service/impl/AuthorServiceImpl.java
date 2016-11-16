package by.vasilevich.service.impl;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import by.vasilevich.dao.IAuthorDAO;
import by.vasilevich.dao.impl.JDBCAuthorDAOImpl;
import by.vasilevich.entity.Author;
import by.vasilevich.service.IAuthorService;

import java.util.List;

//import javax.servlet.http.HttpSession;


//import static epam.resources.constants.Constants.*;


public class AuthorServiceImpl implements IAuthorService {

	private IAuthorDAO authorDao = new JDBCAuthorDAOImpl();
	
	@Override
	public int createAuthor(Author author) {
		return authorDao.createAuthor(author);
	}

	@Override
	public void deleteAuthor(int authorID) {
		authorDao.deleteAuthor(authorID);
	}

	@Override
	public Author getAuthor(int authorID) {
		return authorDao.getAuthor(authorID);
	}

	@Override
	public void updateAuthor(Author author) {
		authorDao.updateAuthor(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDao.getAllAuthors();
	}

	/* (non-Javadoc)
	 * @see epam.service.IAuthorService#login(java.lang.String, java.lang.String)
	 */

	
}
