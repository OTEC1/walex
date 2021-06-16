package walexFab;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection getConnection() {
    
		
	Connection con = null;
    String  url= "jdbc:postgresql://localhost:5432/postgres";
	String username="postgres";
	String password="vkw6432kvze";
		
	try {
	Class.forName("org.postgresql.Driver");
	con=DriverManager.getConnection(url,username,password);
	//System.out.println("succesful");
	}catch(Exception e) {
		System.out.println(e); 
	}
	
	
		return con;
	}
	


}
