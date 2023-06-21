package com.rootsolutions;


import java.sql.*;

public class CandidateLoginDao 
{
	public boolean check(String uname,String pass) 
	{
		try 
		{
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rootsolution", "root", "Yskr@2002");
	         String query="select * from candidatelogin where email=? and password=?";
	         PreparedStatement ps=con.prepareStatement(query);
	         ps.setString(1,uname);
	         ps.setString(2, pass);
	         ResultSet rs=ps.executeQuery();
	         if(rs.next())
	         {
	        	 return true;
	         }
	         
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION:"+e);
		}
		return false;
	
	}
	
	
}