package service.layer;


import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.Account;
import com.test.Transaction;
// BankDatabase.java
// Represents the bank account information database 

import dao.layer.AccountInfo;

@Component
class BankDatabase
{
  
	@Autowired
   private AccountInfo x;
 

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public int authenticateUser( Account c )
   {
      // attempt to retrieve the account with the account number
      int status  = x.getAccount( c );

      return status;
   } // end method authenticateUser

   

public boolean updateDb(Account c) {
	// TODO Auto-generated method stub
	
	boolean status = x.updateAccount(c);
	
	return status;
}

public List<Transaction> getTransactionList(Account c,Date d1,Date d2)
{
	return x.getTransactionList(c, d1, d2);
}
} // end class BankDatabase



/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/