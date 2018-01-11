package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exget2")
public class ExampleGet2Controller {
	
	private static final String EX2_VIEW = "example2";
	
	//localhost:8080/ex2/request1?nm=Dan
	@GetMapping("/request1")
	public ModelAndView request1 (@RequestParam(name="nm", required=false, defaultValue="Tu") String name){
		ModelAndView mav = new ModelAndView(EX2_VIEW);
		mav.addObject("nameInModel", name);
		return mav;
	}
	
	//localhost:8080/ex2/request2/Dan
	@GetMapping("/request2/{nm}")
	public ModelAndView request2 (@PathVariable(name="nm", required=false) String name){
		ModelAndView mav = new ModelAndView(EX2_VIEW);
		mav.addObject("nameInModel", name);
		return mav;
	}
}
