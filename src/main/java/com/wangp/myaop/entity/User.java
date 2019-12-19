package com.wangp.myaop.entity;
 
import java.io.Serializable;
import java.util.Date;



public class User implements Serializable {
	
	private int id;
	private String username;
	private int age;
	private String ctm;

	public static User mixUser(User userValue, User userHash) {
		return new User(userHash.getId()+userValue.getId(),userHash.getUsername()+userValue.getUsername(),userHash.getAge()+userValue.getAge(),userHash.getCtm()+userValue.getCtm());
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCtm() {
		return ctm;
	}
	public void setCtm(String ctm) {
		this.ctm = ctm;
	}

	public User() {

	}

	public User(int id, String username, int age, String ctm) {
		this.id = id;
		this.username = username;
		this.age = age;
		this.ctm = ctm;
	}
}