/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.web.controller;

import com.communispace.otto.persistence.TestRepository;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gb
 */
@Controller
public class TestController {

	private static final Logger logger = Logger.getLogger(TestController.class);

	@Autowired(required = true)
	protected TestRepository testRespository;

	@RequestMapping(value="/home/test/{testId}", method=RequestMethod.GET)
	public String viewTest(@PathVariable String testId, Model model) throws IOException {
		
		model.addAttribute("test", testRespository.get(testId));
		
		return "test";
	}	
	
}
