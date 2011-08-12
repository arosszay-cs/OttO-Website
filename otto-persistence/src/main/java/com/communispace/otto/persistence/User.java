package com.communispace.otto.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.ektorp.support.CouchDbDocument;
import org.joda.time.DateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends CouchDbDocument {

	private static final Logger logger = Logger.getLogger(User.class);
	private DateTime dateCreated;
	private DateTime dateLastSeen;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<String> roles;
	private boolean accountNonLocked = true;

	public DateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public DateTime getDateLastSeen() {
		return dateLastSeen;
	}

	public void setDateLastSeen(DateTime dateLastSeen) {
		this.dateLastSeen = dateLastSeen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
