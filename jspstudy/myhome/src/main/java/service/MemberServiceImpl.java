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
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email)
				.build();
		
		int result = MemberDao.getInstance().insertMember(member);
			
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(result > 0) {
				// 회원가입하면 로그인 처리
				// 세션에 저장하기로 했던 이름은 똑같이 맞춰야 한다.
				// 회원가입한 회원의 정보를 DB에서 가져온 뒤 session에 login이라는 이름으로 올리기
				// 로그인 할때 저장했던 메소드login() 에 member를 준다.
				HttpSession session = request.getSession();
				session.setAttribute("login", MemberDao.getInstance().login(member));
			
				
				out.println("alert('환영합니다.');");
				out.println("location.href='" + request.getContextPath() + "';");	// contextPath로 이동하라는건 첫 페이지로 이동하라는 뜻 이다.
			} else {
				out.println("alert('회원 가입에 실패했습니다.');");
				out.println("history.back()");
			}
			out.println("</script>");
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
				
	
	}

	@Override
	public void cancel(HttpServletRequest request, HttpServletResponse response) {
		// request에 Session(안에 login이 있다. 로그인 안에는 회원번호 이름 등등등등 다 들어 있다.)
		// parameter 안받아도 괜찮다. Session은 지워지지 않는 정보라고 생각하자. (logout or 브라우저 닫았을때 or 세팅된 시간 에만 지워진다.)
		
		// session에 저장된 login 정보를 이용에서 탈퇴할 회원의 정보를 추출
		HttpSession session = request.getSession();
		Member login = (Member)session.getAttribute("login"); // 캐스팅 필수
		int memberNo = login.getMemberNo();
		
		int result = MemberDao.getInstance().deleteMember(memberNo);
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(result > 0) {
				// 탈퇴 성공하면 session 초기화
				session.invalidate();				
				out.println("alert('이용해 주셔서 감사합니다.');");
				out.println("location.href='" + request.getContextPath() + "';");
			} else {
				out.println("alert('회원 탈퇴에 실패했습니다.');");
				out.println("history.back()");
			}
			out.println("</script>");
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		

	}

}
