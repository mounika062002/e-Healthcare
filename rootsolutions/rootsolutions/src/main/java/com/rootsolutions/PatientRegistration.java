package com.rootsolutions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

@WebServlet("/patientregistration")
public class PatientRegistration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		String aadhaar=request.getParameter("aadhaar");
		String phoneno=request.getParameter("phoneno");
		String address=request.getParameter("address");
		String age=request.getParameter("age");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String pid = uuidAsString.substring(0,8);
        HttpSession session=request.getSession();
        session.setAttribute("pid", pid);
        
        String query1="create table "+pid+"(id int NOT NULL AUTO_INCREMENT,name varchar(20),age int,history varchar(300),Rdate date,sugar int,bp int,pulserate int,gender varchar(10),primary key(id))";
        String query2="insert into patient_registration values(?,?,?,?,?,?,?)";
        String query3="create table aadhaarlink(pid varchar(8),aadhaar varchar(12))";
        String query4="insert into aadhaarlink(?,?)";
        try
        {
        	
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rootsolution","root","Yskr@2002");
        		PreparedStatement st1=con.prepareStatement(query1);
        		PreparedStatement st3=con.prepareStatement(query3);
        		PreparedStatement st2=con.prepareStatement(query2);
        		st2.setString(1, name);
        		st2.setString(2, aadhaar);
        		st2.setString(3, phoneno);
        		st2.setString(4, address);
        		st2.setString(5, age);
        		st2.setString(6, dob);
        		st2.setString(7, gender);
        		st3.setString(1, pid);
        		st3.setString(2, aadhaar);
        		int rows1=st2.executeUpdate();
        		int rows2=st1.executeUpdate();
        		int rows3=st3.executeUpdate();
        		response.sendRedirect("patregistrationmsg.jsp");
        		
        		
        }
        catch(Exception e)
        {
        	System.out.println("Exception:"+e);
        }
        
		
	}

}
