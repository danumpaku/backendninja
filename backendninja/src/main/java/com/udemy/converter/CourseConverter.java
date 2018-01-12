package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	public CourseModel toModel (Course course) {
		return new CourseModel(
				course.getName(),
				course.getDescription(),
				course.getPrice(),
				course.getHours()
				);
	}
	
	public Course toEntity (CourseModel course) {
		Course c = new Course();
		c.setName(course.getName());
		c.setDescription(course.getDescription());
		c.setPrice(course.getPrice());
		c.setHours(course.getHours());
		return c;
	}
	
}
