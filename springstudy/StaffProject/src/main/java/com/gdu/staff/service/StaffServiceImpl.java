package com.gdu.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {
	
	// 나는 mapper가 필요하다.
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<StaffDTO> getStaffList() {
		return staffMapper.selectStaffList();
	}
	
	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {
		// staff에 salary 넣기 : 기획부 1000, 개발부 2000, 영업부 3000, 나머지 4000
		
		try {
			if(staff.getDept().equals("기획부")) {
				staff.setSalary(5000);
			} else if(staff.getDept().equals("개발부")) {
				staff.setSalary(6000);			
			} else if(staff.getDept().equals("영업부")) {
				staff.setSalary(7000);			
			} else {
				staff.setSalary(4000);
			}
			
			staffMapper.insertStaff(staff);
			return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK);
			// index.jsp의 ajax의 success로 넘어감
		} catch(Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
			// index.jsp의 ajax의 error로 넘어감
		}

	}
	
	@Override
	public StaffDTO getStaffListByOne(String sno) {
		return staffMapper.selectStaffByOne(sno);
	}
	
	

}
