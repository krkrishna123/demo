package com.bikkadit.service;

import com.bikkadit.dao.ContactDaoI;

public class ContactServiceImpl implements ContactServiceI{

	private ContactDaoI contactDaoI;


	public void setContactDaoI(ContactDaoI contactDaoI) {
		this.contactDaoI = contactDaoI;
	}
	
	public String getNameById(Integer id) {
		
		String name=contactDaoI.findNameById(id);
		   String formattedname=name.toUpperCase();
		return formattedname ;
		
	}
	
}
