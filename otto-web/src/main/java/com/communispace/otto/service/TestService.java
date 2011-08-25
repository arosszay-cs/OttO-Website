/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.service;

import com.communispace.otto.persistence.Test;
import com.communispace.otto.persistence.TestRepository;
import com.communispace.otto.persistence.TestResult;
import com.communispace.otto.web.model.NUnitResult;
import java.util.List;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GBarnett
 */
@Service
public class TestService {

	private static final Logger logger = Logger.getLogger(TestService.class);

	@Autowired(required=true)
	TestRepository testRepository;
	
	public void processNUnitResult(NUnitResult nunitResult) {
		logger.debug("BEGIN: " + nunitResult);
		
		TestResult testResult = this.convertToTestResult(nunitResult);
		
		List<Test> tests = testRepository.findByTestClass(nunitResult.Name);
		if(tests.isEmpty()) {
			// this test is brand new to us!  create a new Test obj
			Test newTest = new Test();
			newTest.setTestClass(nunitResult.Name);
			newTest.setDescription(nunitResult.Description);
			newTest.setCategories(nunitResult.Categories);
			newTest.addResult(testResult);

			testRepository.add(newTest);

		} else {
			// update the existing Test object
			Test matchingTest = tests.get(0);
			
			matchingTest.setDescription(nunitResult.Description);
			matchingTest.setCategories(nunitResult.Categories);
			matchingTest.addResult(testResult);

			//TODO: if we want to keep the number of results constrained
			// (e.g. max 100), do it here

			testRepository.update(matchingTest);
		}
		
	}

		
	public TestResult convertToTestResult(NUnitResult nunitResult) {
		
		TestResult tr = new TestResult();
		
		tr.setDateExecuted(new DateTime()); // now!  TODO: can we get this from nunit?
		
		if(nunitResult.IsSuccess)
			tr.setOutcome(TestResult.Outcome.SUCCESS);
		else if(nunitResult.IsFailure)
			tr.setOutcome(TestResult.Outcome.FAILURE);
		else if(!nunitResult.Executed)
			tr.setOutcome(TestResult.Outcome.NOT_RUN);
		else
			tr.setOutcome(TestResult.Outcome.INCONCLUSIVE); 
		
		tr.setDuration(nunitResult.Time);

		tr.setMessage(nunitResult.Message);
		
		tr.setStackTrace(nunitResult.StackTrace);
		
		return tr;
		
	}
}
