/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.otto.persistence;

import org.joda.time.DateTime;

/**
 *
 * @author GBarnett
 */
public class TestResult {
   
	// from nunit:
	private DateTime dateExecuted;
    private Outcome outcome;
    private double duration; 

	private String message;
	private String stackTrace;
	
	// from humans:
    private Reason reason;

	 
    public enum Outcome {
        SUCCESS,
        FAILURE,
        INCONCLUSIVE,
		NOT_RUN
    }
    
    public enum Reason {
        BUG,
        TIMING,
        SCRIPTING
    }
    


	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}

	public DateTime getDateExecuted() {
		return dateExecuted;
	}

	public void setDateExecuted(DateTime dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
      

	
}
