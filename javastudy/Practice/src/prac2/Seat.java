package prac2;

public class Seat {

	private String name;	// 시트 예약한 사람 이름
	
	// 예약한 사람의 이름이 들어가야하기 떄문에 생성자를 만들 필요는 없다.

	// 예약한 사람 확인
	public String getName() {
		return name;
	}
	
	// 예약한 사람 설정
	public void reserve(String name) {
		this.name = name;
	}
	
	// 예약 취소
	public void cancle() {
		name = null;
	}
	
	// 예약 여부 확인
	public boolean isOccupied() {
		return name != null;	// null이 아니면 true 반환 (=예약 되어있으면 true 반환)
	}
	
	// 예약자 확인
	public boolean isMatched(String name) {
		return name.equals(this.name);
		// 받아온 이름과 저장된 이름이 일치 하는가 ?
	}
	
}
