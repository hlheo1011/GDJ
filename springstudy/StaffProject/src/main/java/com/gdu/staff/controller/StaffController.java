package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {
	
	// 나는 Service가 필요하다.
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping(value="/list.json", produces="application/json; charset=UTF-8")
	public List<StaffDTO> getList() {
		return staffService.getStaffList();
	}
	
	@ResponseBody
	@PostMapping(value="/add", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add(HttpServletRequest request) {
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		StaffDTO staff = new StaffDTO(sno, name, dept, 0);
		return staffService.addStaff(staff);
	}
		
	// add를 할 수 있는 3가지 방법. 위 코드와 아래 2개의 코드는 같은 코드다.
	/*
	public ResponseEntity<String> add(@RequestParam(value="sno") String sno
									, @RequestParam(value="name", required=false) String name
									, @RequestParam(value="dept") String dept) {
		StaffDTO staff = new StaffDTO(sno, name, dept, 0);
		return staffService.addStaff(staff);
		
	}
	public ResponseEntity<String> add(StaffDTO staff) {
		return staffService.addStaff(staff);		
	}
	*/
		
	
	@ResponseBody
	@GetMapping(value="/listbyone.json", produces="application/json; charset=UTF-8")
	public StaffDTO getListByOne(HttpServletRequest request) {
		String sno = request.getParameter("sno");
		return staffService.getStaffListByOne(sno);
	}
	
	

}
