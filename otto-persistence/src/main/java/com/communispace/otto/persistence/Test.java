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
	
	public static final int MAX_RESULTS_RETAINED = 14;

	public void addResult(TestResult tr) {
		while(results.size() >= MAX_RESULTS_RETAINED) {
			results.remove(0);
		}
		results.add(tr);
	}

        public List<TestResult> getLatestResults(int howMany) {
            
            int firstIndex = results.size() - howMany;
            return results.subList(firstIndex > 0 ? firstIndex : 0, results.size());
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
