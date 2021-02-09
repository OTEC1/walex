/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uploads;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

import server.Server_Request;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class Login_Register {

    /**
     * Creates a new instance of Login_Register
     */
    
    

   static String user=" ",password=" ";

		




			
			    public String getUser() {
			        return user;
			    }
			
			    public void setUser(String user) {
			        this.user = user;
			    }
			
			    public String getPassword() {
			        return password;
			    }
			
			    public void setPassword(String password) {
			        this.password = password;
			    }
			
			
			    
			    public void spill1() {
			        	
			    	if(validate(user)==1) {
			    		 message("Invalid email ! ");
			    	}
			    	System.out.println(user );
			    		
			    	}
			    
			
			    public void spill3() {
			    System.out.println(password);
			  	}
		
			    
			    

     
    
			    
			public String name() {
				
				 int c =   	  new Server_Request().authenticate_admin(user.toLowerCase(),password.toLowerCase());
			     
			     if(c==1) {
			    	 			setUser("");   setPassword("");
			    	 return "/CP1.xhtml?faces-redirect=true";
			     }
			     else {
			    	 message("Sign in failed ! ");
			     setUser("");   setPassword("");
			     }
			    	
			     
			     return  null;
			
			}    
     
  



    


     
     public void message( String h) {
    	  RequestContext  requestContext=RequestContext.getCurrentInstance();
          requestContext.execute("swal('"+h+"')");
    	
	}
     
     
    
     
     public  int validate(String f){
         int g=0;
         Pattern mask=null;

         mask=Pattern.compile(".+@.+\\.[a-z]+");
         Matcher matcher=mask.matcher(f);
         if(matcher.matches())
            g=2;
         else
           g=1;
        return  g;
     }
}
