package com.dislash.spring.test.controller;

import java.util.Date;

public class PrivateSample {
	private int privateMethod(int i, String s) {
		int result = 0;
		if(i == 200) {
			throw new IndexOutOfBoundsException();
		}
		// something
		return result;
	}

	public int test(int i) {
		getDetails();
		return privateMethod(i, "test");
	}

	public String getDetails() {
		return "Mock private method example: " + iAmPrivate();
	}

	private String iAmPrivate() {
		return new Date().toString();
	}
}
