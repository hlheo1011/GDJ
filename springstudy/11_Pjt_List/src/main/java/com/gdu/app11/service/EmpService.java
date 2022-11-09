package com.gdu.app11.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {
	
	// 목록을 받는 파라미터는
	// Request,Response Session, Model을 최초 *선언* 할 수 있는것은 Controller 이다.
	// Service은 받아다가 쓰는것이다.
	public void findAllEmployees(HttpServletRequest request, Model model);
	public void findEmployees(HttpServletRequest request, Model model);
	

}
