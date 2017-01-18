package com.niit.OrgValleyBackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView getindex()
	{
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("signin")
	public ModelAndView getsignin()
	{
	ModelAndView mv= new ModelAndView("signin");
	return mv;
	}
	
	@RequestMapping("signup")
	public ModelAndView getsignup()
	{
	ModelAndView mv = new ModelAndView("signup");
	return mv;
	}

}
