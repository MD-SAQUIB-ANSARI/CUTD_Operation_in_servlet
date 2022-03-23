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

public class DeleteServlet extends HttpServlet{
	  public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	  {
		  
		  resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  Integer empId=Integer.parseInt(req.getParameter("empId"));
		  //String empName=req.getParameter(("empNmae"));
		 // Integer empSal=Integer.parseInt(req.getParameter("empSalary"));
		  
		    String driverClass = "com.mysql.jdbc.Driver";
			String sqlUrl = "jdbc:mysql://localhost:3306/saquibdb";
			String sqlUsername = "root";
			String sqlPassword = "Saquib@12345";
			String insertStatement = "delete from chetu where emp_id=?";
			try
			{
				Class.forName(driverClass);
				Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
				PreparedStatement pst = con.prepareStatement(insertStatement);
				pst.setInt(1,empId);
				int x=pst.executeUpdate();
				out.println("<h1>Data is Delete</h1>");
			}
			catch (ClassNotFoundException e) {
				out.println("<h1>Your Driver class is not Loaded</h1>");
			} catch (SQLException e) {
				out.println("<h1>Your class is not Connecting with SQL Server</h1>");
			}	
	  }
		}

