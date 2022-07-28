package ex09_this;

public class SchoolMain {

	public static void main(String[] args) {

		/*
		System.out.println(student);
		student.printThis();
		student는 this랑 같다
		*/		
		Student student1 = new Student();
		student1.setStuNo("11025");
		student1.setName("전지현");
		
		Student student2 = new Student("11026", "정우성");
		
		School school = new School(2);
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student1);	// full
		school.printStudents();	// 전지현, 11025 / 정우성, 11026

		
		// 항상 저장이 꽉 찼을때 full인지,
		// 비었을 때 empty인지 알아야 한다.
		
	}

}
