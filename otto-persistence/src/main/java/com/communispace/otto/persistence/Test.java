/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.persistence;

import java.util.ArrayList;
import java.util.List;
import org.ektorp.support.CouchDbDocument;

/**
 *
 * @author GBarnett
 */
public class Test extends CouchDbDocument {
    
    private String testClass;
	private List<String> categories = new ArrayList<String>();
	private List<TestResult> results = new ArrayList<TestResult>();
	private String description;

	public void addResult(TestResult tr) {
		results.add(tr);
	}
	
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<TestResult> getResults() {
		return results;
	}

	public void setResults(List<TestResult> results) {
		this.results = results;
	}

	public String getTestClass() {
		return testClass;
	}

	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
}
