package by.vasilevich.dao;

import by.vasilevich.entity.Commentator;

import java.util.List;

public interface ICommentatorDAO {

	int createCommentator(Commentator commentator);
	void deleteCommentator(int commentatorID);
	Commentator getCommentator(int commentatorID);
	void updateCommentator(Commentator commentator);
	List<Commentator> getAllCommentators();

}
