 <%@page import="java.util.Iterator"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="walexFab.WalexModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Walexfabrics Cart Section</title>
<script src="js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/cart1.css"/>
</head>
<body>

<jsp:include page="header_ui.jsp"></jsp:include>
	
<div  class="container cart-page">
<center>${errors}</center>
<table>
<tr>
<th>&nbsp;&nbsp; Product</th>
<th>Quantity</th>
<th>Subtotal &nbsp;</th>
</tr>



<tr>
<%
		  
//Get main cart to display   Add empty Space in list and check for two user
if(new WalexModel().cart_pay(request) != null){
    @SuppressWarnings("unchecked") 
    ArrayList<Map<String, Object>> list=	(ArrayList<Map<String, Object>>) new WalexModel().start_Ses(request).getAttribute("cart");
for (Map<String, Object> result : list) {%>
<td>		
<div class="cart-info">
<img  src="<%=result.get("image")%>"  style="width: 150px; height: 150px"/>
<input type="hidden" name="image" value="<%=result.get("image")%>">
<div>
<p><%=result.get("item_name")%></p>
<small>Price:<%=result.get("price")%>
<input type="hidden" name="price" value="<%=result.get("price")%>"></small>
<br>

<form action="calculate"   method="post">
<button value="<%=result.get("id")%>" name="delete" id="button" >delete</button>
</form>
</div>
</div>
</td>

<td>
<%=result.get("input")%>
</td>
<td>Total:<%=result.get("total")%> 
<input type="hidden" name="total" value="<%=result.get("total")%>"> 
</td>
</tr>
<%}
System.out.println(list); 
}%>
</table> 
<br/><br/>
<div class="total-price">
<table>
<tr>
<td>Sub total</td>
<td>N ${temp_total}</td>
</tr>
<tr>
<td>Tax</td>
<td>$0.00</td>
</tr>
<tr>
<td>Total</td>
<td>N ${temp_total}</td>
</tr>
</table>
</div>
</div>




<form action="calculate"   method="post">	
<center  class="down_space">
<input class="input_space"   name="name_field"  placeholder="Name">
<input class="input_space"   name="email_field"  placeholder="Email">
<input class="input_space"   name="addresses_field"  placeholder="Address">
<input class="input_space"   name="phone_field"  placeholder="Phone">
<input class="input_space"   name="city_field"  placeholder="City (Optional)">
<input class="input_space"   name="state_of_origin_field"  placeholder="State (Optional)">
<button class="pay_button"   name="pay" id="button" >Check out</button>
</center>
</form>


</body>
</html>