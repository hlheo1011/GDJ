package service;

import domain.ContactDTO;

public interface ContactService {
	public void addContact(ContactDTO contact);
	public void modifyContact(ContactDTO contact);
	public void deleteContact(int contact_no);	// 지울때는 연락처를 받아 올 필요가 없고, PK + UNIQUE인 전화번호만 받아오면 된다.
	public void findContactByNo(int contact_no);
	public void findAllcontacts();
	public void createContactFile();
	

}
