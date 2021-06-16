 <%@page import="java.util.Iterator"%>
<%@page import="walexFab.model"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="walexFab.WalexModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Insert title here</title>
<script src="js/jquery-2.1.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$('#button').click(function(e){
		e.preventDefault();
		var ajaxdata=$('#builder').val();
		var value='country='+ajaxdata;
		$.ajax({
			url:'savelt',
			type:'post',
			data:value,
			success:function(data){
				$('#builder').val('');
				$('#message').html(data).slideDown('slow');
			}
		});
	});
});
</script>

	
		<div  align="center">
		<%
		  
		  //Get main cart to display   Add empty Space in list and check for two user
		  
		  	if(new WalexModel().cart_pay(request) != null){
		  	    @SuppressWarnings("unchecked") 
		  	    ArrayList<Map<String, model>> list=	(ArrayList<Map<String, model>>) new WalexModel().start_Ses(request).getAttribute("cart");
		  	    
		  	  for (Map<String, model> result : list) {  
	  		   %>
	  		  <img  src="<%=result.get("image")%>"  style="width: 150px; height: 150px"/>
	  		  <input type="hidden" name="image" value="<%=result.get("image")%>">
	  		 
	  		   <form action="calculate"   method="post">
	  		     <input name="delete"  type="submit" id="button" value="<%=result.get("id")%>">
	  		   </form>
	  		  
	  		  <h5>Quantity: <%=result.get("input")%></h5>
	  		  <input type="hidden" name="input" value="<%=result.get("input")%>">
  		  
	  		  <h5>Price: <%=result.get("price")%></h5>
     		  <input type="hidden" name="price" value="<%=result.get("price")%>">
	  		  
	  		  <h5>id: <%=result.get("id")%></h5>
      		  <input type="hidden" name="ED" value="<%=result.get("id")%>">
	  		  
	  		  <h5>Total: <%=result.get("total")%></h5> 
	  		  <input type="hidden" name="total" value="<%=result.get("total")%>">
	  	      
	  	      <%}
		  	    System.out.println(list); 
		  	}%>
					            
					 
					    
				
		</div>
		

	
</body>
</html>