<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="walexFab.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

.image{
width: 100%;
height: 450px;
margin-top: 10px;
}
.total{
float: right;
color: #000000;
font-size: 30px;
font-weight: 600;
padding-top: 20px;
}
.new-arrival{
background: green;
width: 50px;
color: #fff;
font-size: 12px;
font-weight: bold;
margin-top: 20px;
}
.fa{
color: orange;
}
.price{
color: orange;
font-size: 26px;
font-weight: bold;
padding-top: 20px;
}
.inp{
border: 1px solid #ccc;
font-weight: bold;
height: 33px;
text-align: center;
width: 30px;
margin: 5px;
}
.btn-primary{
background: orange;
color: #fff;
font-size: 15px;
margin-left: 20px;
border: none;
box-shadow: none;
}
.btn{
font-size: 20px;
}
</style>
</head>
<body>
<jsp:include page="header_ui.jsp"></jsp:include>

<div class="container">
<div class="row">
<%

String x =request.getParameter("i");
Connection con= new DatabaseConnection().getConnection();
PreparedStatement ps=con.prepareStatement("select * from walexfab_walex01 where id ="+Integer.valueOf(x));
ResultSet rs=ps.executeQuery();
while(rs.next()){%>
<div class="col-md-5"> 
<img alt="<%=rs.getString(2)%>" src="Images/<%=rs.getString(4)%>" class="image" >
</div>
 <div class="col-md-7">
<p class="new-arrival text-center">New</p>
<h2><%=rs.getString("NameClothes")%></h2>
<p>Product Code:walexfab2000</p>
<i class="fa fa-star"></i> 
<i class="fa fa-star"></i> 
<i class="fa fa-star"></i> 
<i class="fa fa-star-o"></i>
<i class="fa fa-star-half-o"></i> 
<form action="calculate" method="post" id="calculate">
<p class="price" > bhNGN<input value="<%=rs.getString("price")%>"name="price" style="border: none;width:50px;"></input><label>Per yard</label></p>
<p class="total">Total:<input id="result" style="border:none;width:100px;" value="${total}" readonly="true"/>
<input name="totals"  type="hidden"   value="<%=request.getAttribute("total")%>"/></p>
<input type="text" readonly="true"  value="Images/<%=rs.getString(4)%>" name="image"/>
<%}%>

<p><b>Availability:</b> In Stock</p>
<p><b>Condition:</b>New</p>
<p><b>Brand</b> WALEXFABRICS GLOBAL RESOURCES LIMITED.</p>
<p><b>Quantity:</b> In Stock</p>
<input type="hidden" name="id" value="<%=x%>"/>
<input type="submit" value="calculate" id="e1" class="btn increment" name="add"/> 
<input type="text"  value="<%=request.getParameter("m")%>" class="inp"  name="inputCalculate"/>

<button   class="btn decrement"  name="toCart">Add to cart<i class="fa fa-shopping-cart"></i>
</button>
<input type="submit" value="view cart" class="btn btn-primary" name="viewcart"/>
</form>

</div>
</div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>