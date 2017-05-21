package com.dislash.spring.test.controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ModelRequest {
	@NotEmpty
    private String firstParam;

	@NotEmpty
	@Size(min=1,max=16)
	@Pattern(regexp="[a-zA-Z0-9]*")
    private String secondParam;
}
