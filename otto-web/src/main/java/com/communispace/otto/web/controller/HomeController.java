package com.communispace.otto.web.controller;

import com.communispace.otto.persistence.Test;
import com.communispace.otto.persistence.TestRepository;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired(required = true)
	protected TestRepository testRespository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

//		List<Test> tests = testRespository.getAll();
//
//		model.addAttribute("tests", tests);

		model.addAttribute("pastWeekUnstableTests", testRespository.getPastWeekUnstable());
		return "home"; // this String is the name of the view to display

	}
	
}
