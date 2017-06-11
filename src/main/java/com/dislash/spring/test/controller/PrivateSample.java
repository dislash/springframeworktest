package com.dislash.spring.test.controller;

import java.util.Date;

public class PrivateSample {
	private int privateMethod(int i, String s) {
		System.out.println("test3=" + i);
		int result = 0;
		if (i == 200) {
			throw new IndexOutOfBoundsException();
		}
		// something
		return result;
	}

	public int test(int i) {
		System.out.println("test1=" + i);
		getDetails();
		return test2(i);
	}

	public String getDetails() {
		return "Mock private method example: " + iAmPrivate();
	}

	private String iAmPrivate() {
		return new Date().toString();
	}

	private int test2(int i) {
		System.out.println("test2=" + i);
		return privateMethod(i, "test");
	}
}
