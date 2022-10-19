package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor	// 생성자
@AllArgsConstructor
@Builder
@ToString
public class Board {
	private int boardNo;
	// field이름을 db 칼럼 이름이랑 동일하게하기 위해서 boara_no로 해야하지만 myBatis가 알아서(?) 바꿔줌.
	// mapUnderscoreToCamelCase
	private String title;
	private String content;
	private Date createDate;
}
