package service;

import java.util.List;

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
		int result = dao.updateContact(contact);
		if(result > 0) {
			System.out.println("연락처가 수정되었습니다");
		} else {
			System.out.println("연락처 수정이 실패했습니다.");
		}
		

	}

	@Override
	public void deleteContact(int contact_no) {
		int result = dao.deleteContact(contact_no);
		if(result > 0) {
			System.out.println("연락처가 삭제되었습니다");
		} else {
			System.out.println("연락처 삭제가 실패했습니다.");
		}
		


	}

	@Override
	public void findContactByNo(int contact_no) {
		ContactDTO contact = dao.selectContactByNo(contact_no);
		if(contact == null) {
			System.out.println("조회된 연락처가 없습니다.");
		} else {
			System.out.println(contact);
		}

	}

	@Override
	public void findAllcontacts() {
		List<ContactDTO> contacts = dao.selectAllcontacts();
		if(contacts.isEmpty()) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			for(ContactDTO contact : contacts) {
				System.out.println(contact);
			}
		}

	}

}
