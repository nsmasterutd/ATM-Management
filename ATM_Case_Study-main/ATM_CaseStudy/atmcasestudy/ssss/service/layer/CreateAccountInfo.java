package service.layer;

import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import dao.layer.AccountInfo;

@Component
public class CreateAccountInfo {

	
	@Bean
	public AccountInfo fun()
	{
		
		AccountInfo x=null;
		ResourceBundle r = ResourceBundle.getBundle("hello");  //configuration, does not lead
		  
		  
		  String cn = r.getString("cn");
		  System.out.println(cn);
		   
		try {
			Class c= Class.forName(cn);
			  Object o = c.newInstance();
			  
			  x = (AccountInfo) o;
		} catch (Exception e) 
		{
			
			
		}
		  
		return x;
	}
	
	
}
