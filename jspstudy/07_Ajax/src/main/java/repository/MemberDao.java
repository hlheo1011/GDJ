package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;

public class MemberDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static MemberDao dao = new MemberDao();
	
	// 생성자를 외부에서 못만들게 private 생성자
	private MemberDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static MemberDao getInstance() {
		return dao;
	}	
	
	// method
	
	String mapper = "mybatis.mapper.member.";
	
	// 1. 회원목록
	public List<Member> selectAllMembers(){
		SqlSession ss = factory.openSession();
		List<Member> members = ss.selectList(mapper + "selectAllMembers");
		ss.close();
		return members;
	}
	
	// 2. 회원수
	public int selectAllMembersCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllMembersCount");
		return count;
	}
	
	// 3. 회원상세
	public Member selectMemberByNo(int memberNo) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne(mapper + "selectMemberByNo", memberNo);
		ss.close();
		return member;
	}
	
	// 4. 회원등록
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);	 // openSession할때 false 하는 이유는 내가 commit 하고 싶어서이다.
		int result = ss.insert(mapper + "insertMember", member);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	

}
