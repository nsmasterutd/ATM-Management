package working.horrorisnotnecessary;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AtmServlet
 */
@WebServlet("/AtmServlet")
public class AtmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagename="Home.jsp";
		
		String param = request.getParameter("why");
		if(param.equals("MINI_STATEMENT"))
		{
					
					
					pagename = "/WEB-INF/MINI_STATEMENT.html";
				
			}
		else if(param.equals("Deposit"))
		{
			
			
			pagename = "/WEB-INF/WithdrawalDeposit.html";
		
	}
		else if(param.equals("Withdrawal"))
		{
			
			
			pagename = "/WEB-INF/WithdrawalDeposit.html";
		
	}
		else if(param.equals("CHANGE_PIN"))
		{
			
			
			pagename = "/WEB-INF/CHANGE_PIN.html";
		
	}
		RequestDispatcher rs = request.getRequestDispatcher(pagename);
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagename="Login.jsp";
		PresentationAtm atm =new PresentationAtm();
		String param = request.getParameter("why");
		if(param.equals("Login"))
		{
					
					
					pagename = atm.authenticateUser(request);
				
			}
		else if(param.equals("BALANCE_INQUIRY"))
		{
			
			
			pagename = atm.BALANCE_INQUIRY(request);
		
	}
		else if(param.equals("MINI_STATEMENT"))
		{
			
			
			pagename = atm.MINI_STATEMENT(request);
		
	}
		else if(param.equals("CHANGE_PIN"))
		{
			
			
			pagename = atm.CHANGE_PIN(request);
		
	}
		
		else if(param.equals("Deposit"))
		{
			
			
			pagename = atm.UpdateAccount(request);
		
	}
		else if(param.equals("Withdrawal"))
		{
			
			
			pagename = atm.UpdateAccount(request);
		
	} else if(param.equals("Logout"))
	{
		HttpSession session = request.getSession();
		session.removeAttribute("userAccount");		
	
}
		
		RequestDispatcher rs = request.getRequestDispatcher(pagename);
		rs.forward(request, response);
				
	}
	
}
