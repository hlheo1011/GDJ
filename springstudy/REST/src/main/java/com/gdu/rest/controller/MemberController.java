package com.gdu.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	// location.href=request.getContextPath > location.href='/'
	// 파일업로드는 C:\\ D:\\ 경로 다 빼야함..
	
	@GetMapping("/member/handle")
	public String memberHandel() {
		return "member/handle";
	}
	
	

}
