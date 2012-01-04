package com.communispace.otto.user;

import com.communispace.otto.persistence.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


public class CouchUserDetails implements UserDetails {

	private User userRecord;
	
	public CouchUserDetails(User userRecord) {
		this.userRecord = userRecord;
	}
	
    public String getUsername() {
    	return userRecord.getEmail();
    }
    
    public Collection<GrantedAuthority> getAuthorities()
    {
        if (userRecord.getRoles() == null)
        {
            return Collections.emptyList();
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : userRecord.getRoles()) {
            authorities.add(new GrantedAuthorityImpl(role));
        }

        return authorities;
    }
	
	public String getPassword() {
		return userRecord.getPassword();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return userRecord.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
	
	public User getRecord() {
		return userRecord;
	}

}
