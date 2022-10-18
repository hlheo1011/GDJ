package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor	// 필드를 이용한 생성자
@Getter				// Getter
@Setter				// SEtter
@Builder			// builder 패턴
@ToString
public class Board {
	private int board_no;
	private String title;
	private String content;
	private Date create_date;
}
