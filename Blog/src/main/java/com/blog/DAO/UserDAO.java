package com.blog.DAO;

import com.blog.model.User;

public interface UserDAO {
	public int addUser(User user);
	public User getUser(String email);
	public void  updateUser(User user);
	

}
