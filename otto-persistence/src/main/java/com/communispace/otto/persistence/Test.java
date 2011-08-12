/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.persistence;

import com.communispace.otto.persistence.TestResult.Outcome;
import com.communispace.otto.persistence.TestResult.Reason;
import java.util.List;
import org.ektorp.support.CouchDbDocument;
import org.joda.time.DateTime;

/**
 *
 * @author GBarnett
 */
public class Test extends CouchDbDocument {
    
    private String testClass;
	private List<String> categories;
	private List<TestResult> results;
    
}
