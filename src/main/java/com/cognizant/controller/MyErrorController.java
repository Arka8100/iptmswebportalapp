package com.cognizant.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * extends ErrorController - a Marker interface used to identify a @Controller
 * that should be used to render errors.
 */
@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {

		return "error";
	}

	@Override
	public String getErrorPath() {
		return null;
	}
}