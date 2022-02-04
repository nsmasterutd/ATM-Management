package service.layer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.Account;
import com.test.Transaction;




@org.springframework.stereotype.Service
public class Service {
	
	
	@Autowired
	private BankDatabase bankDatabase; // account information database

	public int authenticateUser(Account c) {
		// TODO Auto-generated method stub
		int ret = bankDatabase.authenticateUser(c);
		//ret will be zero if database problems
		//ret will be 1 if accountnumber does not match
		//ret will be 2 if everything is ok.
		
		return ret;
	}
	
	
	    

	public boolean updateLayer(Account c) {
		// TODO Auto-generated method stub
		boolean x =bankDatabase.updateDb(c);
		
		return x;
	}

	
	public List<Transaction> getTransactionList(Account c,Date d1,Date d2)
	{
		
		
		java.sql.Date fromdateDate=new java.sql.Date(d1.getTime());
		java.sql.Date todateDate=new java.sql.Date(d2.getTime());
		
		return bankDatabase.getTransactionList(c, fromdateDate, todateDate);
	}
	
}
