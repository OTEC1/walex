package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import walexFab.WalexModel;

public class utils {
	
public  String time_save(){
 String o=null;
 ZonedDateTime z= ZonedDateTime.now();
 LocalTime time= LocalTime.now();
 int g=z.toString().indexOf("[");
 int c=z.toString().indexOf("]");
 int d=z.toString().indexOf("T");
 String q=z.toString().substring(g+1, c);
 for(String h : ZoneId.getAvailableZoneIds()){ 
   if(h.equals(q)){        
        o=(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
             break; 
       }  }
 return  o;}
		

    public  String date_save(){
        String o=null;
     ZonedDateTime z= ZonedDateTime.now();
     int g=z.toString().indexOf("[");
 int c=z.toString().indexOf("]");
 int d=z.toString().indexOf("T");
     String q=z.toString().substring(g+1, c);
     for(String h : ZoneId.getAvailableZoneIds()){ 
       if(h.equals(q)){        
            o=(z.toString().substring(0,d));
             break; 
       }  }
 return  o;}

    
    

@SuppressWarnings("unused")
public void send_to_db(Map<String, Object> map, HttpServletRequest request) {
	Connection con = new DatabaseConnection().getConnection();
	try {
	PreparedStatement ps=con.prepareStatement("insert into walexProduct(Fullname,Email,addresses,PhoneNumber,city,state_of_origin,NameOfClothe,userId,Number_of_items,Pictures,Current_Time_Stamp,item_price) values(?,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setString(1, request.getParameter("name_field"));
	ps.setString(2,  request.getParameter("email_field"));
	ps.setString(3,  request.getParameter("addresses_field"));
	ps.setString(4,  request.getParameter("phone_field"));
	ps.setString(5,  request.getParameter("city_field"));
	ps.setString(6,  request.getParameter("state_of_origin_field"));
	ps.setString(7, map.get("item_name").toString());
	ps.setString(8, new WalexModel().start_Ses(request).getId());
	ps.setString(9, map.get("input").toString());
	ps.setString(10, map.get("image").toString());
	ps.setString(11,  new utils().time_save());
	ps.setString(12, map.get("price").toString());
	ps.execute();
	}catch (Exception e) {
		System.out.println(e);
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}



public void notify_walex(String id, Object phone, Object total) {
	Connection con= new DatabaseConnection().getConnection();
	try {
	
		PreparedStatement ps=con.prepareStatement("insert into walex_notification(user_session_id,status1,updater,phone_no,totaling) values(?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, "New");
		ps.setInt(3, 0);
		ps.setString(4, phone.toString());
		ps.setString(5, total.toString());
		ps.execute();	
	  }catch (Exception e) {
		System.out.println(e);
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}




}
