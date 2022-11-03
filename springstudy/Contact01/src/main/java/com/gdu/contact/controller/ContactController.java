package com.gdu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("contacts", contactService.findContactCount());
		return "list";
	}
	
	
	
	@GetMapping("con/add")
	public String add() {
		return "contact/add";
	}
	
	


}
