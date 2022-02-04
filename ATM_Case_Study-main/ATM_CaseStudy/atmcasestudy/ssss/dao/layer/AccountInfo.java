package dao.layer;

import java.util.List;
import java.sql.Date;

import com.test.Account;
import com.test.Transaction;

public interface AccountInfo {
	
	
	int getAccount(Account c); // if we get null, account number is not found

	boolean updateAccount(Account c);
	
	List<Transaction> getTransactionList(Account c,Date fromDate,Date toDate);
	

}
