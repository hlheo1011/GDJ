package com.gdu.app11.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpMapper {
	
	// 1. 전체 레코드 개수 구하기
	public int selectAllEmployeesCount();
	// employee.xml에서 받는 파라미터 없으니, 메소드 반환타입도 아무것도 없다.
	public List<EmpDTO> selectEmployeesByPage(Map<String, Object> map);
	public int selectFindEmployeesCount(Map<String, Object> map);
	public List<EmpDTO> selectFindEmployees(Map<String, Object>map);
	
}
