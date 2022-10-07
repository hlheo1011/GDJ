package prac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Prac03A")


public class Prac03A extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String content = request.getParameter("content");
		
		// 파일명
		String filename = new Date(System.currentTimeMillis()) + "-" + from + ".txt";
		
		// 디렉터리 생성
		File dir = new File(request.getServletContext().getRealPath("storage"));
		// request = 요청
		// getServletContext() = /01_Servlet
		// getRealPath = 톰캣의 진짜 경로 (C:\GDJ\jspstudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01_Servlet\storage)
		// 서버 중지를 해도 파일 삭제되진 않는다. 컨텍스트를 지웠을때 삭제 된다.
		
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 파일 객체
		File file = new File(dir, filename);
		
		// 문자 출력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 출력
		bw.write("To. " + to + "\n");
		bw.write(content + "\n");
		bw.write("From. " + from + "\n");
		bw.close();
		
		// 이동
		response.sendRedirect("/01_Servlet/Prac03B?filename=" + URLEncoder.encode(filename, "UTF-8"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}