package com.communispace.otto.user;

import com.communispace.otto.exception.EmailAlreadyRegisteredException;
import com.communispace.otto.exception.NotLoggedInException;
import com.communispace.otto.persistence.User;


public interface UserService {

	public void registerUser(User user) throws EmailAlreadyRegisteredException;
	
	public User getUser(String username);
	
	public User getCurrentUser() throws NotLoggedInException;
	
	public void updateUser(User user);

}
