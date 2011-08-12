package com.communispace.otto.user;

import com.communispace.otto.exception.EmailAlreadyRegisteredException;
import com.communispace.otto.exception.NotLoggedInException;
import com.communispace.otto.persistence.User;

import org.apache.log4j.Logger;

public abstract class AbstractUserService implements UserService {

    private static final Logger logger = Logger.getLogger(AbstractUserService.class);

    public abstract User getCurrentUser() throws NotLoggedInException;

    public abstract User getUser(String username);

    public abstract void registerUser(User user) throws EmailAlreadyRegisteredException;

    public abstract void updateUser(User user);


}
