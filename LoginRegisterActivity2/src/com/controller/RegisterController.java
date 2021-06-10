package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			try(PrintWriter out=response.getWriter()){
			
			response.setContentType("text/html;charset=UTF-8");
			String Name = request.getParameter("name");
			String Email = request.getParameter("email");
			Long Mobno=Long.parseLong(request.getParameter("mbno"));
			String Username = request.getParameter("uname");
			String Password = request.getParameter("pass"); //staru12
			
			RegisterDao rd=new RegisterDao();
			//String Salt = rd.GetSalt();
			String SecurePass = rd.HashMD5(Password); //staru12
			
			Register r = new Register();
			r.setName(Name);
			r.setEmail(Email);
			r.setMbno(Mobno);
			r.setUname(Username);
			r.setPass(SecurePass);
			//r.setSalt(Salt);
			
			int c=rd.savedata(r);
			if(c>0)
			{
				response.sendRedirect("LoginPage.jsp");
			}
			
		} /*catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
