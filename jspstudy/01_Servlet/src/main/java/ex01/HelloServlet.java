package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	Servlet
 	
 	1. 웹 화면을 만드는 자바 클래스
 	2. JSP/Servlet Container(Tomcat)에 의해서 실행
 	3. 서블릿을 실행하면 웹 브라우저가 실행됨
 	4. URL
 		프로토콜://호스트:포트번호/컨텍스트패스/URLMapping
 		http://localhost:9090/01_Servlet/HelloServlet
 		- 호스트:포트번호 = 같은 Tomcat
 		- 컨텍스트패스 = 동일한 프로젝트 번호(컨텍스트패스가 같다는건 같은 프로젝트 번호다)
 		- URLMapping(내가 바꾸지 않는 한 서블릿 이름과 같다) = 어떤 서블릿이다 (URL이 다르면, 서블릿이 다르다)
 		- 새로고침을 해도 주소가 바뀌지 않으니, 주소 바꾸면 재시작을 해야 한다.
 	
 	
 */
@WebServlet("/HelloServlet")	// URL Mapping
public class HelloServlet extends HttpServlet {	// Servlet은 HttpServlet을 상속 받으면 된다.
	
	private static final long serialVersionUID = 1L;
       
    /*
     	1. 생성자
     		1) 가장 먼저 호출
     		2) 생성자 호출 뒤 init() 메소드가 호출
     */
    public HelloServlet() {
        super();
        System.out.println("생성자");
    }

	/*
	 	2. 초기화
	 		1) 각종 초기화 정보 실행
	 		2) 서블릿 환경 설정 처리
	 		3) init() 메소드 호출 뒤 service() 메소드 호출
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	/*
		3. 서비스
			1) 클라이언트의 요청마다 매번 호출
			2) GET 방식의 요청은 doGet() 메소드 호출, POST 방식의 요청은 doPost() 메소드 호출
			
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		System.out.println("service");
		
		// service 메소드가 존재하는 경우 doGET()//doPost()가 자동으로 호출되지 않기 때문에
		// 코드를 직접 작성
		
		// 요청 메소드(GET/POST) 확인 : request.getMethod()
		switch(request.getMethod()) {
		case "GET":
			doGet(request, response); // doGet() 메소드 호출
			break;
		case "POST":
			doPost(request, response);	// doPost() 메소드 호출
			break;
		}
	}

	/*
	 	4. doGet
	 		1) GET 방식의 요청을 처리
	 		2) 요청 메소드가 GET인 경우
	 			(1) $.ajax({
	 					'type': 'GET',
	 					'url': '/01_Servlet/HelloServlet'    						    // /컨텍스트패스/URLMapping을 써 주면 된다.
	 				});
	 			(2) <a href="http://localhost:9090/01_Servet/HelloServlet">링크</a> 	// a태그로 넘어오면 무조건 GET 방식이다.
	 			(3) <form methode="GET"> 또는 <form>									// form태그로 넘어오면 무조건 GET 방식이다. 메소드는 생략 가능하므로 form태그만 써도 됨.
	 			(4) location.href='http://localhost:9090/01_Servet/HelloServlet'
	 				open('http://localhost:9090/01_Servet/HelloServlet')
	 			// 주소창을 이용해서 요청하는건 무조건 GET 방식이다.
	 		
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		// response : 사용자에게 전달할 때 사용
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// response : 서버가 사용자에게 보내주는 것. request : 사용자가 서버로 보내는 것
		
	}

	/*
	 	5. doPost
	 		1) POST 방식의 요청을 처리
	 		2) 요청 메소드가 POST인 경우
	 			(1) $.ajax({
	 					'type': 'POST',
	 					'url': 'http://localhost:9090/01_Servet/HelloServlet',
	 				});
	 			(2) <form method="POST" action="http://localhost:9090/01_Servet/HelloServlet"
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청과 응답 정보를 doGet() 메소드로 넘겨 버림
		// Get으로 요청하면 Get일하고 Post로 요청해도 Get이 일한다.
		
		doGet(request, response);	// doGet() 메소드 호출
		
		// 서블릿 실행은 톰캣이 한다
	}

}
