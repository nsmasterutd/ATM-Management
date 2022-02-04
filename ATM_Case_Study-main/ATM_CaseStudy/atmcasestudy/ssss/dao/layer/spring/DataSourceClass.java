package dao.layer.spring;

import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@ComponentScan("dao.layer.spring")
public class DataSourceClass {
	
	
	@Bean
	public JdbcTemplate fun()
	{
		
		
		BasicDataSource ds=new BasicDataSource();
		ResourceBundle b=ResourceBundle.getBundle("hello");
		ds.setDriverClassName(b.getString("spring_driverClassName"));
		ds.setUrl("jdbc:mysql://localhost/java");
		ds.setUsername(b.getString("spring_username"));
		ds.setPassword(b.getString("spring_password"));
		
		JdbcTemplate te=new JdbcTemplate();
		te.setDataSource(ds);
		
		return te;
	}

}
