package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app12.mapper.BbsMapper;
import com.gdu.app12.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service	// Bean으로 등록하기위해 @Service를 써준다.
public class BbsServiceImpl implements BbsService {

	private BbsMapper bbsMapper;
	private PageUtil pageUtil;
	// 필드가 여러개일때(2개 이상)는 @Autowired보다 @AllArgsConstrutor를 입력해주면 생성자를 이용해 주입해준다.
	
	
	@Override
	public void findAllBbsList(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addBbs(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addReply(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
