package com.chetu.skill;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletOne extends HttpServlet{
	
	public void  service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<a href='index.html'>Goto LoginPage</a>");
		String name = req.getParameter("name");
	//	Integer id = Integer.parseInt(req.getParameter("Id"));
		String id =  req.getParameter("Id");
		
		String driverClass ="com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/saquibdb";
		String username = "root";
		String password = "Saquib@12345";
		String data = "insert into chetu values(123,'Saquib ansari',5235.36)";
	//	String data = "insert into chetu values("+id+","+name+",95235.36)";
		
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			int sat = st.executeUpdate(data);
			con.close();
			if(sat !=0) {
				out.println("<h2>Data updated!</h2>");
				out.println("<h1>Name: "+name+"</h1");
				out.println("<h1>Id: "+id+"</h1>");
			}
			else {
				out.println("<h2>Data is not updated!</h2>");
			}
			
		} catch (ClassNotFoundException e) {
			out.println("<h1>Driver class is not loaded </h1>");
		}catch (Exception e) {
			out.println("<h1>Connection is not created</h1>");
		}
		
	}

}
