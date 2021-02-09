package DBCONNECT;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseCon {




	
	
	public  Connection getConnection() {
			Connection con=null;
				try {
					 Class.forName(Cre.driver);
					  con=DriverManager.getConnection(Cre.url, Cre._user, Cre._pass);
					  //System.out.println("Connected");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				return con;
	}
	
	
	


}
