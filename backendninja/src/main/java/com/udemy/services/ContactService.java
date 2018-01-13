package com.udemy.services;

import java.util.List;

import com.udemy.model.ContactModel;

public interface ContactService {
	
	public ContactModel addContact(ContactModel contact);
	
	public List<ContactModel> getAllContacts ();
	
	public ContactModel findContactById (int id);
	
	public ContactModel removeContact(int id);
	
}
