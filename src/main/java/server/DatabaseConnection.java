package server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

//	public Connection getConnection() {
//    
//		
//	Connection con = null;
//    String  url= "jdbc:postgresql://localhost:5432/walexfab_walex01";
//    String username="postgres";
//	String password="xavier3456";
//		
//	try {
//	Class.forName("org.postgresql.Driver");
//	con=DriverManager.getConnection(url,username,password);
//	
//	}catch(Exception e) {
//	System.out.println(e); 
//	}
//	return con;
//	}	
	
	
	    
	 
	 
	 
	 public Connection getConnection() {
			Connection con = null;
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
			   }catch (Exception e) {
				System.out.println(e);
			}
		
			try {
				con = DriverManager.getConnection(Cre.URL, Cre.USER,Cre.PASS);
				}catch (Exception e) {
				System.out.println(e);
			}
			
			
			return con;
		}


}
