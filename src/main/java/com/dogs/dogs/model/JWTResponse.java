package com.dogs.dogs.model;

public class JWTResponse {
	String token;
	long id;
	String userName;
	String email;
	String role;

	public JWTResponse(String token, long id, String userName, String email, String role) {
		super();
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
