package com.akser.repository;

import beans.User;

public final class UserRepository {

	static User user;

	
	public UserRepository(){
		
	}
	public UserRepository(User user) {
		this.user = user;
	}

	public User getUser(){
		
		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}
}
