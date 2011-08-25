/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.web.controller;

import com.communispace.otto.service.TestService;
import com.communispace.otto.web.model.NUnitResult;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GBarnett
 */
@Controller
public class NUnitPostController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired(required=true)
	TestService testService;
	
	@RequestMapping(value ="/ws/nunit", method = RequestMethod.POST)
	public void addNew(@RequestBody String json, HttpServletResponse response) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			NUnitResult nunitResult = objectMapper.readValue(json, NUnitResult.class);
			
			testService.processNUnitResult(nunitResult);
			
		} catch (IOException ex) {
			logger.warn(ex);
			try {
				response.sendError(500, "OMGWTF COULDNT PARSE JSON " + json);
			} catch (IOException ex2) { }
		}
	}

}
