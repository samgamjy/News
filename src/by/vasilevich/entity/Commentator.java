package by.vasilevich.entity;

public class Commentator extends User {

	private int commentatorID;
	private String nickName;	
	
//	private User user;

	public Commentator(String login, String password, String nickName, User user) {
		super(login, password);
		this.nickName = nickName;
		this.setLogin(login);
		this.setPassword(password);
//		this.user = user;
	}

	public Commentator() {
		super();
	}

	public Commentator(String nickName) {
		super();
		this.nickName = nickName;
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
	

	
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	/**
	 * @return the user
	 */
	/*
	public User getUser() {
		return user;
	}
*/
	/**
	 * @param user the user to set
	 */

	public void setUser(User user) {
		this.setLogin(user.getLogin());
		this.setPassword(user.getPassword());
//		this.user = user;
	}

}
