package com.udemy.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

	public final Log logger = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello(){
		logger.info("[sayHello] Creado ExampleComponent");
	}
	
}
