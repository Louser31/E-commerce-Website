package model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Cart;
import controller.Product;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			try {
				response.setContentType("text/html");
				
				String name= request.getParameter("name");
				String password =request.getParameter("password");

				
				
				String sql= "select * from registration where name=? and password=?";
				
				
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/saransh","root","root");

				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, password);
				
				ResultSet rs= ps.executeQuery();
				
				String username=null;
				String upass= null;
				while (rs.next()){
				
				 username= rs.getString("name"); 

					upass= rs.getString("password"); 
					
				}
					
					if(name.equals(username) && password.equals(upass)){
				
						
				HttpSession session= request.getSession();
				session.setAttribute("Username",name);
				session.setAttribute("pass",password);
				
				//get details helper class
				
				List<Product> product= Cart.getProduct();
				String sum=Cart.total();
				//add list of student
				
				request.setAttribute("Product_list", product);
				request.setAttribute("Sum", sum);
				
				//get request dispatcher
				
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("welcome.jsp");
				
				//forward to JSP
				
					dispatcher.forward(request, response);
			
			
			}
							else{
			
				response.sendRedirect("login.jsp");
				
			}
			
			conn.close();
			
			} catch (Exception e) {
				System.out.println(e);

			}

		
		
		
		
	}
}