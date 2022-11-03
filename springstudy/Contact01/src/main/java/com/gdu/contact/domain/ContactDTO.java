package com.gdu.contact.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDTO {
	private int no;
	private String name, tel, addr, email, note;

}
