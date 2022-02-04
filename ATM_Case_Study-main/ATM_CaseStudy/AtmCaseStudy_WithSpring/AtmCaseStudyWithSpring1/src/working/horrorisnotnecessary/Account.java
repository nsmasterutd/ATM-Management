package working.horrorisnotnecessary;

import java.util.List;

// Account.java
// Represents a bank account
public class Account implements Comparable<Account>
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
     private double totalBalance; // funds available + pending deposits

   // Account constructor initializes attributes
   public Account( int theAccountNumber, int thePIN, 
       double theTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      
      totalBalance = theTotalBalance;
   } // end Account constructor

   public Account() {
	// TODO Auto-generated constructor stub
}

// determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN   
  
   // returns the total balance
   public double getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   public int getPin() {
	return pin;
}

public void setPin(int pin) {
	this.pin = pin;
}

public void setTotalBalance(double totalBalance) {
	this.totalBalance = totalBalance;
}

// credits an amount to the account
   public void credit( double amount )
   {  
      totalBalance += amount; // add to total balance
   } // end method credit   
  
   // debits an amount from the account
   public void debit( double amount )  {
     
      totalBalance -= amount; // subtract from total balance
   } // end method debit

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountNumber;
	return result;
}

public boolean equals(Object obj) {
	
	System.out.println("equals function");
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass()) //reflection at work
		return false;
	Account other = (Account) obj;
	if (accountNumber != other.accountNumber)
		return false;
	return true;
}

@Override
public int compareTo(Account o) {
	// TODO Auto-generated method stub
	System.out.println("kc");
	return getAccountNumber()- o.getAccountNumber();
}

public List<Trance> miniSmt(String string) {
	return null;

	
	
}
} // end class Account

