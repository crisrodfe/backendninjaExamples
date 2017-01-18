package com.crisrodfe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.crisrodfe.model.Person;
import com.crisrodfe.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService
{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);  
	
	@Override
	public List<Person> getListPeople() 
	{
		List<Person> people = new ArrayList<>();
		people.add(new Person("Louise",23));
		people.add(new Person("Jon",34));
		people.add(new Person("Michael",40));
		people.add(new Person("Cris",30));
			
		LOG.info("HELLO FROM SERVICE");
		
		return people;
		
	}
	
}
