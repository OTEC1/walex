 package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import walexFab.StreamingCont;

public class RetrieveConnection {


	

	
	public String createTable() {
		String c,b=null;
		c="T".concat(b.concat("Z"));
		return c;
	}
	
	
	private void Send_in(String id,String bab,String string, String string2,  int string4, String integer,String fullname, String email,String  address,String PhoneNumber,String city, String origin,  String dates, String string3) {
		Connection con=null;
		try {
			con=new DatabaseConnection().getConnection();
			PreparedStatement pst=con.prepareStatement("insert into walexProduct"
					+ " (Fullname,Email,addresses,PhoneNumber,city,state_of_origin,NameOfClothe,"
					+ "userId,Number_of_items,Pictures,Current_Time_Stamp,item_price)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fullname);
			pst.setString(2, email);
			pst.setString(3, address);
			pst.setString(4, PhoneNumber);
			pst.setString(5, city);
			pst.setString(6, origin);
			pst.setString(7, string);
			pst.setString(8, bab);
			pst.setInt(9, string4);
			pst.setString(10,integer);
			pst.setString(11, dates);
			pst.setString(12, string3);
			
			
			pst.executeUpdate();
			delete(id);
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

	}


	

	
	private void delete(String id) {
		Connection con=null;
		try {
			con=new DatabaseConnection().getConnection();
			PreparedStatement pst=con.prepareStatement("delete from  "+createTable()+" where  id="+id);
			pst.execute();
		
		}catch (Exception e) {
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
		
	}

	
	
	

	public byte[] photo(int id) {
		Connection con=null;
		byte[] bb=null;
		try {
			con=new DatabaseConnection().getConnection();
			PreparedStatement pst=con.prepareStatement("select * from walex_uploads where id="+id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				bb=rs.getBytes(4);
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
		return bb;
		
	}


	public void cartDelete() {
		Connection con=null;
		try {
			
			con=new DatabaseConnection().getConnection();
			PreparedStatement pst=con.prepareStatement("drop table   "+createTable());
			pst.execute();
		
		}catch (Exception e) {
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
	}
	
	


	public void notification(String mainStatus, String userSession, int updter, String phone, int totaling) {
		Connection con=null;
		try {
			con=new DatabaseConnection().getConnection();
		    PreparedStatement	pst=con.prepareStatement("insert into walex_notification(status1,user_session_id,updater,phone_no,totaling) values(?,?,?,?,?)");
		
			pst.setString(1, mainStatus);
			pst.setString(2, userSession);
			pst.setInt(3, updter);
			pst.setString(4, phone);
			pst.setInt(5, totaling);
			pst.executeUpdate();
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
	}


	public byte[] limit(int women) {
		Connection con=null;
		byte[] bb=null;
		try {
			con=new DatabaseConnection().getConnection();
			PreparedStatement pst=con.prepareStatement("select * from walex_uploads where id="+women);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				bb=rs.getBytes(4);
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
		return bb;
	}


	
	
	
//	public byte[] newImage(int id) {
//	Connection con=null;
//	byte[] bb=null;
//	try {
//		 con=new DatabaseCon().getConnection();
//		PreparedStatement pst=con.prepareStatement("select * from walex_uploads where id="+id);
//		ResultSet rs=pst.executeQuery();
//		while(rs.next()) {
//			bb=rs.getBytes(4);
//		}	
//	}catch(Exception e) {
//		System.out.println(e);
//	}
//	finally {
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	return bb;
//	
//}
	}






