package com.dislash.spring.test;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextObserver implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	MessageSource messages;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("test111");
		// TODO log
		System.out.println("message:"
				+ messages.getMessage("test1", new String[] { "do111" }, Locale.getDefault()));
	}

}
