package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
		// board_no라는 파라미터가 오기로 했는데, null이 올 수도 있으니까 Optional이라는걸로 감싸는거다.
		// board_no가 null일때 integer.parsInt를 사용하면, nullpointException오류가 떠서 사용하는 용도
		int board_no = Integer.parseInt(opt.orElse("0"));
		// 혹시 null이면(orElse) "0"으로 처리하게하는 코드
		// 전달 안됐을때 "0"을 만든 이유는, 0을 DAO측으로 전달하려고.
		//	- (0을 DAO측으로 전달하면 실행 결과는 0이다.)(삭제를 막기 위한 코드)
		//	- (개발자 취향에 따라 -9999 라고 쓸 수도 있다.)
		
		// DB로 board_no 보내서 삭제
		int result = BoardDao.getInstance().deleteBoard(board_no);
		
		// 삭제 성공/실패 여부 콘솔에 출력
		System.out.println("삭제 여부 : " + result);
		
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do");
		// 삭제 되었으면, 목록보기로 보내준다.
		// Redirect할 때는 매핑으로 이동하는게 기본이다.(특정 jsp로 이동하는게 아니다.)
		af.setRedirect(true);	// DELETE 했을때 Redirect 하겠다.(이게 기본)
		return af;
	}

}
