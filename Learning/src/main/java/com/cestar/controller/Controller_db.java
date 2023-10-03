package com.cestar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.AccountDao;
import com.cestar.model.BankAccount;

/**
 * Servlet implementation class Controller_db
 */
@WebServlet("/")
public class Controller_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AccountDao dao=new AccountDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		
		
		// Here we are getting the whole path till servlet
		
		String url=request.getServletPath();
		
switch(url) {
		
		
		case "/display":{
			
			// when the method shows error just put cursor on red line and select
			//first
			// option from suggestions
			display(request, response);
			
			break;
		}
       case "/insert" :{
			
			insert(request, response);
			
			break;
		}
       case "/edit" :{
			
			edit(request, response);
			
			break;
		}
      
      case "/update" :{
			
			update(request, response);
			
			break;
		}
      case "/delete" :{
			
			delete(request, response);
			
			break;
		}
      default :{
   	   
   	   out.print("Invalid URL!!!!!");
      }
      
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Method to display record
	protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     List<BankAccount> accounts=new ArrayList<>();
		
		accounts=dao.displayaccount();
		
    HttpSession session =request.getSession();
		
		session.setAttribute("accounts_from_db",accounts );
		
		RequestDispatcher rd= request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response); 
	}
	
	//insert method to insert record
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
PrintWriter out =response.getWriter();
        
        response.setContentType("text/html");
        
        //id=&type=&name=&con=&balance=&date=
        
        int account_id = Integer.parseInt(request.getParameter("id"));
        
        String account_type=request.getParameter("type");
        
        String accountHolderName=request.getParameter("name");
        
        String accountHolderContact=request.getParameter("con");
        
        String accountBalance=request.getParameter("balance");
        
        Date accountSetupDate=Date.valueOf(request.getParameter("date"));
        
        BankAccount account=new BankAccount(account_id ,account_type,accountHolderName,accountHolderContact,accountBalance,accountSetupDate);        
        
        int status=dao.insertRec(account);
        
        if(status>0) {
			
        	 display(request, response);
    		}
    		else {
    			
    			out.print("Please try again!!! Record insertion failed ");
    		}
    	}
    	
	

protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int old_id = Integer.parseInt(request.getParameter("id"));
		
		BankAccount account=dao.getrecord(old_id);
		
HttpSession session=request.getSession();
		
		session.setAttribute("account_to_edit",account );
		
		RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
		
		rd.forward(request, response);
}

//Update method to update the account info
   protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	   
	   //new_id=777&type=Saving&name=Mary&con=456-987-5434&balance=6000&date=2023-02-04
	   int new_id = Integer.parseInt(request.getParameter("new_id"));
		
		String type=request.getParameter("type");
		
		String name=request.getParameter("name");
		
		String contact=request.getParameter("con");
		
		String balance=request.getParameter("balance");
		
		Date setupdate=Date.valueOf(request.getParameter("date"));
		
HttpSession session =request.getSession();
		
		int old_id=(int)session.getAttribute("old_id");
		
		
		BankAccount account=new BankAccount(new_id,type,name,contact,balance,setupdate);
       
		dao.updateRec(account, old_id);
		
		display(request, response);
   }
   
   
   // Delete method to delete the record of particular account based on id
   
   protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Call the deleteRec from AccountDao class
	   
	   int id_from_delete_button=Integer.parseInt(request.getParameter("id"));
	   
	   dao.deleteRec(id_from_delete_button);
	   
	   display(request, response);
   }
	
}