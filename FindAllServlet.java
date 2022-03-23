package com.chetu.skill;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAllServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Integer empNo=Integer.parseInt(req.getParameter("empNo"));
		String driveClass="com.mysql.jdbc.Driver";
		String sqlUrl="jdbc.mysql://localhost:3306/saquibdb";
		String sqlusername="root";
		String sqlPassword="saquib@12345";
		String FindAllServlet="";
		try
		{
			Class.forName(FindAllServlet);
			Connection con=DriverManager.getConnection(sqlUrl,sqlPassword,sqlusername);
			PreparedStatement pst=con.prepareStatement(FindAllServlet);
				
		}catch(ClassNotFoundException | SQLException e)
		{out.println("");
			
		}
	}
}
