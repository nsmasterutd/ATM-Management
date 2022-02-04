package working.horrorisnotnecessary;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationAtm {
	
	BankDatabase bankDatabase;
	 Account c;
	
	public PresentationAtm() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConnection.class);		 
		 bankDatabase=context.getBean(BankDatabase.class);
		
	}

	public String authenticateUser(HttpServletRequest request) {
		String pagename ="Login.jsp";
		String accountNumber = request.getParameter("accountNumber");
		String pin = request.getParameter("pin");
		  c= new Account (Integer.parseInt(accountNumber),Integer.parseInt(pin),0);
		int status=  bankDatabase.authenticateUser(c);
		//System.out.println(c.getTotalBalance());
		if(status==1)
		{
			HttpSession session = request.getSession();
			if(true)//session.getAttribute("userAccount") ==null 
			{
				session.setAttribute("userAccount",c.getAccountNumber());
				request.setAttribute("message", "Welcome "+accountNumber);
			pagename="/WEB-INF/Home.jsp";
			
			
			}else {
				request.setAttribute("message", "Please Login Again");
			}
			
		}
		else if(status==2)
		{
			request.setAttribute("message", "Invalid Account Number");
		}
		else 
		{
			request.setAttribute("message", "Invalid Pin Number");
			
			
		}
		return pagename;
	}
	
	public String BALANCE_INQUIRY(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pagename ="Login.jsp";
		if(session.getAttribute("userAccount") !=null)
		{
		 pagename="/WEB-INF/Home.jsp";
		System.out.println(c.getTotalBalance());
	    request.setAttribute("balance","Your Total Balance : "+ (this.c.getTotalBalance()));
		}else {
			request.setAttribute("message", "Please Login Again");
		}
	    return pagename;
	}
	public String MINI_STATEMENT(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pagename ="Login.jsp";
		if(session.getAttribute("userAccount") !=null)
		{
		
		 pagename="/WEB-INF/Home.jsp";
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		List<Trance> lt =bankDatabase.miniSmt(sdate,edate,c);
		request.setAttribute("tlist", lt);}
		else {
			request.setAttribute("message", "Please Login Again");
		}
		return pagename;
		
	}
	public String CHANGE_PIN(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pagename ="Login.jsp";
		if(session.getAttribute("userAccount") !=null)
		{
		 pagename="/WEB-INF/Home.jsp";
		String pin = request.getParameter("pin");
		c.setPin(Integer.parseInt(pin));
		boolean status = bankDatabase.updatePin(c);
		
		if(!status)
		{
			request.setAttribute("pin", "Pin Not Updated");
			
		}
		else
			request.setAttribute("pin", "Pin Updated");}
		else {
			request.setAttribute("message", "Please Login Again");
		}
		return pagename;
	}
	public String UpdateAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pagename ="Login.jsp";
		if(session.getAttribute("userAccount") !=null)
		{
		 pagename="/WEB-INF/Home.jsp";
		String param = request.getParameter("why");
		String amount = request.getParameter("amount");
		if(param.equals("Withdrawal")) {
			if(Double.parseDouble(amount)>c.getTotalBalance())
			{
				request.setAttribute("balancestatus", "Insufficient Balance");
			}
			else
			{
			 c.debit(Double.parseDouble(amount));
			 request.setAttribute("balancestatus", "Withdrawal Successfully");
		}
			}
		else {
			c.credit(Double.parseDouble(amount));
			 request.setAttribute("balancestatus", "Deposit Successfully");
		}
		//c.setTotalBalance(Integer.parseInt(amount));
		boolean status = bankDatabase.updateDb(c);
		
		if(!status)
		{
			request.setAttribute("messageaccount", "Account  Balance Not Updated");
			
		}
		else
			request.setAttribute("messageaccount", "Account Balance Updated");}
		else {
			request.setAttribute("message", "Please Login Again");
		}
		return pagename;
	}
	
	

}
