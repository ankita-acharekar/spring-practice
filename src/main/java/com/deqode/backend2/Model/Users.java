package com.deqode.backend2.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    
    private String email;
    private String username;
    private String password;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Users(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
}
