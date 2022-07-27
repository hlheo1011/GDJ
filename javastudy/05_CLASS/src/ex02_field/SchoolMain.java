package ex02_field;

public class SchoolMain {

	public static void main(String[] args) {

		School school = new School();
		school.name = "경인중학교";
		
		Student student1 = new Student();
		student1.stuNo = "123";
		student1.name = "홍길동";
		
		Student student2 = new Student();
		student2.stuNo = "567";
		student2.name = "가나다";
		
		school.students[0] = student1;
		school.students[1] = student2;
		
		for(int i = 0; i < school.students.length; i++) {
			System.out.print(school.students[i].stuNo);
			System.out.print(school.students[i].name);
		}
		
		
		
		/*
		School school = new School();
		
		school.name = "경인중학교";
		
		// 학생은 둘 만들고, 스쿨에 저장하기		
		Student student1 = new Student();
		student1.stuNo = "11025";
		student1.name = "전지현";
		
		Student student2 = new Student();
		student2.stuNo = "11026";
		student2.name = "정우성";
		
		school.students[0] = student1;					//첫번쨰 자리에
		school.students[1] = student2;					//두번째 자리에

		for(int i = 0; i < school.students.length; i++) {
			System.out.println(school.students[i].stuNo);
			System.out.println(school.students[i].name);
		}
		
		*/
		

	}

}
