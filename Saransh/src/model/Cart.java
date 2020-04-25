package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBconn
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saransh", "root", "root");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			PrintWriter out = response.getWriter();
			ResultSet rs = stmt.executeQuery("select * from product");
			

			out.print("<html><body><table border=3>");
			out.print("<tr>"
					+"<th>Product ID </th>"
					+"<th>Product Name </th>"
					+"<th> Price</th>"
					+"</tr>"
					);
			while (rs.next()){
				out.print("<tr>"
						+"<td>" +rs.getInt(1)+"</td>"
						+"<td>" +rs.getString(2)+"</td>"
						+"<td>" +rs.getString(3)+"</td>"
						+"</tr>"						
						);
				
			}
			out.print("</table></body></html>");
			
			
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
