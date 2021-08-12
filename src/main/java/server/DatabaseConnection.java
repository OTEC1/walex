package server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


	    
	 
		 
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
