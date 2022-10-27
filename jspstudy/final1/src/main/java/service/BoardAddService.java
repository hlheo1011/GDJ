package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		
		int result = BoardDao.getInstance().insertBoard(board);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삽입 성공');");
			out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('삽입 실패');");		
			out.println("history.back();");
			out.println("</script>");
		}

		return null;
		
	}

}
