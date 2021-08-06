package server;

public interface Cre {


		
	//Chibueze this credentails need to be hashed  ok ... !
	
     String http = "Images/";    //"https://walexbucket.s3.eu-west-3.amazonaws.com/";	
	
//    //Production
//		 static String 
//	         USER="walexfab_walexuser",  
//	         PASS="7h8g2cc",
//	         URL="jdbc:mariadb://localhost/walexfab_walex01",
//	         ACCESS_KEY_ID="AKIAYDAUUBKQ5QPLZFMW", 
//	      	 ACCESS_SEC_KEY="pg10NPo1fUuD+1hc5tg/1bmdobl1v7nSXARAjPkd",   
//	    	 bucket="walexbucket";

	
	
		//development
		 public static final  
		         String  
		         URL= "jdbc:mariadb://localhost:3306/walexfab_walex01", 
		         ACCESS_KEY_ID="AKIAYDAUUBKQ5QPLZFMW", 
		         ACCESS_SEC_KEY="pg10NPo1fUuD+1hc5tg/1bmdobl1v7nSXARAjPkd",
		         bucket="walexbucket",
		         PASS="7h8g2cc",  
		         USER="root";
		 
		 
		




}





