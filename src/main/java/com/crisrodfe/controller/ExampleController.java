package com.crisrodfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController 
{
	private static final String EXAMPLE_VIEW = "example";
	
	//localhost:8080/example/request1?nm=CRIS para meter un parámetro
	//localhost:8080/example/request1?nm=JON
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required= false, defaultValue="NULL") String name){
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		
		return mav;
	}
	
	//Segunda forma de recibir petición get.
	//localhost:8080/example/request2/CRIS
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name){
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model",name);
		
		return mav;
	}
	
	
	

}
