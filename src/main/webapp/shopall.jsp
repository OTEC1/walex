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
<title>WalexFabrics All categories</title>

<style>
*{
padding: 0;
margin: 0;
box-sizing: border-box;
}

.open{
width: 80%;
height: auto;
margin-left: auto;
margin-right: auto;
text-align: center;	
}


.pic{
width: 200px;
height: 250px;
margin-top:20px;
display: inline-block;
box-shadow: 0px 0px 4px 0px rgba(0,0,0,0.1);
}

#some{
height: 150px;
width: 150px;
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
content: '';
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
marquee{
color: red;
font-family: sans-serif;
    }

</style>
</head>
<body>
<jsp:include page="header_ui.jsp"></jsp:include>

<marquee>Walexfabrics give's you a nice material lace and designs. We make sure to delivery every good's and items you bought to your 
door steps. Place your Order's  and choose home delivery with your phone number. OR   You can visit
 our shopping center at 1st floor 34 tejuosho st,surulere Opp access bank.</marquee>

<div class="open">
<%
Connection con= new DatabaseConnection().getConnection();
PreparedStatement ps=con.prepareStatement("select * from walex_uploads order by id desc limit 40");
ResultSet rs=ps.executeQuery();%>	
<% while(rs.next()){%>	
<div class="pic">
<a href="cart_purchase.jsp?i=<%=rs.getString("id")%>&m=1">
<img alt="" src="Images/<%=rs.getString(4)%>" id="some" />
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