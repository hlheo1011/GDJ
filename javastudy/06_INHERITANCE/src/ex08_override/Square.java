package ex08_override;

public class Square extends Rectangle {
	
	// 직사각형(부모가) 이미 필드값을 가지고 있어서(높이, 넓이), 자식에는 필드가 필요 없다.
	// 그래서 생성자를 자동으로 만들어 줄 수가 없다.
	// 이런 경우에는 Source탭에서 Generate Constructor from SuperClass를 생성해 줘야한다.
	// 필드값을 써 줄 필요가 없기 때문에.
	// 위와 같은 생성자는 자주 쓸 일은 없다 100%중 5% 정도.
	
	public Square(String type, double height) {	// 높이만 받아와서 그 높이를 슈퍼클래스의 너비와 높이로 사용.
		super(type, height, height);
	}
	
	// 사각형이 가지고 있는 인포를 쓰면 됨.
}
