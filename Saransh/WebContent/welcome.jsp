<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>

	<link rel="stylesheet" type="text/css" href="Css/Style.css">
	<link rel="stylesheet" type="text/css" href="Css/checkout.css">

	<style>


	</style>
</head>
<body>
<%
	if(session.getAttribute("Username")==null){
		
		
		response.sendRedirect("login.jsp");
	}


%>
	<h1>Astarag</h1>
	<div class="Nav-area">
		<ul class="nav">
			<li><a href="#">Home</a></li>
			<li><a href="shop.jsp">Shop</a></li>
			<li><a href="#portfolio">About</a></li>
			<li class="active"><a href="#contact">Checkout</a></li>
			<li><a href="contact.html">contact
				</a></li>
		</ul>
	</div>
	
	<div class="head">
	<h6>Checkout</h6>
	</div>
	
	<div class="box">
	<div class="box1">
	
		<h1>Adderess</h1>
		
		<div class=address>
		<form>
		
		<label>Adress  line 1*</label>
		<input type="text" placeholder="flat, floor no., building name">
			<label>Adress  line 2</label>
		<input type="text" placeholder="Street no, village, locality">
<label>Adress  line 3</label>
		<input type="text" placeholder="Land Mark(optional)">
			<label>City*</label>
		<input type="text">
			<label>Zip/Postal Code*</label>
		<input type="text">
			<label>Country*</label>
		<input type="text">
		<input type="submit" value="Checkout">
		</form>
		</div>
		
		
		
		
		
	</div>
		
	<div class="vertical">
		<p>border</p></div>
	
	<div class="box2">
	
		
		<h1>Cart Items</h1>
<table>
<tr >
<th>Product Id</th>
<th>Product Name</th>
<th>Price</th>
</tr>
 <c:forEach var="tempProduct" items="${Product_list}">

<tr>
	<td>${tempProduct.id}</td> 
	<td>${tempProduct.name}</td> 
	<td>${tempProduct.price}</td> 
</tr>
</c:forEach>
</table>

		<div  class="all">
		<h6>Cart Totals</h6>
			<hr>
		<div class="sub">
			<h5>Sub total:  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				
				Rs ${Sum}</h5>
			<h5>Delivery:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; 
				Free </h5>
			<h5>Total:				  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				Rs ${Sum}/- </h5>
		</div>
			`</div>
		
		
	</div>
	</div>








<div class=logout>
<form action="Lougout">
<br>
<br>
<input type=submit value=Logout>
</form>
</div>




</body>
</html>