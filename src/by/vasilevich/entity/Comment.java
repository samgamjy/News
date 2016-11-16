package by.vasilevich.entity;

import java.sql.Date;

public class Comment {
	
	private int commentID;
	private String commentText;
	private Date creationDate;
	private int newsID;
	private int commentatorID;
	
	public Comment() {
		super();
	}

	public Comment(String commentText, Date creationDate, int newsID, int commentatorID) {
		this.commentText = commentText;
		this.creationDate = creationDate;
		this.newsID = newsID;		
		this.commentatorID = commentatorID;
	}

	/**
	 * @return the commentID
	 */
	public int getCommentID() {
		return commentID;
	}

	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	/**
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the newsID
	 */
	public int getNewsID() {
		return newsID;
	}

	/**
	 * @param newsID the newsID to set
	 */
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	/**
	 * @return the commentatorID
	 */
	public int getCommentatorID() {
		return commentatorID;
	}

	/**
	 * @param commentatorID the commentatorID to set
	 */
	public void setCommentatorID(int commentatorID) {
		this.commentatorID = commentatorID;
	}
	
	 	
	

}
