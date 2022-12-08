package com.gdu.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		
		try {
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("insertResult", memberMapper.insertMember(member));
			return result;
			
		} catch(Exception e) {	// DuplicateKeyException 같은 이름 오류
			
			System.out.println(e.getClass().getName()); // (e.getClass,getName = )예외 클래스의 이름이 나온다
		}
		
		return null;
	};

}
