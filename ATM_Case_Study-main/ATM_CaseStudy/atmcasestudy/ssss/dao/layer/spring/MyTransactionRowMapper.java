package dao.layer.spring;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.Account;
import com.test.Transaction;

public class MyTransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {

		int accountNumber=Integer.parseInt(rs.getString(1));
		Date date=rs.getDate(2);
		
		
		
		
		
		int amount=Integer.parseInt(rs.getString(4));
		int type=Integer.parseInt(rs.getString(3));
		String strType=type==1?"deposit":"withdrawal";
		Transaction t=new Transaction(accountNumber, date, amount, strType);
		
		
		return t;
	}

}
