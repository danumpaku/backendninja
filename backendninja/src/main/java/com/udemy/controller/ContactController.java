package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constants.ViewConstants;
import com.udemy.model.ContactModel;
import com.udemy.services.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	private static final Log logger = LogFactory.getLog(ContactController.class); 

	@Autowired
	@Qualifier("contactService")
	private ContactService service;
	
	@GetMapping("")
	private String showContacts(Model model, @RequestParam(name="success", required=false) String success, @RequestParam(name="fail", required=false) String fail){
		logger.info("[showContacts] Mostrando contactos	");
		model.addAttribute("contactos", service.getAllContacts());
		
		if (success != null)
			model.addAttribute("result", 1);
		else if (fail != null)
			model.addAttribute("result", 0);
		
		return ViewConstants.CONTACTS_VIEW;
	}
	
	@GetMapping("/contactform")
	private String showContactForm(Model model){
		logger.info("[showContactForm] Mostrando formulario de creacion de contactos");
		model.addAttribute("contactNew", new ContactModel());
		return ViewConstants.CONTACT_FORM_VIEW;
	}
	
	@PostMapping ("/addcontact")
	private String addContact (Model model, @ModelAttribute(name="contactNew") ContactModel contact){
		logger.info("[addContact] Agregando Contacto");
		ContactModel added = service.addContact(contact);
		if (added != null)
			return "redirect:/contact?success";
		else 
			return "redirect:/contact?fail";
	}
}
