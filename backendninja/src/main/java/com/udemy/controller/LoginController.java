package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constants.ViewConstants;
import com.udemy.model.UserCredential;

@Controller
public class LoginController {
	
	public static Log logger = LogFactory.getLog(LoginController.class); 

	@GetMapping("/")
	public String redirectLogin(){
		logger.info("[redirectLogin] redirigiendo a Login");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginForm(
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout)
	{
		logger.info("[showLoginForm] error="+error+", logout="+logout);
		
		ModelAndView mav = new ModelAndView(ViewConstants.LOGIN_VIEW);
		mav.addObject("userCredential", new UserCredential());
		mav.addObject("error", error);
		mav.addObject("logout", logout);
		return mav;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck (@ModelAttribute(name="userCredential") UserCredential userCredential){
		
		logger.info("[loginCheck] user="+userCredential.getUsername()+", password="+userCredential.getPassword());
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
			logger.info("[loginCheck] Redirigiendo a contactos");
			return "redirect:/contact";
		}
		logger.info("[loginCheck] Redirigiendo a login con error");
		return "redirect:/login?error";
	}
}

