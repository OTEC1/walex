package walexFab;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.DatabaseConnection;
import server.Server_Request;
import server.utils;


@WebServlet("/calculate")
public class WalexModel extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private int price,input;
	private String id,ca,session_id;
    private	Object carry;
    private ArrayList<Map<String, Object>> second;
    private ArrayList<Map<String, Object>> list ;
    
    public WalexModel() {
        super();
    }

	
    public HttpSession start_Ses(HttpServletRequest request) {
    	HttpSession	session = request.getSession();
    	return session;
    }
    

@SuppressWarnings("unchecked")
public void Session_cart(Map<String, Object> first, HttpServletRequest request) {
list = new ArrayList<>();	    	  
list.add(first);
if(start_Ses(request).getAttribute("cart") == null) 
	   start_Ses(request).setAttribute("cart", list);
else {
	if(start_Ses(request).getAttribute("cart") != null) {
	   second = (ArrayList<Map<String, Object>>) start_Ses(request).getAttribute("cart");
	   //System.out.println(second+" B4");
	   second.add(first);
	   //System.out.println(second+" AF");
	   start_Ses(request).setAttribute("cart",second);
	  }
	}
}
    
    
 
    
public ArrayList<Map<String, Object>> cart_pay(HttpServletRequest request) {	
@SuppressWarnings("unchecked")
ArrayList<Map<String, Object>> x= (ArrayList<Map<String, Object>>) start_Ses(request).getAttribute("cart");
return x;
}


	


@SuppressWarnings("unlikely-arg-type")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
if(request.getParameter("add")!=null) {		
	 input=Integer.valueOf(request.getParameter("inputCalculate"));
	 price=Integer.valueOf(request.getParameter("price"));
	 String id=request.getParameter("id");
	 int total=input*price;
	 summer(request,total);
	 if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
	 response.setContentType("text/plain");
	 response.setCharacterEncoding("UTF-8");
     response.getWriter().write(String.valueOf(total));
 }else {
     start_Ses(request).setAttribute("total", total);	
     request.getRequestDispatcher("cart_purchase.jsp?i="+id+"&m="+input).forward(request, response);
     }
}	
else 
	if (request.getParameter("toCart")!=null){
		int tt=0;
        input=0; price=0; id=null;	 
   
Session_cart( members_of_map_list(
request.getParameter("id").toString(),
start_Ses(request).getAttribute("total").toString(),
request.getParameter("image").toString(),
request.getParameter("inputCalculate").toString(),
request.getParameter("price").toString(),
request.getParameter("item_name")), request); 

request.getRequestDispatcher("index.jsp").include(request, response);
}				
else
	if(request.getParameter("viewcart")!=null) {
		 
request.getRequestDispatcher("Cart.jsp").forward(request, response);
}
	else
		if(request.getParameter("delete")!=null) {


						
					
@SuppressWarnings("unchecked")
ArrayList<Map<String,Object>>  delete_member =  (ArrayList<Map<String, Object>>) start_Ses(request).getAttribute("cart");
//System.out.println(request.getParameter("delete")+" REMOVED");
  
  start_Ses(request).setAttribute("cart",null);
    
  for (Map<String, Object> result : delete_member) { 			  	  
	  if(request.getParameter("delete").equals(result.get("id"))) {
  long a= Long.valueOf(start_Ses(request).getAttribute("temp_total").toString());
  long  b = Long.valueOf(result.get("total").toString())-a;
  start_Ses(request).setAttribute("temp_total", String.valueOf(b).replace("-", ""));
  request.setAttribute("temp_total", String.valueOf(b).replace("-", ""));
	  
  }else
	  if(result.size()>0)
        Session_cart(members_of_map_list(result.get("id").toString(), result.get("total").toString(), result.get("image").toString(), result.get("input").toString(),result.get("price").toString(),result.get("item_name").toString()),request);
  
		  else 
			  start_Ses(request).setAttribute("temp_total", "");  
		  
	  	
  
  }		  
  request.getRequestDispatcher("Cart.jsp").forward(request, response);
			
}
else

	if(request.getParameter("pay")!=null) {
	@SuppressWarnings("unchecked")
	List<Map<String,Object>>  list =  (ArrayList<Map<String, Object>>) start_Ses(request).getAttribute("cart");
	if(checker(list,request)) {
	int k=1;

	for(Map<String, Object> m: list) {
	new utils().send_to_db(m,request);
	if(list.size() == k) {
		new utils().notify_walex(start_Ses(request).getId(),request.getParameter("phone_field"),start_Ses(request).getAttribute("temp_total"));
		reset(request,"Order Placed.");
	}
	k++;
			
	}
 }
	request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}		
}

	

private boolean checker(List<Map<String, Object>> mk, HttpServletRequest request) {
	
	if(list==null ) {
		request.setAttribute("errors", "Pls Purchase an Item !");
		return false;
	}
	 else 
	 if(list.size()<=0) {
	 request.setAttribute("errors", "Cart is empty !");
	 return false;
	 }
	 else
		 if(request.getParameter("name_field").toString().length()>0 && request.getParameter("phone_field").toString().length()>0 && request.getParameter("email_field").toString().length()>0 && request.getParameter("addresses_field").toString().length()>0) 
		 return true;
	   else {
		request.setAttribute("errors", "Pls fill out all fields !!!");
		 return false;
	  }
		
}












private void summer(HttpServletRequest request, int total) {

if(start_Ses(request).getAttribute("temp_total") == null)
start_Ses(request).setAttribute("temp_total", total);
else {
	long z = Long.parseLong(start_Ses(request).getAttribute("temp_total").toString());
long i=z+total;
start_Ses(request).setAttribute("temp_total", i);
		
}
	
}


private  Map<String,Object>  members_of_map_list(String id, String total, String image, String input, String price,String item_name) {
	
Map<String,Object> pack = new HashMap<String, Object>();
 pack.put("id", id);
 pack.put("total", total);
 pack.put("image", image);
 pack.put("input", input);
 pack.put("price", price);
 pack.put("item_name", item_name);
     
  return   pack;   
}




	




private void reset(HttpServletRequest request,String c) {
	request.setAttribute("errors", c);
	start_Ses(request).setAttribute("cart", null);
	start_Ses(request).setAttribute("temp_total", null);
	start_Ses(request).invalidate();
}








}
