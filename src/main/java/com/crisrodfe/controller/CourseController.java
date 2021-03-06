package com.crisrodfe.controller;

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

import com.crisrodfe.entity.Course;
import com.crisrodfe.model.CourseModel;
import com.crisrodfe.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController
{
	private static final String COURSE_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImp")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses()
	{
		LOG.info("Call: lisAllCourses()");
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		mav.addObject("course",new CourseModel());
		mav.addObject("courses", courseService.listAllCourses());
		
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel )
	{
		LOG.info("Call: addCourse() -- PARAM: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses"; //Añade el curso y lista todos de nuevo
	}
	
	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") CourseModel courseModel )
	{
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
		
	}
	
}
