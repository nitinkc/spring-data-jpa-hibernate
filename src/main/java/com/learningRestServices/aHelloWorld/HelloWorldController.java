package com.learningRestServices.aHelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET,path="/requestMapping")
	public String helloWorldViaRequestMapping() {
		//GET
		// URI - /helloWorld
		//method - HelloWorld
		
		return "Hello World - From requestMapping";
	}

	@GetMapping(path="/getMapping")
	public String helloWorldViaGetMapping() {
		return "Hello World - From getMapping";
	}
	
	@GetMapping(path="/getBean")
	public HelloWorldReturnBean helloWorldReturnBean() {
		return new HelloWorldReturnBean("Hello World - From HelloWorldReturnBean");
	}
	
	
	@GetMapping(path = "/pathVariable/{var_name}")
	public String helloWorldPathVariable(@PathVariable("var_name") String name) {
		return String.format("The Value returned is %s", name);
		
	}
}
