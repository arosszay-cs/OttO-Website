package com.communispace.otto.web.controller;

import com.communispace.otto.persistence.TestResult;
import com.communispace.otto.persistence.TestRepository;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired(required = true)
	protected TestRepository testResultRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

		List<TestResult> testResults = testResultRepository.getAll();

		model.addAttribute("testResults", testResults);

		return "home"; // this String is the name of the view to display

	}
	
	@RequestMapping(value ="/home/add", method = RequestMethod.POST)
	public String addNew(
			@RequestParam String testClass, 
			@RequestParam String component, 
			@RequestParam TestResult.Outcome outcome,
			@RequestParam TestResult.Reason reason,
			@RequestParam int duration
			) {
		
		TestResult t = new TestResult();
		t.setTestClass(testClass);
		t.setComponent(component);
		t.setOutcome(outcome);
		t.setReason(reason);
		t.setDuration(duration);
		
		testResultRepository.add(t);
		
		return "redirect:/home";
	}
}
