package working.horrorisnotnecessary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCBasedAccount {
	@Autowired
	private JdbcTemplate t;
	
	public JDBCBasedAccount(){
		System.out.println("JDBCBasedAccount");
	}
	public void checkjdbctemp() {
		System.out.println(t==null);
	}
	
	public int getAccount(Account c) {
				
		String sql="select * from accinfo where accountNumber=?";
		Object params[]= { c.getAccountNumber()};
		Account acc=null;
		try {
			acc = t.queryForObject(sql, params,new BeanPropertyRowMapper<Account>(Account.class));
		} catch (DataAccessException e1) {
			e1.printStackTrace();
			
		}
		if( acc != null)
		{		
				if(acc.validatePIN(c.getPin()))
				{
					
					c.setTotalBalance(acc.getTotalBalance());
					return 1; //everything is ok
					
				}
				else {
					return 2;//accno wrong
				}
			
		}
		
		return 3; // pin was wrong
	}


	public boolean updateAccount(Account c) {
		this.TranceDb(c);
		String sql="update accinfo  set totalBalance =? where accountNumber = ?";
		Object params[]= { c.getTotalBalance(),c.getAccountNumber()};
		int ra =t.update(sql,params); 
		return  ra > 0 ;
	}


	public boolean updatePin(Account c) {		
		String sql="update accinfo  set pin =? where accountNumber = ?";
		Object params[]= { c.getPin(),c.getAccountNumber()};
		int ra =t.update(sql,params); 
		return  ra > 0 ;
	}

	
	public List<Trance> miniSmt(String string, String string1, Account c) {

		String q1 = "select * from trance where tdate>= ? AND tdate<= ? AND  AccountNO=?";	
		Object params[]= { string,string1,c.getAccountNumber() };
		List<Trance> lt=t.query(q1,params,new BeanPropertyRowMapper<Trance>(Trance.class));
		System.out.println(lt);
		return lt;
	}

	public void TranceDb(Account account){
		String sql="select * from accinfo where accountNumber=?";
		Object params[]= { account.getAccountNumber()};
		Account acc=null;
		try {
			acc = t.queryForObject(sql, params,new BeanPropertyRowMapper<Account>(Account.class));
		} catch (DataAccessException e1) {
			e1.printStackTrace();			
		}
		 Date date = new Date();
	     SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy:MM:dd");
	     String m = simpleDateformat.format(date);
	     
		String tranceTypeString=null;
		int amount = 0;
		if(acc.getTotalBalance()>account.getTotalBalance()){
			tranceTypeString="Withdraw";
			amount=(int) ((acc.getTotalBalance()) -account.getTotalBalance());
		}
		else if(acc.getTotalBalance()<account.getTotalBalance()){
			tranceTypeString="Deposit";
			amount=(int) (( account.getTotalBalance()-acc.getTotalBalance()));
		}
		else{
			tranceTypeString="Fail";
			amount=0;
		}
		System.out.println(account.getAccountNumber()+"   "+m+"  "+tranceTypeString+"  "+amount);
		String q1 = "insert into trance values(?,?,?,?)";
		Object params1[]= {account.getAccountNumber(),m,tranceTypeString,amount};
		t.update(q1, params1);
		System.out.println("inserted row ");
		   
		
	}
}

/*
 create table Trance(
 AccountNO int(11) ,
 tdate date,
 type varchar(20),
 amount int (11) 
 )
 * */
