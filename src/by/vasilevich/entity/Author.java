package by.vasilevich.entity;

public class Author extends User {
	private int authorID;
	
	private String firstName;
	private String lastName;
	private String shortName;
//	private User user;
	
	
	
	
	
	
	public Author() {
//		this.user = new User();
	}
	
	public Author(String firstName, String lastName, String shortName, String login, String password) {
//		this.user = new User(login, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.shortName = shortName;
		this.setLogin(login);
		this.setPassword(password);
	}
	

	public int getAuthorID() {
		return authorID;
	}
	
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
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
		setLogin(user.getLogin());
		setPassword(user.getPassword());
//		this.user = user;
	}

	@Override
	public String toString() {
		return this.shortName;
	}
	
	
	
	

}
