package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.CourseModel;
import com.udemy.service.impl.CourseServiceImpl;

@Controller
@RequestMapping("/courses")
public class CourseController {

	public static final String COURSES_VIEW = "courses";
	
	private static final Log logger = LogFactory.getLog(CourseController.class);
		
	@Autowired
	@Qualifier("CourseServiceImpl")
	private CourseServiceImpl courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses () {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		logger.info("[listAllCourses] Consultando cursos");
		mav.addObject("courses", courseService.listAllCourses());
		mav.addObject("cursoNew", new CourseModel());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse (@ModelAttribute("course") CourseModel course) {
		logger.info("[addCourse] Agregando curso: " + course);
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}
	
}
