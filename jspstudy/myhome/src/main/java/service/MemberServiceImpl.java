package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Member;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {

	@Override
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.build();
		
		Member login = MemberDao.getInstance().login(member);
		
		// login != null >> null이 아니다. 로그인 성공
		if(login != null) {
			// page를 바꿔도 정보가 남아있는 Session에 저장! (브라우저 닫기전 까지 정보가 유지 됨)
			HttpSession session = request.getSession();
			session.setAttribute("login", login); 	// 저장하는 장소? 저장 명 ?
			return new ActionForward(request.getContextPath(), true);	// 리다이렉트
		} else {
			try {
				PrintWriter out = response.getWriter();	// response 자체가 이동이다. 
				out.println("<script>");
				out.println("alert('로그인 실패');");	// 메세지를 만들었으면 꼭(페이지 이동을 했으니)
				out.println("history.back()");			// (백)이동도 가져다가 붙여야 한다. 안그러면 이동이 제대로 안 된다.
				out.println("</script>");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null; // 컴파일러는 history.back()을 했기때문에 이동한다는걸 모르기 때문에 return값을 줘야 한다.
		}
	}

	@Override
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate(); 	// 세션의 초기화. (세션초기화는 실패할 일이 없다.)
		return new ActionForward(request.getContextPath(), true);	// request의 getContextPath를 리다이렉트 한다.

	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
