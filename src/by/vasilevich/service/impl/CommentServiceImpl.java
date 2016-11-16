package by.vasilevich.service.impl;

import java.util.List;

import by.vasilevich.dao.ICommentDAO;
import by.vasilevich.dao.impl.JDBCCommentDAOImpl;
import by.vasilevich.entity.Comment;
import by.vasilevich.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	
	private ICommentDAO commentDao = new JDBCCommentDAOImpl();
	
		

	@Override
	public int createComment(Comment comment) {
		return commentDao.createComment(comment);
	}

	@Override
	public Comment getCommeent(int commentID) {
		return commentDao.getComment(commentID);
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);

	}

	@Override
	public List<Comment> getAllComments(int newsID) {
		// TODO Auto-generated method stub
		return commentDao.getAllComments(newsID);
	}

}
