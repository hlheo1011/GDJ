package com.gdu.contact.service;

import java.util.List;

import com.gdu.contact.domain.ContactDTO;

public interface ContactService {

	public List<ContactDTO> findAllContacts();
	public int findContactCount();
	public ContactDTO findContactByNo(int no);
	public int saveContact(ContactDTO contact);
	public int modifyContact(ContactDTO contact);
	public int removeContact(int no);
}
