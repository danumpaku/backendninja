package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/expost")
public class ExamplePostController {
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	private static final Log logger = LogFactory.getLog(ExamplePostController.class); 
	
	//forma 1 de redirigir
	@GetMapping("/")
	public String redirect (){
		return "redirect:/expost/showform";
	}
	
	//forma 2 de redirigir
	@GetMapping("")
	public RedirectView redirect2() {
		return new RedirectView("/expost/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
		logger.info("Entramos a showForm");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/add_person")
	public ModelAndView addPerson(@Valid @ModelAttribute ("person") Person persona, BindingResult result){
		
		ModelAndView mav; 
		
		if (result.hasErrors()){
			mav = new ModelAndView(FORM_VIEW);
		}
		else {
			mav = new ModelAndView(RESULT_VIEW);
			mav.addObject("person", persona);
		}
		
		return mav;
	}
}

