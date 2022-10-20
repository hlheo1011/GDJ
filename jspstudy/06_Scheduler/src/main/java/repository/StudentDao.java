package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StudentDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static StudentDao dao = new StudentDao();
	
	// 생성자를 외부에서 못만들게 private 생성자
	private StudentDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static StudentDao getInstance() {
		return dao;
	}	
	
	// method
	
	String mapper = "mybatis.mapper.student.";
	
	// 1. 학생목록
	public List<Student> selectAllStudents() {
		SqlSession ss = factory.openSession();
		List<Student> students = ss.selectList(mapper + "selectAllStudents");
		ss.close();
		return students;
	}
	
	// 2. 전체학생수
	public int selectAllStudentsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllStudentsCount");
		ss.close();
		return count;
	}
	
	// 3. 전체평균
	public double selectAllStudentAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectAllStudentAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생등록
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertStudent", student);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 5. 평균범위조회
	public List<Student> selectStudentsByAve(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		List<Student> students = ss.selectList(mapper + "selectStudentsByAve", map);
		ss.close();
		return students;
	}
	
	// 6. 평균범위조회 : 개수
	public int selectStudentsByAveCount(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectStudentsByAveCount", map);
		ss.close();
		return count;
	}
	
	// 7. 평균범위조회 : 평균
	public double selectStudentsByAveAverage(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectStudentsByAveAverage", map);
		ss.close();
		return average;
	}
	
	// 8. 학생삭제
	public int deleteStudent(int stuNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteStudent", stuNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	

}
