package com.communispace.otto.user;

import com.communispace.otto.exception.EmailAlreadyRegisteredException;
import com.communispace.otto.exception.NotLoggedInException;
import com.communispace.otto.persistence.User;
import com.communispace.otto.persistence.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.ektorp.DocumentNotFoundException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class CouchDBUserServiceImpl extends AbstractUserService implements UserService, UserDetailsService {

    private static final Logger logger = Logger.getLogger(CouchDBUserServiceImpl.class);
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public User getCurrentUser() throws NotLoggedInException {
        // called by CurrentUserHandlerInterceptor on every request



        User loggedInUser = null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof CouchUserDetails) {
                CouchUserDetails user = (CouchUserDetails) principal;
                loggedInUser = user.getRecord();
            } else {
                String userId = SecurityContextHolder.getContext().getAuthentication().getName();
                if (userId == null || userId.equals("anonymousUser")) {
                    throw new NotLoggedInException();
                }
                loggedInUser = getUser(userId);
            }
        } catch (Exception e) {
            throw new NotLoggedInException(e);
        }

        return loggedInUser;
    }

    public void registerUser(User userRecord) throws EmailAlreadyRegisteredException {

        try {
            getUser(userRecord.getEmail());
            throw new EmailAlreadyRegisteredException();
        } catch (UsernameNotFoundException e) { /* good! */ } catch (DocumentNotFoundException e) { /* also good! */ }

        userRecord.setId(userRecord.getEmail());
        String encodedPassword = passwordEncoder.encodePassword(userRecord.getPassword(), userRecord.getEmail());
        userRecord.setPassword(encodedPassword);
        userRepository.add(userRecord);


        // log them in
        CouchUserDetails user = new CouchUserDetails(userRecord);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));

    }

    public User getUser(String email) {

        logger.info("getUser() BEGIN");
        User user = userRepository.getByEmail(email);
        logger.info("getUser() GOT USER FROM COUCH");

        if (user == null) {
            throw new UsernameNotFoundException("No match for username " + email);
        } else {
            return user;
        }
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void updateDateLastLogin(User user) {
        user.setDateLastSeen(new DateTime());
        userRepository.update(user);
    }

    /**
     * Loads the User based on the user name. - implements Spring UserDetailsService interface method
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,
            DataAccessException {
        return new CouchUserDetails(getUser(username));
    }

    @Autowired
    @Required
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
