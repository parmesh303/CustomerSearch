package com.crud.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.model.AdminDao;
import com.crud.model.Movie;

@Controller
public class AdminController
{

	private ApplicationContext  conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	@RequestMapping("/home")
	public String view1() 
	{
		return "home";
	}
	
	@RequestMapping("/register")
	public String view2(Model m) 
	{
	
		Movie mov=conn.getBean("info", Movie.class);
		m.addAttribute("bean", mov);
		return "register";
	}
	
	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") Movie m, Model mo)
	{

		AdminDao obj= conn.getBean("dao", AdminDao.class);
		obj.saveData(m);
		mo.addAttribute("msg", "Record insert Successfully...");
		return "register";
		
	}
	@RequestMapping("/display")
	public String view4(Model m)
	{

		AdminDao obj= conn.getBean("dao", AdminDao.class);
		 @SuppressWarnings("unchecked")
		List<Movie> list = obj.displayData();
		if(!list.isEmpty())
		{
		m.addAttribute("data", list);
		}
		else
		{
			m.addAttribute("msg" , "Oops data not found...");
		}
		return "display";
	}
	
	@RequestMapping("/find")
	public String view5(Model m)
	{
		
		Movie mov= conn.getBean("info",Movie.class);
		m.addAttribute("bean", mov );
		return "search";
		
	}
	
	@RequestMapping("/search")
	public String view5(@ModelAttribute("bean") Movie m, Model mo)
	{

		AdminDao obj= conn.getBean("dao", AdminDao.class);
		@SuppressWarnings("unchecked")
		List<Movie> list = obj.searchData(m);
		if(!list.isEmpty())
		{
			mo.addAttribute("li", list);
		}
		else
		{
			mo.addAttribute("msg" , "Oops data not found...");
		}
		
		return "search";
		
	}
	

	 @RequestMapping("/book")
	    public ModelAndView view11()
	 {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("book");
		 
	        return mv;
	    }
	
	
	
		 @RequestMapping("/bookt")
		    public ModelAndView view12(Model m)
		 {
			ModelAndView mv=new ModelAndView();

			mv.setViewName("displaybook");
			 
		        return mv;
		    }


}
