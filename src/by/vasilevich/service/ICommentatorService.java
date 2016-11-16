package by.vasilevich.service;

import by.vasilevich.entity.Commentator;

import java.util.List;

public interface ICommentatorService {

	int createCommentator(Commentator commentator);
	void deleteCommentator(int commentatorID);
	Commentator getCommentator(int commentatorID);
	void updateCommentator(Commentator commentator);
	List<Commentator> getAllCommentators();
}
