package com.test;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import service.layer.Service;

@Controller
@SessionAttributes()
public class ServiceMapper {
	
	
	private Service serviceObject;


	public ServiceMapper() {
		AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(CompanentScanner.class);
		   
		   serviceObject =con.getBean(Service.class);
	}
	
	
	@RequestMapping(value="/login")
	
	public ModelAndView loginCheck(HttpSession session,@RequestParam(value="loginAccNo") String accountNumber,@RequestParam(value="loginPin") String pin)
	{
		ModelAndView m;
		int i;
		String sid=session.getId();
		
		if(session.getAttribute("loginstatus")==null)
		{
			System.out.println("from  login check"+accountNumber+pin);
			
			Account c=new Account(Integer.parseInt(accountNumber),Integer.parseInt( pin), 0.0);
			
			i=serviceObject.authenticateUser(c);
			
		
			
			if(i!=2)
			{
				m=new ModelAndView("loginAtm");
				m.addObject("status",false);
				m.addObject("message","invalid account or pin");
				return m;
			}	
			else
			{
				m=new ModelAndView("home");
				m.addObject("sid", sid);
				session.setAttribute("loginstatus", true);
				m.addObject("status",true);
			}

			
		}
		else
		{
			m=new ModelAndView("home");
			m.addObject("sid", sid);
			m.addObject("status",true);
		}
		
		return m;
	}

}
