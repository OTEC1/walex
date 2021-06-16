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
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      

<link rel="icon" href="image/back.jpg" sizes="40x40" type="image/png"/>
		 <link href="css/bootstrap.min.css" rel="stylesheet"/>
		 <link href="css/bootstrap.css" rel="stylesheet"/>
       <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>      
                       <!-- fontawesome -->
       
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
           crossorigin="anonymous"/>          
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"> </script>
         <script src="js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="js/bootstrap. min.js"></script>
     <script src="https://kit.fontawesome.com/yourcode.js"></script>  
     
     
<style type="text/css">

 
.bg-steel {
  background-color:orange  ;
}

.site-header .navbar-nav .nav-link {
  color:#ffffff;
  font-size: 18px;
  font-family: Stika small;
}

.site-header .navbar-nav .nav-link:hover {
  color:  #cbd5db;
}

.site-header .navbar-nav .nav-link.active {
  font-weight: 500;
}

</style>
</head>
<body>

<header class="site-header">
<nav class="navbar navbar-expand-md navbar-dark bg-steel fixed-top">
<div class="container">
<a class="navbar-brand mr-4" href="index.jsp">WalexFabrics</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarToggle" aria-controls="navbarToggle" aria-expanded="false" aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarToggle">
<div class="navbar-nav mr-auto">
            <%
Connection con= new DatabaseConnection().getConnection();
PreparedStatement ps=con.prepareStatement("select * from walex_uploads limit 5");
ResultSet rs=ps.executeQuery();%>	
<%while(rs.next()){%>	

<a class="nav-item nav-link" href="categories.jsp?m=<%=rs.getString("cats")%>"><%=rs.getString("cats")%></a>
<%} %>
</div>
<div class="navbar-nav">
<a class="nav-item nav-link" href="Cart.jsp?x=0000"><i class="fa fa-shopping-basket"></i></a>
</div>
</div>
</div>
</nav>
</header>
    
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    
</body>
</html>