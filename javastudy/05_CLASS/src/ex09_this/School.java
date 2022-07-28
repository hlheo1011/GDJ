package ex09_this;

public class School {
	
	// 필드
	private Student[] students;
	private int idx;	// students 배열의 인덱스. students 배열에 저장된 학생수와 같다.
	
	// 생성자
	public School(int cnt) {
		students = new Student[cnt];
	}
	
	// 메소드
	public void addStudent(Student student) {
		if(idx == students.length) {
			System.out.println("Full");
			return;							// 메소드의 반환값이 void일때 종료하는 메소드는 return.
		}
		students[idx++] = student;	// students[idx++] > 사용 후에 증가 시킨다. student2로 넣기 위해.
	}

	public void printStudents() {
	/* 일반 for문
		for(int i = 0; i < idx; i++) {			// students.length가 아니라 idx. 학생 수 만큼 돌릴수 있게하기 위해서.
			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
			// 정보은닉에 의해 getName을 써야한다. 직접 호출이 불가능
		}
	}
	*/
	
	// 향상 for문
	for(Student student : students) {
		if(student != null) {
			System.out.println(student.getName() + ", " + student.getStuNo());
			}
		}
	}
	
}
