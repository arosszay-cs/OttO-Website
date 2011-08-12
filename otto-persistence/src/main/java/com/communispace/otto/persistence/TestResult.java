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
    
    public enum Outcome {
        SUCCESS,
        FAILURE,
        INCONCLUSIVE
    }
    
    public enum Reason {
        BUG,
        TIMING,
        SCRIPTING
    }
    
	// from nunit:
	private DateTime dateExecuted;
    private Outcome outcome;
    private int duration;    
	
	// from humans:
    private Reason reason;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
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
        
}
