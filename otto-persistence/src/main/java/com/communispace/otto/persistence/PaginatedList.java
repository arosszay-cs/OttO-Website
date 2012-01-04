package com.communispace.otto.persistence;

import java.util.List;

public class PaginatedList<T> {

	List<T> list;
	String nextPageStartKey;
	
	public PaginatedList(List<T> list, String nextPageStartKey) {
		this.list = list;
		this.nextPageStartKey = nextPageStartKey;
	}

	public List<T> getList() {
		return list;
	}

	public String getNextPageStartKey() {
		return nextPageStartKey;
	}
	
	
}
