package com.crisrodfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crisrodfe.component.ExampleComponent;
import com.crisrodfe.service.ExampleService;


@Controller
@RequestMapping("/example") //Ruta que tendremos que escribir en el navegador despues del puerto
public class HelloWorldController
{
	public static final String  HELLO_VIEW = "helloworld";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	//Primera forma de devolver una template/view. Más usada cuando hay que insertar muchos datos en la plantilla.
	@GetMapping("/helloMAV")
	public ModelAndView helloMAV() {
		ModelAndView mav = new ModelAndView(HELLO_VIEW);
		//mav.addObject("person", new Person("Jon",32));
		mav.addObject("people",exampleService.getListPeople());
		
		//Ejemplo uso de un componente
		exampleComponent.sayHello();
		
		return mav;
	}
	
	//Segunda forma.
	@GetMapping("/helloworld")//Nombre del recurso, para llamarlo hay que ponerlo en la url despues de /example
	public String helloWorld(Model model)
	{
		//model.addAttribute("person", new Person("Cris",30)); //Insertamos datos en la vista.
		model.addAttribute("people",exampleService.getListPeople());
		return HELLO_VIEW; //Nombre de la vista/template
	}
	
	

		

}
