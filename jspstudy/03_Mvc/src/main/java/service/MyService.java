package service;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MyService {
	// interface는 작업지시서이다.
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	

	
	

}
