package com.dislash.spring.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dislash.spring.test.service.TestService;

public class PrivateSample {
	@Autowired
	TestService service;

	private int privateMethod(int i, String s) {
		System.out.println("test3=" + i);
		System.out.println(service.getStr());
		int result = 0;
		if (service.getStr().equals("200")) {
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
