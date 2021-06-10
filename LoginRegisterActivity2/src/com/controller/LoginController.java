package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.dao.RegisterDao;
import com.model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		String Username=request.getParameter("uname");
		String Password=request.getParameter("pass");
		
		LoginDao l1 =new LoginDao();
		//String Salt = l1.GetSalt(Username);
		//System.out.println(Salt);
		RegisterDao r = new RegisterDao();
		String PasswordToVerify = r.HashMD5(Password);
		
		Login l=new Login();
		l.setUname(Username);
		l.setPass(PasswordToVerify);
		
		PrintWriter out = response.getWriter();
		
		boolean b=l1.validate(l);
		if(b){
            HttpSession session=request.getSession();  
            session.setAttribute("uname",Username);   
			response.sendRedirect("HomePage.jsp");
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid username or password. Please enter correct login credentials.");
            RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");
            rd.forward(request, response);  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
