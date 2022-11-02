package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.GalleryService;

@Controller
public class MyController5 {
	
	
	@GetMapping("gallery")	// 반환이 void인 경우 mapping을 뷰(JSP)로 인식한다.
	public void gallery() {
		
	}
	
	
	@Autowired
	private GalleryService GalleryService;
	
	
	
	@ResponseBody
	// ResponseEntity를 응답하기 위해서는 ResponseBody가 반드시 필요하다.
	@GetMapping("image/display")
	public ResponseEntity<byte[]> display(@RequestParam String path, @RequestParam String filename) {
		return GalleryService.imageDisplay(path, filename);
	}
	

}
