package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exerr")
public class ExampleErrores {

	public static final String ERR404_VIEW = "404";
	public static final String ERR500_VIEW = "500";
	
	@GetMapping ("/err404")
	public ModelAndView show404 (){
		ModelAndView mav = new ModelAndView(ERR404_VIEW);
		return mav;
	}
	
	@GetMapping ("/err500")
	public ModelAndView show500 (){
		ModelAndView mav = new ModelAndView(ERR500_VIEW);
		return mav;
	}
	
}

