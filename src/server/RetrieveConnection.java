 package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import DBCONNECT.DatabaseCon;
import uploadData.StreamingCont;
import uploadData.Submit;

public class RetrieveConnection {
	
private DatabaseCon data;
DatabaseCon db=new DatabaseCon();


	
	
	public List<StreamingCont>  list() {
	
		
		List<StreamingCont> lis=new ArrayList<StreamingCont>();
		
		Connection con=null;
			
		try {
			
			 con=new DatabaseCon().getConnection();
		
			PreparedStatement pst=con.prepareStatement("select * from walex_uploads order by id desc  limit 4 ");
			ResultSet rs=pst.executeQuery();
			 
			while(rs.next()) {
			
			StreamingCont cont=new StreamingCont();
			cont.setId(rs.getString(1));
			cont.setItemComment(rs.getString(2));
			cont.setPrice(rs.getString(3));
			cont.setPicname(rs.getString(4));
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


	
	
	public List<StreamingCont>  readers(String f){
		
		List<StreamingCont> lis=new ArrayList<StreamingCont>();
		
		Connection con=null;
		
		try {
			 con=db.getConnection();
		
			PreparedStatement pst=con.prepareStatement("select * from  "+createTable()+" where userId  like '%"+f+"%'  order by id desc ");
		    ResultSet	ers=pst.executeQuery();
			while (ers.next()) {
			StreamingCont  pack=new StreamingCont();
			pack.setId(ers.getString(1)); //id
			pack.setName(ers.getString(6)); //name
			pack.setPrice(ers.getString(3)); //price
			pack.setUserauto_gen(ers.getString(4)); //userid
			pack.setPhotos(ers.getString(2)); //photo
			pack.setItemComment(ers.getString(7));
			pack.setItemqua(ers.getString(5));
			pack.setItemtotal(ers.getString(9));
			
			lis.add(pack);
			
			}
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
		
			return lis;}
	
	
	
	public void total_price (String x){
		Connection con=null;
		
		try {
			 con=db.getConnection();
		
			PreparedStatement pst=con.prepareStatement("select sum(price)  as total from "+createTable()+" where userId  like '%"+x+"%'");
		    ResultSet ers=pst.executeQuery();
			while (ers.next()) {
			StreamingCont  pack=new StreamingCont();
			pack.setTotalAmount(ers.getString("total")); //totalamount 
			}
		
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
	public String createTable() {
		String c,b;
		b= new StreamingCont().http();
		c="T".concat(b.concat("Z"));
		return c;
	}
	
	
	public void insert(String a, int priceId, String nameId, String baba, long x3, String baba2, int i, long x32) {
	
		Connection	con=null;
//		

		
	String create_table="create table if not exists "+createTable()+"(id serial ,name varchar(100)"
		+ ",price int,userId varchar(100), items int,photo varchar(200), itemComm varchar(100),itemqua int, itemtotal int);";
	
		try {
		con=new DatabaseCon().getConnection();
		Statement stmt=con.createStatement();
		stmt.execute(create_table);
		System.out.println("table created");
	      PreparedStatement	pst=con.prepareStatement("insert into "+createTable()+" (name,price,UserId,items,photo,itemComm,itemqua,itemtotal) values(?,?,?,?,?,?,?,?)");
	
		pst.setString(1, nameId);
		pst.setInt(2, priceId);
		pst.setString(3, baba);
		pst.setLong(4, x3);
		pst.setString(5, a);
		pst.setString(6, baba2);
		pst.setInt(7, i);
		pst.setLong(8, x32);
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
		
		System.out.println(createTable());
		
	}
	

	public List<StreamingCont>  list5() {
		List<StreamingCont> lis=new ArrayList<StreamingCont>();
		
		Connection con=null;
			
		try {
			 con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from walex_uploads order by id desc  limit 10 ");
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()) {
			
			StreamingCont cont=new StreamingCont();
		 	cont.setId(rs.getString(1));
		 	cont.setItemComment(rs.getString(2));
        	cont.setPrice(rs.getString(3));
        	cont.setPicname(rs.getString(4));
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
	
	
	
	
	public void drop(int sd) {
		Connection con=null;
	try {
		con=db.getConnection();
	   PreparedStatement	pst=con.prepareStatement("delete from "+createTable()+" where id="+sd);
		pst.execute();
		System.out.println(sd);
	} catch (Exception e) {
		e.printStackTrace();
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


	public void submitAll(String fullname, String email, String address, String string2, String city, 
			String origin,String string, String baba, int bb, String a, String ded , String b) {
	
		Connection con=null;
		try {
			
			con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into walexProduct"
					+ " (Fullname,Email,addresses,PhoneNumber,city,state_of_origin,NameOfClothe,"
					+ "userId,Number_of_items,Pictures,Current_Time_Stamp,item_price)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fullname);
			pst.setString(2, email);
			pst.setString(3, address);
			pst.setString(4, string2);
			pst.setString(5, city);
			pst.setString(6, origin);
			pst.setString(7, string);
			pst.setString(8, baba);
			pst.setInt(9, bb);
			pst.setString(10,a);
			pst.setString(11, ded);
			pst.setString(12, b);
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
	
	
	

	private void Send_in(String id,String bab,String string, String string2,  int string4, String integer,
			String fullname, String email,String  address,String PhoneNumber,String city, String origin,  String dates, String string3) {
		Connection con=null;
		try {
			
			con=db.getConnection();
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


	public void check_cart_for_session_id(String ded, String fullname, String getEmail,String  Address, String PhoneNumber,String City, String Origin,int bv , String dc) {
		Connection con=null;
		try {
			
			con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from  "+createTable()+" where  userId like '%"+ded+"%'");
			ResultSet  rs=pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getFetchSize());
				Send_in(rs.getString(1),ded,rs.getString(2), rs.getString(4),Integer.valueOf(rs.getString(5)), (rs.getString(6)),  fullname,  getEmail,  Address, PhoneNumber, City,  Origin ,dc,rs.getString(3));
			}
			if(rs.getFetchSize()==0) {
				     cartDelete();
					new Submit().http_invalidate();
				System.out.println("All droped !  ");
			}
			
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



	
	private void delete(String id) {
		Connection con1=null;
		try {
			
			con1=db.getConnection();
			PreparedStatement pst=con1.prepareStatement("delete from  "+createTable()+" where  id="+id);
			pst.execute();
		
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con1.close();
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
			 con=new DatabaseCon().getConnection();
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
		Connection con1=null;
		try {
			
			con1=db.getConnection();
			PreparedStatement pst=con1.prepareStatement("drop table   "+createTable());
			pst.execute();
		
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}


	public void notification(String mainStatus, String userSession, int updter, String phone, int totaling) {
		Connection con=null;
		try {
			con=new DatabaseCon().getConnection();
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
			 con=new DatabaseCon().getConnection();
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


	public List<StreamingCont> subIN(String x) {
		List<StreamingCont>  pack=new ArrayList<StreamingCont>();
		
		Connection  cons;
			cons=db.getConnection();
			PreparedStatement ps;
			try {
				ps = cons.prepareStatement("select sum(itemtotal)  as total from "+createTable()+" where userid  like '%"+x+"%'");
				ResultSet  rs=ps.executeQuery();
				while (rs.next()) {
				
					StreamingCont cont=new StreamingCont();
					
					cont.setTotalAmount(rs.getString("total"));
					pack.add(cont);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					cons.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		return pack;
	}


	public List<StreamingCont> sums(String baba) {
				
		List<StreamingCont>  pack=new ArrayList<StreamingCont>();
		
		Connection  cons;
			cons=db.getConnection();
			PreparedStatement ps;
			try {
				ps = cons.prepareStatement("select sum(itemqua)  as iteming from "+createTable()+" where userId  like '%"+baba+"%'");
				ResultSet  rs=ps.executeQuery();
				while (rs.next()) {
				
					StreamingCont cont=new StreamingCont();
					cont.setC(rs.getString("iteming"));
					pack.add(cont);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					cons.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		return pack;
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






