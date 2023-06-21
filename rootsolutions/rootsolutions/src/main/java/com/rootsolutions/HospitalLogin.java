package com.rootsolutions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.rootsolutions.*;

import java.io.IOException;

@WebServlet("/hospitallogin")
public class HospitalLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		   String email=request.getParameter("email");
		   String password=request.getParameter("password");
		   HttpSession session=request.getSession();
		   session.setAttribute("email",email);
		   session.setAttribute("password", password);
		   HospitalLoginDao dao=new HospitalLoginDao();
		   if(dao.check(email, password))
		   {
			   response.sendRedirect("hospitalhome.html");
			   
		   }
		   else
		   {
			   response.sendRedirect("hospitallogin.html");
		   }
		   
	}


	
	

}