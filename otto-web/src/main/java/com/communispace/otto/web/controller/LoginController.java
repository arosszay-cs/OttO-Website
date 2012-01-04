package com.communispace.otto.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

/**
 * The splash page contains a login form - this page is used as an intercept when
 * a user tries to go to a bookmarked URL without logging in.
 * 
 * @author gb
 *
 */
@Controller
@RequestMapping(value="/auth/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method=RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {

		// Put the authentication exception on the model.
		AuthenticationException authenticationException = (AuthenticationException)WebUtils.getSessionAttribute(request, WebAttributes.AUTHENTICATION_EXCEPTION);
		if (authenticationException != null) {
			model.addAttribute("SECURITY_EXCEPTION", authenticationException);
			// clear it out
			WebUtils.setSessionAttribute(request, WebAttributes.AUTHENTICATION_EXCEPTION, null);
		}		

		return "login"; // this String is the name of the view to display

	}
}
