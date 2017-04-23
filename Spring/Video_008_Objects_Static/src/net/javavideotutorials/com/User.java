package net.javavideotutorials.com;

public class User {

	public static int securityLevel = 1;
	private String username;
	private String password;
	
	// 1 constructor
	public User() {
		super();
	}
	public User(String p_username, String p_password) {
		this.username = p_username;
		this.password = p_password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
