package by.vasilevich.service.impl;

import java.util.List;

import by.vasilevich.dao.ICommentatorDAO;
import by.vasilevich.dao.impl.JDBCCommentatorDAOImpl;
import by.vasilevich.entity.Commentator;
import by.vasilevich.service.ICommentatorService;

public class CommentatorServiceImpl implements ICommentatorService {

	
	private ICommentatorDAO commentatorDao = new JDBCCommentatorDAOImpl();

	
	@Override
	public int createCommentator(Commentator commentator) {
		// TODO Auto-generated method stub
		
		return commentatorDao.createCommentator(commentator);
	}

	@Override
	public void deleteCommentator(int commentatorID) {
		// TODO Auto-generated method stub

		commentatorDao.deleteCommentator(commentatorID);
	}

	@Override
	public void updateCommentator(Commentator commentator) {
		// TODO Auto-generated method stub
		commentatorDao.updateCommentator(commentator);

	}

	@Override
	public List<Commentator> getAllCommentators() {
		// TODO Auto-generated method stub
		return commentatorDao.getAllCommentators();
	}

	@Override
	public Commentator getCommentator(int commentatorID) {
		// TODO Auto-generated method stub
		return commentatorDao.getCommentator(commentatorID);
	}

}
