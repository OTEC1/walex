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

	<form action="calculate"   method="post">
		<div  align="center">
		<%
		  
		  //Get main cart to display and delete afterwards
		  
		  Object builder = null;
		
		  	if(new WalexModel().cart_pay(request) != null){
		  		builder =new WalexModel().cart_pay(request);	  
		         System.out.println("A called ! ");
		  	}
		  	
				if(new WalexModel().cart_pay2(request) == null){
					 new WalexModel().Session_cart2(builder, request, 1);
					 System.out.println("B called ! ");
				
				}
				
					if(new WalexModel().cart_pay2(request) != null && new WalexModel().cart_pay(request) == null){
						builder= new WalexModel().cart_pay2(request);
						       System.out.println("C called ! ");
					}
		
		
		
		
		
					StringBuilder x = new StringBuilder(String.valueOf(builder));
		  
			int a=x.length();
			for(int w=0; w<=a; w++) {
				int n=x.indexOf("|")+1;
				String c=x.substring(0, n);
				
				
				//check value
				//cart1
				
				//formating();
				int ns=0;
				StringBuilder b=new StringBuilder(c);%>
				
				<% int q=b.length(); int o=0;
				for(int wp=0; wp<=q; wp++) {
					 ns=b.indexOf(":")+1;
					  String s=b.substring(0, ns);
					  
					    if(s.trim().length()>0) {
					    	
							   String v=s.replace(":", "").trim(); o++;
							
							   if(o==2){%>
							           <img  src="<%=v%>"  style="width: 150px; height: 150px"/>
							           <input name="sub"  type="submit" id="button" value="X"/>
							           <%}
								
							   if(o==3){%>
							          <h5>Quantity: <%=v%></h5>
							          <%}
								 
							   if(o==4){%>
							         <h5>Price: <%=v%></h5>
							          <%}
							   
							   if(o==5){%>
							        <h5>id: <%=v%> <input type="hidden" name="ID" value="<%=v%>" ></h5>
							         <%}
							   
							   if(o==6){%>
							         <h5>Total: <%=v%></h5>
							         <%}
					        }   
					b=b.delete(0, ns);
					q=q-ns;
				  }	
				StringBuilder v=x.delete(0, n);
				new WalexModel().Session_cart(v, request,3);	
				a=a-n;
				%>
			   
			<%}%>
				
		</div>
		</form>

	
</body>
</html>