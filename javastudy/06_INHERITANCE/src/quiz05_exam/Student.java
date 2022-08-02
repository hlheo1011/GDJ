package quiz05_exam;

public class Student{
	
	// 필드
	private String name;
	private Exam exam;				// exam에 점수를 채워주는 세터

	//생성자
	public Student(String name) {
		this.name = name;
	}	
	
	// get,set 메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {			// 실제 사용되는건 이 코드만 사용..(?)
		this.exam = exam;
	}
	
	// 메소드 info.
	public void info() {
		System.out.println("학생 이름:" + name);
		exam.examInfo();
	}
	
	

}
