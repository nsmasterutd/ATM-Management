package dao.layer.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.Account;
import com.test.Transaction;

public class MyRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int arg1) throws SQLException {
		
		int theAccountNumber=Integer.parseInt(rs.getString(1));
		int thePIN=Integer.parseInt(rs.getString(2));
		int theTotalBalance=Integer.parseInt(rs.getString(3));
		
		Account c=new Account(theAccountNumber, thePIN, theTotalBalance);
		
		
		return c;
	}

}
