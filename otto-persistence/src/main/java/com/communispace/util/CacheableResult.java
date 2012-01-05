/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communispace.util;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Returns a cached version of an object if it's younger than a certain time 
 * period.
 * 
 * Otherwise, goes and retrieves it.
 * 
 * @author gb
 */
public abstract class CacheableResult<T> {

	private T result;
	private Duration freshnessDuration;
	private DateTime lastResultRetrieval;

	public CacheableResult(Duration freshnessDuration) {
		this.freshnessDuration = freshnessDuration;
	}

	protected abstract T retrieveFreshResult();

	public T getResult() {

		if (result != null
				&& new Duration(lastResultRetrieval, new DateTime()).isShorterThan(freshnessDuration)) {
			return result;
		}

		synchronized (this) {

			// we might have been blocked - check again before 
			// incurring the retrieval

			if (result != null
					&& new Duration(lastResultRetrieval, new DateTime()).isShorterThan(freshnessDuration)) {
				return result;
			}

			lastResultRetrieval = new DateTime();
			result = retrieveFreshResult();
		}

		return result;
	}
}