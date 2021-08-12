<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="server.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Walexfabrics  Categories</title>
<style>

.open{
width: 80%;
height: auto;
margin-left: auto;
margin-right: auto;
text-align: center;
}
.pic{
width: 200px;
height: 270px;
text-align:center;
box-shadow: 0px 20px 30px  rgba(0,0,0,0.2);
border-radius:10px;
display: inline-block;
margin: 2px;
}

#some{
height: 180px;
width: 100%;

}

.on-sale{
margin-top: 50px;
}

.title-box{
background: orange;
color: white;
width: 180px;
padding: 4px 20px;
height: 50px;
margin-bottom: 30px;
display: flex;
}
.title-box h2{
font-size: 20px;
color:#ffffff;
margin-top: 10px;
}
.title-box::after{
border-top: 40px solid orange;
border-right: 70px solid transparent;
position: absolute;
display: flex;
margin-top: -4px;
margin-left: 130px;
}
.product-bottom .fa {
color: orange;
font-size: 10px;
}



@media(max-width:790px) {

.pic{
width: 80%;
height: 280px;
}
	
}

</style>
   
</head>
<body>
<jsp:include page="header_ui.jsp"></jsp:include>

<div class="open">

<%
String x =request.getParameter("m");
Connection con= new DatabaseConnection().getConnection();
PreparedStatement ps=con.prepareStatement("select * from walex_uploads where cats like '%"+x+"%'");
ResultSet rs=ps.executeQuery();
while(rs.next()){%>
<div class="pic">
<a href="cart_purchase.jsp?i=<%=rs.getString("id")%>&m=1">
<img alt="" src="Images/<%=rs.getString(4)%>" id="some"/>
</a>

<div class="product-bottom text-center">
<i class="fa fa-star"></i> 
<i class="fa fa-star"></i> 
<i class="fa fa-star"></i> 
<i class="fa fa-star"></i> 
<i class="fa fa-star-half-o"></i> 
</div>
<h4>
<%=rs.getString("price")%>
</h4>

<h5>
<%=rs.getString("writeup")%>
</h5>
</div>
<%}%>


</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>