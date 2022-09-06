package domain;

import java.sql.Date;

// 게시판 1개의 정보를 담을 수 있는 객체를 생성하는 클래스
// Bean, VO(ValueObject), DTO 등으로 불림

// 테이블의 칼럼을 1:1로 변수로 매칭(가급적 칼럼이름 = 변수이름
// 생성자, Getter/Setter

public class Board {
	
	private int board_no;
	private String title;
	private String content;
	private int hit;
	private Date create_date;

}
