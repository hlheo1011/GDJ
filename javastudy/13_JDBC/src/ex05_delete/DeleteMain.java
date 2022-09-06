package ex05_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import domain.Board;

public class DeleteMain {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			// 삭제할 게시글 번호 입력 받기
			System.out.print("삭제할 게시글 번호 >>> ");
			int board_no = sc.nextInt();
			sc.nextLine();			
			
			
			// Connection 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
					
			
			// 쿼리문 생성
			String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
			
			// PreparedStatment 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문에 ?에 변수 전달하기
			ps.setInt(1, board_no);
			
			// 쿼리문 실행 (고정 명령어)
			int result = ps.executeUpdate();
			
			// 실행 결과
			// 삭제 성공, 삭제 실패
			if(result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			/*
			DELETE에서는 아래 코드를 사용 할 필요가 없다.
			INSERT나 UPDATE는 행(ROW)를 하나로 모아줘야하는데,
			DELETE는 모아 줄 필요가 없기 때문.
			GETTER/SETTER 때문이 아님.
			Board board = new Board();
			board.setTitle(title);
			board.setContent(content);
			*/
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
