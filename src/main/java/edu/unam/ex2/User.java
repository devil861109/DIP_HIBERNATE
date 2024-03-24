package edu.unam.ex2;

public class User {
	
	private int id;
	
	@StringValid(minLength = 1, maxLength = 120)
	private String name;
	
	@StringValid(minLength = 6, maxLength = 20)
	private String password;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
