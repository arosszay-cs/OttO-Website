package com.communispace.otto.persistence;

import java.util.*;

import org.apache.log4j.Logger;
import org.ektorp.*;
import org.ektorp.support.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.Duration;

@Repository
public class UserRepository extends CouchDbRepositorySupport<User> {

	private static final Logger logger = Logger.getLogger(UserRepository.class);

	@Autowired(required=true)
	ObjectMapper objectMapper;

	@Autowired
	public UserRepository(@Qualifier("userDatabase") CouchDbConnector db) {
		super(User.class, db);
		initStandardDesignDocument();
	}

	@Override
	public List<User> getAll() {
		ViewQuery q = createQuery("all").descending(true);
		return db.queryView(q, User.class);
	}

	public User getByEmail(String email) {
		try { 
			return get(email);
		} catch (org.ektorp.DbAccessException dae) {
			logger.warn("Retrying user get query ONCE (due to presumed Socket timeout)");
			return get(email);
		}
	}
	
	
}