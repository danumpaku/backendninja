package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.components.ExampleComponent;
import com.udemy.service.impl.ExampleServiceImple;


@Controller
@RequestMapping("/exget")
public class ExampleGetController {

	public static final String EX_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleServiceImple exServicio;
		
	//En spring 4.3 o mas GetMapping reemplaza a @RequestMapping(value = , method = RequestMethod.GET)
	//primera forma
	@GetMapping("/exStr")
	public String exampleString (Model model){
		exComponent.sayHello();
		model.addAttribute("people", exServicio.getListPeople());
		return EX_VIEW;
	}
	
	//segunda forma
	@GetMapping("/exMav")
	public ModelAndView exampleMav (){
		ModelAndView mav = new ModelAndView(EX_VIEW);
		mav.addObject("people", exServicio.getListPeople());
		return mav;
	}
	
}
