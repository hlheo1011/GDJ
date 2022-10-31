package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Mycontroller {
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value="/hooray", method=RequestMethod.POST)
	
	public String hooray() {
		return "";
	}
}
