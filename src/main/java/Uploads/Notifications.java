package Uploads;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import server.Server_Request;

@ManagedBean
@RequestScoped
public class Notifications {

	
	
	
	
	static String noti;
	 Singleton  singleton=new Singleton();
	public String getNoti() {
		return noti;
	}

	public void setNoti(String noti) {
		this.noti = noti;
	}
	  
	
	
	public void read_noti() {
		   setNoti(new Server_Request().read_orders());
	
	}
	  
	
	
}
