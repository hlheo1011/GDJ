package com.gdu.app05.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mycontroller3 {
	
	@GetMapping("movie")
	public String movie() {
		return "movie";
	}

}
