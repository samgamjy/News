package by.vasilevich.service;

import by.vasilevich.entity.Comment;

import java.util.List;


public interface ICommentService {
	int createComment(Comment comment);
	public Comment getCommeent(int commentID);
	public void updateComment(Comment comment);
	public List<Comment> getAllComments(int NewsID);

}
