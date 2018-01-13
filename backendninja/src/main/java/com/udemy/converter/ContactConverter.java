package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.ContactEntity;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	 public ContactModel entityToModel (ContactEntity entity){
		 ContactModel model = new ContactModel();
		 model.setFirstname(entity.getFirstname());
		 model.setLastname(entity.getLastname());
		 model.setTelephone(entity.getTelephone());
		 model.setCity(entity.getCity());
		 
		 return model;
	 }
	
	 public ContactEntity modelToEntity (ContactModel model){
		 ContactEntity entity = new ContactEntity();
		 entity.setFirstname(model.getFirstname());
		 entity.setLastname(model.getLastname());
		 entity.setTelephone(model.getTelephone());
		 entity.setCity(model.getCity());
		 
		 return entity;
	 }
}
