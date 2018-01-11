package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImple implements ExampleService {

	private static final Log logger = LogFactory.getLog(ExampleServiceImple.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> personas = new ArrayList<>();
		personas.add(new Person("Daniel", 25));
		personas.add(new Person("Juan", 20));
		personas.add(new Person("Olga", 54));
		personas.add(new Person("Max", 51));
		
		logger.info("[getListPeople] lista obtenida");
		
		return personas;
	}
	
}
