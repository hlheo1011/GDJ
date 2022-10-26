package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MemberService {
	public ActionForward login(HttpServletRequest request, HttpServletResponse response);
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response);
	public void register(HttpServletRequest request, HttpServletResponse response);
	public void cancel(HttpServletRequest request, HttpServletResponse response);
	// 서비스 인터페이스는 실무에서는 안만든다.
	// 내가 만드는게 아니라, 만들어져있는 작업지시서가 있다.
	// 물론 만들어야 되는 경우도 있다.
	
	
}
