package uploadData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBCONNECT.DatabaseCon;

public class Organza {
	
	DatabaseCon db=new DatabaseCon();

	public List<StreamingCont>  listOrganza() {
		List<StreamingCont> lis=new ArrayList<StreamingCont>();
		
		Connection con=null;
			
		try {
			 con=db.getConnection();
		
			PreparedStatement pst=con.prepareStatement("select * from walex_uploads where cats='Organza'");
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()) {
			
				StreamingCont cont=new StreamingCont();
			 	cont.setId(rs.getString(1));
			 	cont.setItemComment(rs.getString(2));
	        	cont.setPrice(rs.getString(3));
				cont.setName(rs.getString(5));
		     	lis.add( cont);
			}	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lis;
	}
	
	
	public  List <StreamingCont>list() {
		List<StreamingCont> list=new ArrayList<>();
		Connection con=null;
		
		try {
			 con=db.getConnection();
//			
			PreparedStatement pst=con.prepareStatement(" select * from walex_uploads where cats like '%Organza%'  order by id desc limit 6");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
			
				StreamingCont cont=new StreamingCont();
			 	cont.setId(rs.getString(1));
			 	cont.setItemComment(rs.getString(2));
	        	cont.setPrice(rs.getString(3));
	        	cont.setPicname(rs.getString(4));
				cont.setName(rs.getString(5));
				list.add( cont);
			}	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
