package com.udemy.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.ContactEntity;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.services.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository repository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter converter;
	
	@Override
	public ContactModel addContact(ContactModel Contact) {
		return converter.entityToModel(repository.save(converter.modelToEntity(Contact)));
	}

	@Override
	public List<ContactModel> getAllContacts() {
		List<ContactModel> contacts = new ArrayList<>();
		
		for (ContactEntity entity : repository.findAll()){
			contacts.add(converter.entityToModel(entity));
		}
		
		return contacts;
	}

	@Override
	public ContactModel findContactById(int id) {
		return converter.entityToModel(repository.findById(id));
	}

	@Override
	public ContactModel removeContact(int id) {
		ContactEntity entity = repository.findById(id);
		if (entity != null) {
			repository.delete(entity);
		}
		
		return converter.entityToModel(entity);
	}

	
	
}
