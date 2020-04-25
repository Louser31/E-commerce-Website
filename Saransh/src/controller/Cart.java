package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	public static List<Product> getProduct() {
		// empty list

		List<Product> product = new ArrayList<>();

		// sample data

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saransh", "root", "root");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			

			while (rs.next()){
					
						product.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3)));	
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}


		// return

		return product;

	}

	public static  String total() {
		
		 String sum=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saransh", "root", "root");
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Select Sum(pprice) as sumprice from product");
				
				
				if(rs.next()){
	                sum = rs.getString("sumprice");
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);

			}
			
			
			
			return sum;
		}

}