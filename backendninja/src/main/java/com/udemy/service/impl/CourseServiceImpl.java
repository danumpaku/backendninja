package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service ("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log logger = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter converter;
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<CourseModel> listAllCourses() {
		logger.info("[listAllCourses] Consultando cursos");
		
		List<CourseModel> modelos = new ArrayList<>();
		List<Course> entidades = courseJpaRepository.findAll();
		
		for (Course c : entidades) {
			modelos.add(converter.toModel(c));
		}
		
		return modelos;
	}

	@Override
	public CourseModel addCourse(CourseModel course) {
		logger.info("[addCourse] Agregando curso: " + course);
		return converter.toModel(courseJpaRepository.save(converter.toEntity(course)));
	}

	@Override
	public int removeCourse(int id) {
		logger.info("[removeCourse] Eliminando curso: id=" + id);
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel course) {
		logger.info("[updateCourse] Modificando curso: " + course);
		return converter.toModel(courseJpaRepository.save(converter.toEntity(course)));
	}

}
