package Uploads;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import DBCONNECT.Cre;
import server.Server_Request;

@ManagedBean
@RequestScoped
public class update_sec {
	
	private String id;
       String	 writeUp,price;

	Server_Request  request=new Server_Request();
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getWriteUp() {
		return writeUp;
	}




	public void setWriteUp(String writeUp) {
		this.writeUp = writeUp;
	}




	public String getPrice() {
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}


	public String delete() {
		
		
		if(	new Singleton().getChain().trim().length()==0)
			message("pls sign in");
		else {
			FacesContext context=FacesContext.getCurrentInstance();
			int c=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("x7"));
			String h=(context.getExternalContext().getRequestParameterMap().get("x9"));
			
			System.out.println(h+c);
				int b=	request.delete_post(c);
	     	       request.delete_single_item(Cre.bucket,h);
		if(b==200)
			message("deleted Successfully ");
		else
			message("Sorry an Errro Occured");
		}
	return null;}
	

	
	public String name() {
		FacesContext context=FacesContext.getCurrentInstance();
		int c=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("x99"));
		
		if(price.trim().length()>0) {
		  int v =request.Update_Price(c,price);
			  alert(v);
		}
		else if(writeUp.trim().length()>0) {
			  int n =	request.Update_Write(c,writeUp);
			  alert(n);
		}
		else   if(writeUp.trim().length()>0  && price.trim().length()>0){
		 int s=	request.Update_Post(c,price,writeUp);
		  alert(s);
		}else
		message("Fill out all the  Fields");
		
	return "/editing.xhtml";
	}
	
  
	
	public String update() {
		
		FacesContext context=FacesContext.getCurrentInstance();
		int c=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("x5"));
	
		if(	new Singleton().getChain().trim().length()==0)
			message("pls sign in");
		else
	request.retrieveUpdate(c);
	  return  "/CP4.xhtml?faces-redirect=true";
		}
	
	
	
	
	
	private void alert(int x) {
		if(x==200)
			message("Updated Successfully ");
		else
			message("Sorry an Error  Occured");
		
	}


	
	public String home() {
		
	  return  "/CP1.xhtml?faces-redirect=true";}


	private void message(String str) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage  message= new FacesMessage(FacesMessage.SEVERITY_INFO,"", str);
		  context.addMessage(null, message);
		
	}

}
