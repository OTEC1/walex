package walexFab;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WalexModel
 */
@WebServlet("/calculate")
public class WalexModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private int price,input;
	private String id,ca;
    private	Object carry;
    private ArrayList<Map<String, Object>> second;
    ArrayList<Map<String, Object>> list ;
	
    public WalexModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
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
		     start_Ses(request).setAttribute("total", total);	
	        request.getRequestDispatcher("cart_purchase.jsp?i="+id+"&m="+input).forward(request, response);
		}
		
		
		
		
		else
			if(request.getParameter("toCart")!=null) {
			
				 input=0; price=0; id=null;
				
			    		
			     Session_cart( members_of_map_list(request.getParameter("id").toString(),start_Ses(request).getAttribute("total").toString(),
			    		 request.getParameter("image").toString(),
			    		 request.getParameter("inputCalculate").toString(),
			    		 request.getParameter("price").toString()), request);
			     

			    request.getRequestDispatcher("index.jsp").forward(request, response);
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
				  		  if(request.getParameter("delete").equals(result.get("id"))) 
				  			  System.out.println("OK");
				  		  else 
				  			Session_cart(members_of_map_list(result.get("id").toString(),result.get("total").toString(),result.get("image").toString(),result.get("price").toString(),result.get("input").toString()),request);
				  	      } 
				  	  
					request.getRequestDispatcher("Cart.jsp").forward(request, response);
					
				
				}
		
		
			 
				
                  }

	
	private  Map<String,Object>  members_of_map_list(String id, String total, String image, String input, String price) {
		
		Map<String,Object> pack = new HashMap<String, Object>();
	     pack.put("id", id);
	     pack.put("total", total);
	     pack.put("image", image);
	     pack.put("input", input);
	     pack.put("price", price);
	     
	  return   pack;
		
	     
	}

	
	





}
