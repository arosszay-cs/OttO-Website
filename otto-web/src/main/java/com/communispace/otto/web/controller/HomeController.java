package com.communispace.otto.web.controller;

import com.communispace.otto.persistence.Test;
import com.communispace.otto.persistence.TestRepository;

import com.communispace.util.CacheableResult;

import java.util.List;
import org.apache.log4j.Logger;
import org.joda.time.Duration;
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

	private CacheableResult<List<Test>> pastWeekUnstableTests =
			new CacheableResult<List<Test>>(new Duration(1000 * 60 * 15)) {
				protected List<Test> retrieveFreshResult() {
					return testRespository.getPastWeekUnstable();
				}
			};

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

//		List<Test> tests = testRespository.getAll();
//
//		model.addAttribute("tests", tests);

		//TODO cacheable this shit... import from DA?
		model.addAttribute("pastWeekUnstableTests", pastWeekUnstableTests.getResult());
		return "home"; // this String is the name of the view to display

	}
}
