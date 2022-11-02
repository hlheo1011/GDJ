package com.gdu.app06.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.app06.domain.BoardDTO;


/*

	@Repository
	안녕. 난 DAO에 추가하는 @Componet 야
	servlet-context.xml에 등론된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.

*/

@Repository		// DAO가 사용하는 전용 @Component로 트랜잭션 기능이 추가되어 있어.
// @Componet가 동작하는 이유는 WEB-INF - spring - servlet-context.xml > 24번째 줄에 있어서 사용 가능하지만
// DAO 같은 경우는 @Repository를 사용
// @Componet는 Bean하고 Config를 안만들어도 된다.
public class BoardDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// private 메소드
	// 이 메소드는 BoardDAO에서만 사용한다.
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	private void close() {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 레파지도리 계층 이름은 "DB 친화적으로" 작성
	
	public List<BoardDTO> selectAllBoards(){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		try {
			con = getConnection();
			sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {	// next한번당 한회 호출
				BoardDTO board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				boards.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return boards;
	}
	
	public BoardDTO selectBoardByNo(int board_no) {
		BoardDTO board = null;
		
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		int result = 0;
		
		return result;
	}
	
	public int updateBoard(BoardDTO board) {
		int result = 0;
		
		return result;
	}
	
	public int deleteBoard(int board_no) {
		int result = 0;
		
		return result;
	}
}
