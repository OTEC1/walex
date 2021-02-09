package server;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.context.FacesContext;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import DBCONNECT.Cre;
import DBCONNECT.DatabaseCon;
import Uploads.DownloadSsec;
import Uploads.Singleton;
import Uploads.update_sec;

public class Server_Request {

	
	
		   AmazonS3 s3 = null;
			public void Create_BucketS3() {
			
				AWSCredentials   credentials =new
						BasicAWSCredentials(Cre.ACCESS_KEY_ID, Cre.ACCESS_SEC_KEY);
				    s3= AmazonS3ClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credentials))
					.withRegion(Regions.EU_WEST_3)
					.build();
					    
					  if(!s3.doesBucketExistV2(Cre.bucket)) {
					  try {
						    s3.createBucket(Cre.bucket);
					  }catch (Exception e) {
						    System.out.println(e);
					}
					  
					  }
				}
	
	
	
			public void List_Bucket() {
		
				 List<Bucket> bucket =s3.listBuckets();
				 
				 for(Bucket  b : bucket) {
					 
				 }
			}
	
	
			public void Upload_file(String bucket, String key_name, InputStream  file_path, ObjectMetadata bs) {
						try {
							Create_BucketS3();
							//	s3.putObject(bucket, key_name,new File(file_path));
								s3.putObject(bucket, key_name, file_path,bs );
							}catch (Exception  e) {
									System.out.println(e );
					}
				}




			public void delete_single_item(String bucket_name, String object_key) {
					try {		
						Create_BucketS3();
							s3.deleteObject(bucket_name, object_key);
						}catch (AmazonServiceException e) {
							System.out.println(e);
						}
			}
			
			
			public void delete_bucket(String bucket_name) {
				
				try {		
					Create_BucketS3();
						s3.deleteBucket(bucket_name);
					}catch (AmazonServiceException e) {
						System.out.println(e);
					}
			}







			public byte [] read_img(String bucketname, String keyname) {	
						byte[]  by =null;
						Create_BucketS3();
						S3Object object =  s3.getObject(bucketname, keyname);
						S3ObjectInputStream inputStream=object.getObjectContent();
					   try {
						 //by=IOUtils.toByteArray(inputStream);
						//  IOUtils.copy(objectContent, new FileOutputStream("D://upload//test.jpg"));  //for downloads
							
						  by=IOUtils.toByteArray(inputStream);
					} catch (IOException e) {
						e.printStackTrace();
					}
						return   by;
			}


 
	
	public int put_in(String w1, String w2, String name, String cats) {
				//   Connection  con=new Mariadb().Connects();
		int y=0;	    
		Connection  con=new DatabaseCon().getConnection();
					try {
						PreparedStatement  ps=con.prepareStatement("insert into walex_uploads (writeup,price,picname,cats)  values(?,?,?,?)");
						ps.setString(1, w1);
						ps.setString(2, w2);
						ps.setString(3, name);
						ps.setString(4, cats);
						y=1;
						ps.execute();
						} 
					catch (SQLException e) {
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
		
					return y;
	}
	
	
	
	




					public String  read_orders() {
						String jk=null;
						   Connection  con=null;
							try {
										//new Mariadb().Connects();
										con= new DatabaseCon().getConnection();
										PreparedStatement  ps=con.prepareStatement("select sum(updater)  as jk  from walex_notification  where   status1   like  '%New%' ");
										ResultSet  rs=ps.executeQuery();
								while (rs.next()) {
										
									Integer  ing=Integer.valueOf(rs.getString("jk"));
									if(ing==null)
										System.out.println("notification is null");
									else
										jk="+ "+rs.getString("jk");	
										
								}
							}catch (Exception e) {
									System.out.println(e);
							}
					  return    jk;
					}



	
	public List<DownloadSsec> view_notifications() {
		Connection  cons=null;
		List<DownloadSsec>  packing=new ArrayList<>();
		
		try {
			
			 //new Mariadb().Connects();
			  cons = new DatabaseCon().getConnection();
					
			PreparedStatement  ps=cons.prepareStatement("select * from  walex_notification where status1 like '%New%'  order by id desc ");
			ResultSet  rs=ps.executeQuery();
			
			 while (rs.next()) {
				DownloadSsec  sc=new DownloadSsec();
				sc.setId(rs.getString(1));
				sc.setUser_session_id(rs.getString(3));			
				sc.setPrice(rs.getString(5)); //phone number
				packing.add(sc);
			 	}
			 

			
		 
			} catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
			System.out.println(e);
			}
		}
		return packing;
	 }
	
	
	public List<DownloadSsec> view_orders(String v) {
		
		Connection  cons=null;
		List<DownloadSsec>  packing=new ArrayList<>();
		
		try {
			
			  //new Mariadb().Connects();
			  cons = new DatabaseCon().getConnection();
				PreparedStatement  ps=cons.prepareStatement("select * from  walexProduct  where  userid like '%"+v+"%' order by id desc  ");
				ResultSet  rs=ps.executeQuery();
				 while (rs.next()) {
					 DownloadSsec  sc=new DownloadSsec();
						sc.setId(rs.getString(10)); //price
						sc.setImg_name(rs.getString(8)); //nameofcloth
						sc.setPrice(rs.getString(13)); //item_price
						
						packing.add(sc);
				 }
			} catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
			System.out.println(e);
			}
		}
		return  packing;
	}



	
	
	
	public List<DownloadSsec> view_suborders() {
		Connection   cons=null;
		List<DownloadSsec>  packing=new ArrayList<>();
		  //new Mariadb().Connects();
		try {
			cons=new DatabaseCon().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  walex_notification  order by id desc ");
			ResultSet  rs=ps.executeQuery();
			
			 while (rs.next()) {
				 
				 DownloadSsec  sc=new DownloadSsec();
					sc.setId(rs.getString(1));  //id
					sc.setWriteup(rs.getString(2)); //status
					sc.setUser_session_id(rs.getString(3));
   				sc.setPrice(rs.getString(3));  //typeb
     			//	sc.setImg_name(rs.getString(4)); //img paths
					
					packing.add(sc);
			  }
		 
			} catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				cons.close();
			} catch (SQLException e) {
			System.out.println(e);
			}
		}
		return  packing;
	}



	public void clearNotifications(int c) {
		   Connection con=null;
					try {
						  //new Mariadb().Connects();
						 con= new  DatabaseCon().getConnection();
						 PreparedStatement  ps=con.prepareStatement("update  walex_notification set status1= ? where id = "+c);
						 ps.setString(1, "Seen");
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



			public String suminprices(String c) {
									//System.out.println(c);
									
									String jk=null;
									   Connection  con=null;
										try {
													//new Mariadb().Connects();
													con= new DatabaseCon().getConnection();
													PreparedStatement  ps=con.prepareStatement("select sum(totaling)  as jk  from walex_notification where user_session_id like '%"+c+"%'  ");  // where   status   like  '%"+c+"%' 
													ResultSet  rs=ps.executeQuery();
											while (rs.next()) {
												jk=rs.getString("jk");		
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
								return jk;
						}



			public int authenticate_admin(String user, String password) {
				int y =0;
				   Connection con=null;
					try {
						 con= new  DatabaseCon().getConnection();
								
						 PreparedStatement  ps=con.prepareStatement("select  * from walex_admin where email=? and passwords=?");
						 ps.setString(1, user);
						 ps.setString(2, password);
						ResultSet rs= ps.executeQuery();
						while (rs.next()) {
							y=1;
							new  Singleton().setChain("0000");
						}
					}catch(Exception  e) {
						System.out.println(e);
						y=2;}
					
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return y;	 
			}



			public List<DownloadSsec> view_all_post() {
				Connection   cons=null;
				List<DownloadSsec>  packing=new ArrayList<>();
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement  ps=cons.prepareStatement("select * from  walex_uploads  order by id desc  ");
					ResultSet  rs=ps.executeQuery();
					
					 while (rs.next()) {
						 
						 DownloadSsec  sc=new DownloadSsec();
							sc.setId(rs.getString(1));  //id
							sc.setPrice(rs.getString(3));  //typeb
							sc.setWriteup(rs.getString(2));  //typeb
							sc.setImg_name(rs.getString(4)); //img paths
							
							packing.add(sc);
					  }
				 
					} catch (SQLException e) {
					System.out.println(e);
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
					System.out.println(e);
					}
				}
				return  packing;
			}



			public int delete_post(int c) {
				
				int v=0;
				Connection   cons=null;
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
				PreparedStatement  ps=cons.prepareStatement("delete from  walex_uploads where id ="+c );
			  	v=200;
				ps.execute();
			  
				
				   }catch (Exception e) {
					System.out.println(e);
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						v=404;
					}
				}
				return v;
			}



			public int Update_Post(int c, String price, String writeUp) {
				int v=0;
				Connection   cons=null;
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement ps=cons.prepareStatement(" update  walex_uploads set  price=? ,writeup=? where id="+c);
					ps.setString(1,price);
					ps.setString(2,writeUp);
				  	v=200;  
					ps.executeUpdate();
				   
				     
				   }catch (Exception e) {
					System.out.println(e);
					v=404;
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						v=404;
					}
				}
				return v;
			}
			
			
		

			Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			public void retrieveUpdate (int a) {
				Connection   cons=null;
		
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement  ps=cons.prepareStatement("select * from  walex_uploads  where id= "+a);
					ResultSet  rs=ps.executeQuery();
					
					 while (rs.next()) {
						 
						 DownloadSsec  sc=new DownloadSsec();
							sc.setId(rs.getString(1));  //id
							sc.setPrice(rs.getString(3));  //typeb
							sc.setWriteup(rs.getString(2));  //typeb
						
						sessionMap.put("up", sc);
					  }
				 
					} catch (SQLException e) {
					System.out.println(e);
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
					System.out.println(e);
					}
				}
			
			}



			public int Update_Price(int c, String price) {
				int v=0;
				Connection   cons=null;
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement ps=cons.prepareStatement(" update  walex_uploads set  price=?  where id="+c);
					ps.setString(1,price);
				  	v=200;  
					ps.executeUpdate();
				   
				     
				   }catch (Exception e) {
					System.out.println(e);
					v=404;
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						v=404;
					}
				}
				return v;
				
			}



			public int Update_Write(int c, String writeUp) {
				int v=0;
				Connection   cons=null;
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement ps=cons.prepareStatement(" update  walex_uploads set  writeup=?  where id="+c);
					ps.setString(1,writeUp);
				  	v=200;  
					ps.executeUpdate();
				   
				     
				   }catch (Exception e) {
					System.out.println(e);
					v=404;
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						v=404;
					}
				}
				return v;
				
			}



			public int drop_id_notification(int c) {
				Connection   cons=null;
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement ps=cons.prepareStatement(" delete from  walex_notification   where id="+c);
					ps.execute();
				}catch (Exception e) {
				System.out.println(e);
				}
				
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
					System.out.println(e);
					}
				}
				return 0;
			}



			public List<DownloadSsec> search_notification(String v) {
				
				System.out.println("!!!!zz   "+v);
				Connection   cons=null;
				List<DownloadSsec>  packing=new ArrayList<>();
				  //new Mariadb().Connects();
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement  ps=cons.prepareStatement("select * from  walex_notification  where phone_no like '%"+v+"%'");
					ResultSet  rs=ps.executeQuery();
					
					 while (rs.next()) {
						 
						 DownloadSsec  sc=new DownloadSsec();
							sc.setId(rs.getString(1));  //id
							sc.setWriteup(rs.getString(2)); //status
							sc.setUser_session_id(rs.getString(3));
		   				sc.setPrice(rs.getString(3));  //typeb
		     			//	sc.setImg_name(rs.getString(4)); //img paths
							
							packing.add(sc);
					  }
				 
					 new DownloadSsec().setSearch("");
					} catch (SQLException e) {
					System.out.println(e);
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
					System.out.println(e);
					}
				}
				return  packing;
			}



			public List<DownloadSsec> max_in_address() {
				List<DownloadSsec>  packing=new ArrayList<>();
				  //new Mariadb().Connects();
				
				Connection   cons=null;
				try {
					cons=new DatabaseCon().getConnection();
					PreparedStatement  ps=cons.prepareStatement("select * from walexProduct where userId = '"+new Singleton().getAddress()+"'  limit 1");
					
					ResultSet  rs=ps.executeQuery();
					
					 while (rs.next()) {
						 
						 DownloadSsec  sc=new DownloadSsec();
							sc.setName(rs.getString(2));  //id
							sc.setEmail(rs.getString(3)); //status
		   				   sc.setAddress(rs.getString(4));  
		   				  sc.setPhone(rs.getString(5));
		     			   sc.setCity(rs.getString(6)); 
		     			  sc.setState(rs.getString(7));
		     			  sc.setTime_stamp(rs.getString(12));
							packing.add(sc);
					  }
					 
					 System.out.println("XCX   "+new Singleton().getAddress());
						
				 
					 new DownloadSsec().setAddress("");
					} catch (SQLException e) {
					System.out.println(e);
				}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
					System.out.println(e);
					}
				}
				return  packing;
			}
			
			
			
			
			@SuppressWarnings("resource")
			public void read_in_visitor( int i) {
				Connection  cons=null;	
				PreparedStatement ps=null;
					try {
						String date="0:0";
						int cou = 0;		
					       cons=new DatabaseCon().getConnection();			
						   ps=cons.prepareStatement("select  * from  visit_counts  order by id desc");
					    	ResultSet  rs=ps.executeQuery();
					    	if (rs.next()) {	
							date=rs.getString(3);
							cou=Integer.valueOf(rs.getString(2));
						}
						if(date.equals(date_save())) {
							  cou=cou+1;
							  ps=cons.prepareStatement("update   visit_counts  set counts="+cou+"  where dates= '"+date+"'");
							  ps.execute();
							 
						}
						else {
						  ps=cons.prepareStatement("insert into  visit_counts(counts,dates)  values(?,?) ");
							ps.setInt(1, i);
							ps.setString(2, date_save());
							ps.execute();	
						
							
						}
					
					}
							catch (Exception e) {
								System.out.println(e);
							}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
			}
			
			
			
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

	
	

}
