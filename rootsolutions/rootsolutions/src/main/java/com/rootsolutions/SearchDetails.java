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
@WebServlet("/patientsearch")
public class SearchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pt_id=request.getParameter("patientid");
		String query="select * from "+pt_id;
		HttpSession session = request.getSession();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rootsolution", "root", "Yskr@2002");
	        PreparedStatement st=con.prepareStatement(query);
	        ResultSet rs = st.executeQuery();
	       rs.next();
	       String name = rs.getString(2);
	       int age = rs.getInt(3);
	       String history = rs.getString(4);
	       String Rdate = rs.getString(5);
	       int sugar = rs.getInt(6);
	       int bp = rs.getInt(7);
	       int pulserate = rs.getInt(8);
	       String gender = rs.getNString(9);
	       session.setAttribute("name",name);
	       session.setAttribute("age",age);
	       session.setAttribute("history",history);
	       session.setAttribute("Rdate",Rdate);
	       session.setAttribute("sugar",sugar);
	       session.setAttribute("bp",bp);
	       session.setAttribute("pulserate",pulserate);
	       session.setAttribute("gender",gender);
	       response.sendRedirect("showdetails.jsp");
	       
		
	       
	        
	        
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		
	}

}
