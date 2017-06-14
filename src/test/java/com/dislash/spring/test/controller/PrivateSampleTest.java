package com.dislash.spring.test.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.dislash.spring.test.service.TestService;

@PrepareForTest(PrivateSample.class)
public class PrivateSampleTest {
	@Mock
	TestService service;
	@InjectMocks
	private PrivateSample instance;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void privateMethodTest() throws Exception {
		PrivateSample instance = PowerMockito.spy(new PrivateSample());
		PowerMockito.when(instance, "privateMethod", 1, "test").thenReturn(100);

		int r1 = instance.test(1);

		PowerMockito.verifyPrivate(instance, Mockito.times(1)).invoke("privateMethod", 1, "test");

		assertEquals(100, r1);
	}

	@Test
	public void testPrivateMethod() throws Exception {
		PrivateSample spy = PowerMockito.spy(new PrivateSample());
		PowerMockito.doReturn("Test").when(spy, "iAmPrivate");
		String value = spy.getDetails();

		assertEquals(value, "Mock private method example: Test");
		PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke("iAmPrivate");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void privateMethodExceptionTest() throws Exception {
		PowerMockito.when(service.getStr()).thenReturn("100");
		PowerMockito.when(instance, "privateMethod", 200, "test").thenThrow(new IndexOutOfBoundsException());
		//PowerMockito.verifyPrivate(instance, Mockito.times(1)).invoke("privateMethod", 200, "test");
	}
}
