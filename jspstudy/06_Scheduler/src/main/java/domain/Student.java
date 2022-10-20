package domain;

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
public class Student {
	private int stuNo;
	// field이름을 db 칼럼 이름이랑 동일하게하기 위해서 stu_no로 해야하지만 myBatis가 알아서(?) 바꿔줌.
	// mapUnderscoreToCamelCase
	private String name;
	private int kor, eng, math;
	private double ave;
	private String grade;
}
