package com.chetu.skill;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {		
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			out.println("<h1>Update Servlet</h1>");
			
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String sqlUrl = "jdbc:mysql://localhost:3306/saquibdb";
			String sqlUsername = "root";
			String sqlPassword = "Saquib@12345";
			//String sqlStatement = "update employee set emp_name='xxxxxxx', emp_sal=99914.322 where emp_no=101";
			String sqlStatement = "update chetu set emp_name=?, emp_sal=? where emp_Id=?";
			Integer id = Integer.parseInt(req.getParameter("empId"));
			String name = req.getParameter("empName");
			Float sal = Float.parseFloat(req.getParameter("empSal"));
				
			try {
				Class.forName(driverClass);
				Connection con = DriverManager.getConnection(sqlUrl,sqlUsername,sqlPassword);
				 PreparedStatement pst = con.prepareStatement(sqlStatement);
				    pst.setString(1, name);
					pst.setFloat(2, sal);
					pst.setInt(3, id);
					int x =pst.executeUpdate();
				    if(x!=0)
					 out.println("<h1>Data Updated</h1>");
			} catch (ClassNotFoundException e) {
				
			}catch (SQLException e) {
				
			}			
		}
}

