package by.vasilevich.entity;

public class User {
	private int id;
	private String login;
	private String password;

	public User() {
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 * @throws EntityException 
	 */
	public void setId(int id) {
				this.id = id;
			
		
		
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
