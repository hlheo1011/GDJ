package com.gdu.app13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app13.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	// 만들어만 두면 interceptopr : true (를 반환하면 계획대로 진행됨) / false (를 반환하면 인터셉터발생한다음에 실행을 막음)
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/agree")
	public String agree() {
		return "user/agree";
	}
	
	@GetMapping("/user/join/write")
	public String joinWrite(@RequestParam(required=false) String location
					      , @RequestParam(required=false) String promotion
					      , Model model) {
		// String joinWrite() << 이 자리는 파라미터값, 필수인지 아닌지 확인
		// @RequestParma < 파라미터를 받아온다
		// required < 필수인가 아닌가? false=필수가 아님
		// String 이름 < 파라미터 name
		// Model = 스프링에서 jsp로 값을 넘겨줄때 쓰는 방식
		model.addAttribute("location", location);
		model.addAttribute("promotion", promotion);
		return "user/join";
	}
	
	@ResponseBody
	// @ResponseBody를 넣어놔야 ajax를 할 수 있다.
	@GetMapping(value="/user/checkReduceId", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> checkReduceId(String id){
		return userService.isReduceId(id);
	}
	
	@ResponseBody
	@GetMapping(value="/user/checkReduceEmail", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> checkReduceEmail(String email){
		return userService.isReduceEmail(email);
	}

	@ResponseBody
	@GetMapping(value="/user/sendAuthCode", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> sendAuthCode(String email){
		return userService.sendAuthCode(email);
	}
	
	@PostMapping("/user/join")
	public void join(HttpServletRequest request, HttpServletResponse response) {
		userService.join(request, response);
	}
	
	@PostMapping("/user/retire")
	public void retire(HttpServletRequest request, HttpServletResponse response) {
		userService.retire(request, response);
	}
	
	@GetMapping("/user/login/form")
	public String loginForm(HttpServletRequest request, Model model) {
		
		// 요청 헤더 referer : 이전 페이지의 주소가 저장
		model.addAttribute("url", request.getHeader("referer")); // 로그인 후 되돌아 갈 주소 url
		
		// 네이버 로그인
		model.addAttribute("apiURL", userService.getNaverLoginApiURL(request));
		
		return "user/login";
	}

	@PostMapping("/user/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		userService.login(request, response);
	}
	
	@GetMapping("/user/naver/login")
	public void naverLogin(HttpServletRequest request) {
		userService.getNaverLoginTokenNProfile(request);
	}
	
	
	
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		userService.logout(request, response);
		return "redirect:/";
	}
	
	@GetMapping("/user/check/form")
	public String requiredLogin_checkForm() {
		return "user/check";
	}
	
	
	@ResponseBody
	@PostMapping(value="/user/check/pw", produces="application/json")
	public Map<String, Object> requiredLogin_checkPw(HttpServletRequest request) {
		return userService.confirmPassword(request);
	}
	
	@GetMapping("/user/mypage")
	public String requiredLogin_mypage() {
		return "user/mypage";
		
	}
	
	@PostMapping("/user/modify/pw")
	public void requiredLogin_modifyPw(HttpServletRequest request, HttpServletResponse response) {
		userService.modifyPassword(request, response);
	}
	
	
	@GetMapping("/user/sleep/display")
	public String sleepDisplay() {
		return "user/sleep";
	}
	
	
	@PostMapping("/user/restore")
	public void restore(HttpServletRequest request, HttpServletResponse response) {
		// 응답을 다 만들어서 void 처리
		userService.restoreUser(request, response);
	}
	
	
	
	
	
}