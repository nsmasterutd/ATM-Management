package dao.layer.spring;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sun.xml.internal.bind.v2.util.DataSourceSource;

import dao.layer.AccountInfo;

import com.test.Account;
import com.test.Transaction;



public class SpringBasedAccount implements AccountInfo {
	
	
	SpringJdbcTemp s;
	
	
	JdbcTemplate jtemp;
	
	public SpringBasedAccount() {
		AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(DataSourceClass.class);
		s=(SpringJdbcTemp)con.getBean(SpringJdbcTemp.class);
		
		
		if(s!=null)
		jtemp=s.getJtemp();
		
	}

	@Override
	public int getAccount(Account c) {
		
		String sql="select * from account where AccountNumber=?";
		Object x[]= {c.getAccountNumber()};
		MyRowMapper r=new MyRowMapper();
		List<Account> list= jtemp.query(sql,x,r);
		
		if(list.isEmpty())
		{
			return 0;
		}
		else
		{
			Account m=list.get(0);
			if(m.getPin()==c.getPin())
			{
				c.setTotalBalance(m.getTotalBalance());
				return 2;
			}
			else
			{
				return 1;
			}
		}
		
		
		
	}

	@Override
	public boolean updateAccount(Account c) {
		String sql="";
		Object x[]= {};
		
		int i=jtemp.update("call my_update_balance(?,?)",(int)c.getTotalBalance(),""+c.getAccountNumber());
		
		if(i==1)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public List<Transaction> getTransactionList(Account c, Date fromDate, Date toDate) {
		
		
		String sql="select AccountNumber , tnxDate , tnxType ,amount from Transaction where AccountNumber=? and tnxDate between ? and ?";
		Object x[]= {c.getAccountNumber(),fromDate,toDate};
		MyTransactionRowMapper r=new MyTransactionRowMapper();
		List<Transaction> list= jtemp.query(sql,x,r);
		return list;
	}

}
