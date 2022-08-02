package quiz05_exam;

public class Exam {

	private String examName;
	private int kor;
	private int eng;
	private int mat;
	
	public Exam(String examName) {
		this.examName = examName;
	}

	// setScore
	public void setScore() {
		kor = (int)(Math.random() * 101);	// 숫자가 0부터 100이면 101이라고 해야한다. 
		eng = (int)(Math.random() * 101);	// 0을 포함하니깐. 101개
		mat = (int)(Math.random() * 101);
	}

	public void examInfo() {
		System.out.println(examName + " 성적");
		System.out.println("국어:" + kor + ", 영어:" + eng + ", 수학:" + mat);
		int total = kor + eng + mat;
		System.out.println("총점:" + total + ", 평균:" + (total / 3.0));
	}
	
}
