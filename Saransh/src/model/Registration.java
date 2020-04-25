package model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")





public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			response.setContentType("text/html");
			
			String name= request.getParameter("name");
			String password =request.getParameter("password");
			String email =request.getParameter("email");

			
			
			String sql= "insert into registration(name,password,email) values(?,?,?)";
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/saransh","root","root");

			
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
			
			response.sendRedirect("login.jsp");
			
		}catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Connection Isuue");
			
			
			
		}
			
		
		
		
	}

}
