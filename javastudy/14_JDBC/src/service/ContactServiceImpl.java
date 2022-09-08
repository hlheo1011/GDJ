package service;

import domain.ContactDTO;
import repository.ContactDAO;

public class ContactServiceImpl implements ContactService {

	/************** Field  **************/
	
	// DAO에 데이터를 전달하고, DAO로부터 결과를 반환 받기 위해서 DAO를 선언
	private ContactDAO dao = ContactDAO.getInstance(); // singleton 패턴이기 때문에 이렇게 호출항야 한다.
	
	
	/************** Method **************/
	
	@Override
	public void addContact(ContactDTO contact) {
		int result = dao.insertContact(contact); // 2. addContact로 도착 3. contact 출발 > ContactDAO클래스의 4. insertContact로 도착
		if(result > 0) {
			System.out.println("연락처가 등록되었습니다");
		} else {
			System.out.println("연락처 등록이 실패했습니다.");
		}
		

	}

	@Override
	public void modifyContact(ContactDTO contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContact(int contact_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findContactByNo(int contact_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAllcontacts() {
		// TODO Auto-generated method stub

	}

}
