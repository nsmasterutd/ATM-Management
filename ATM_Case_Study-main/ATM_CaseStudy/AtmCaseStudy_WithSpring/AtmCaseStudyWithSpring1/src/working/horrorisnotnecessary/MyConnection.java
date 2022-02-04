package working.horrorisnotnecessary;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("working.horrorisnotnecessary")
public class MyConnection {	
	
	
	public MyConnection() {
		System.out.println("MyConnection");
	}

	@Bean
	public JdbcTemplate get()
	{
		
		BasicDataSource s =new BasicDataSource();
		s.setDriverClassName("com.mysql.jdbc.Driver");
		s.setUrl("jdbc:mysql://localhost/atmcasestudy");
		s.setUsername("root");
		s.setPassword("cdacacts");
		JdbcTemplate t =new JdbcTemplate(s);
		System.out.println("get method call");
		return t;
		
		
	}
	
	
	
	
	
	

}
