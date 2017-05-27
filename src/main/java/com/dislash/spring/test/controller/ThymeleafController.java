package com.dislash.spring.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dislash.spring.test.exception.ForbiddenException;

@Controller
public class ThymeleafController {
	@RequestMapping(value = "/thytest", method = RequestMethod.GET)
	public String confirm(@ModelAttribute @Valid ModelRequest form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			throw new ForbiddenException();
		}
		model.addAttribute("target", "Japan");	
		return "thy";
	}
}
