package working.horrorisnotnecessary;

import java.util.List;
import java.util.ResourceBundle;
// BankDatabase.java
// Represents the bank account information database 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class BankDatabase
{
   @Autowired
   private JDBCBasedAccount x;
     
  
   public BankDatabase() throws Exception
   {	      System.out.println("BankDatabase obj");
	 
   } 
 public void checkjdbctemp() {
	 System.out.println(x==null);
	 x.checkjdbctemp();
	// TODO Auto-generated method stub

}
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



public boolean updatePin(Account c) {
	boolean status = x.updatePin(c);
	return status;
}



public List<Trance> miniSmt(String string, String string1, Account c) {
	List<Trance> lt = x.miniSmt(string,string1,c);
	return lt;
}



} // end class BankDatabase
