package com.dislash.spring.test.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dislash.spring.test.service.TestService;

@Controller
public class TestController {
	@Autowired
	MessageSource messages;
	
	@Autowired
	TestService service;
	
	@RequestMapping(value="/doSomething", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> dosomething(@Valid @ModelAttribute ModelRequest modelRequest, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	if(result.hasFieldErrors()) {
	    		//TODO log
	    		System.out.println("message:" + messages.getMessage("test1", new String[]{modelRequest.toString()}, Locale.getDefault()));
	    		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
	    	}
	    }
	    return new ResponseEntity<String>(HttpStatus.OK);
	}
}