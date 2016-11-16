package by.vasilevich.dao;

import by.vasilevich.entity.Comment;

import java.util.List;

public interface ICommentDAO {
	
	int createComment(Comment comment);
	Comment getComment(int commentID);
	void updateComment(Comment comment);
	void deleteComment(int commentID);
	List<Comment> getAllComments(int newsID);

}
