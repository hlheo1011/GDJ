package domain;

import lombok.Builder;
import lombok.Data;

@Data
// @data에 게터 세터 toString 들어있음.
@Builder
// @data, Builder가 뭘 만들었는지 궁금하면 상단 바에서 Window - Show view - Outline을 참고
public class Member {
	private int memberNo;
	private String id, pw, name, email, registedDate;
}
