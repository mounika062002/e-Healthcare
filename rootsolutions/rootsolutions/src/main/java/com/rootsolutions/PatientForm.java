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
import java.sql.ResultSet;

/**
 * Servlet implementation class PatientForm
 */
@WebServlet("/patientform")
public class PatientForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*String pt_id=request.getParameter("pt_id");
		String pt_name=request.getParameter("pt_name");
		int pt_age=Integer.parseInt(request.getParameter("pt_age"));
		String pt_history=request.getParameter("pt_history");
		String pt_date=request.getParameter("pt_date");
		int sugar=Integer.parseInt(request.getParameter("sugar"));
		int bp=Integer.parseInt(request.getParameter("bp"));
		int pulserate=Integer.parseInt(request.getParameter("pulserate"));
		String gender=request.getParameter("gender");*/
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rootsolution", "root", "Yskr@2002");
	         String query="select aadhaar from aadhaarlink where pid ="+pt_id;
	         PreparedStatement st=con.prepareStatement(query);
	         ResultSet rs=st.executeQuery();
	         
	         
	         response.sendRedirect("healthstatus.html");
	         
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
