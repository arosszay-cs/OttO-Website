package com.communispace.otto.web;

import com.communispace.otto.exception.NotLoggedInException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.communispace.otto.user.UserService;

public class CurrentUserHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(CurrentUserHandlerInterceptor.class);
    @Autowired(required = true)
    private UserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        return true;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView != null
                && modelAndView.getViewName() != null
                && !modelAndView.getViewName().startsWith("redirect")) {
            // Spring's RedirectView (i.e. "redirect:/home/search") automatically transforms
            // all model attributes into querystring args.  This is undesirable for user stuff, 
            // so only add them if this isn't a redirect
            if (userService != null) {
                try {
                    modelAndView.addObject("currentUser", userService.getCurrentUser());
                } catch (NotLoggedInException e) { }
            }

        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
