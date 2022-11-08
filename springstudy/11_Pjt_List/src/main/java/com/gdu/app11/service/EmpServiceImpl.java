package com.gdu.app11.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public void findAllEmployees(HttpServletRequest request, Model model) {
		// request를 받아오는 이유는 parameter가 있어서이다. (page 라는 파라미터가 있어서)
		// Model은 명단 저장하려고 가져오는 것이다.
		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		
		int totalRecord = empMapper.selectAllEmployeesCount();	// 1. 전체 개수
		

		// db에서 rownum 기준으로 정렬한다.
		int recordPerPage = 10;
		int begin = (page - 1) * recordPerPage + 1;
		int end = begin + recordPerPage - 1;
		if(end > totalRecord) {
			end = totalRecord;
		}
		
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(begin, end);
		
		model.addAttribute("employees", employees);
		// list.jsp로 넘김
	}

}