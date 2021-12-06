package com.Jgallardo.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
	
	//GET
	//URI - hello-world
	//method "hello world"
	@GetMapping("hello-world")
	public String helloWorld() 
	{
		return "hello World";
	}
	
	//hello-worldbean
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean() 
	{
		return new HelloWorldBean("hello World");
	}
	
	@GetMapping("hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name ) 
	{
		return new HelloWorldBean(String.format("helloWorld, %s", name));
	}
}
