package com.gdu.app07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app07.repository.BoardDAO;
import com.gdu.app07.service.BoardService;
import com.gdu.app07.service.BoardServiceImpl;

@Configuration
// BoardDAO에 @Repository 에너테이션 주석처리하면 아래처럼 코드를 짜줘야 실행 가능하다
// @Reoisutory를 하던가, Configuraitn을 만들어서 @Bean을 만들거나 둘중 하나만 해줘도 된다.
public class BoardAppContext {
	
	// 06_Jdbc의 @Repository 대신 추가한 Bean
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}
	
	// 06_Jdbc의 @Service 대신 추가한 Bean
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl(dao());
	}
	// BoardServiceImpl은 생성자를 만들때 DAO를 받아온다.

}
