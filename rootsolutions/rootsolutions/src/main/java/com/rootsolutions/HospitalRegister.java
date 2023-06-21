package com.rootsolutions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/hospitalregister")
public class HospitalRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		String phoneno=request.getParameter("phoneno");
		String mailid=request.getParameter("mailid");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String pincode=request.getParameter("pincode");
		String district=request.getParameter("district");
		String identity=request.getParameter("identity");		
		
		
		
		try 
		{
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rootsolution", "root", "Yskr@2002");
	         String query="insert into hospital_register values(?,?,?,?,?,?,?,?)";
	         PreparedStatement st=con.prepareStatement(query);
	         st.setString(1,name);
	         st.setString(2,phoneno);
	         st.setString(3,mailid);
	         st.setString(4, password);
	         st.setString(5,address);
	         st.setString(6,pincode);
	         st.setString(7,district);
	         st.setString(8,identity);
	         int rows=st.executeUpdate();
	         String query1="insert into hospital_login values(?,?)";
	         PreparedStatement st1=con.prepareStatement(query1);
	         st1.setString(1,mailid);
	         st1.setString(2, password);
	         int rows2=st1.executeUpdate();
	         response.sendRedirect("hospital.html");
	        
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e);
		}
	}

}