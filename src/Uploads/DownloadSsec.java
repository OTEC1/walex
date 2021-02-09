package Uploads;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import DBCONNECT.Cre;
import server.Server_Request;

@ManagedBean
@RequestScoped
public class DownloadSsec {

	
	Server_Request server_Request =new Server_Request();
	 Singleton  singleton=new Singleton();	
	Upload_cat  cat=new Upload_cat();
	List <DownloadSsec> list,list1,list2,list5,listS,addlist;
	String id,price,writeup,img_name,type,
	user_buy_notif,sub_total,user_session_id,
	name,email,house,address,phone,state,city,time_stamp;
	StreamedContent  contents;
	static  String search,search1;
	
	
	
	
	
	
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSearch1() {
		return search1;
	}
	public void setSearch1(String search1) {
		this.search1 = search1;
	}
	public String getUser_session_id() {
		return user_session_id;
	}
	public void setUser_session_id(String user_session_id) {
		this.user_session_id = user_session_id;
	}
	public String getSub_total() {
		return sub_total;
	}
	public void setSub_total(String sub_total) {
		this.sub_total = sub_total;
	}
	
	public String getUser_buy_notif() {
		return user_buy_notif;
	}
	public void setUser_buy_notif(String user_buy_notif) {
		this.user_buy_notif = user_buy_notif;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	public StreamedContent getContents() throws FileNotFoundException {
		byte [] c=null;
			FacesContext  context= FacesContext.getCurrentInstance();
			if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE)
				return  new DefaultStreamedContent();
			else {
				String h=context.getExternalContext().getRequestParameterMap().get("x1");
			//	https://s3.console.aws.amazon.com/s3/#
				
			
				
			c =	server_Request.read_img(Cre.bucket,h);
			}
		return new DefaultStreamedContent(new ByteArrayInputStream(c));
	}
	public void setContents(StreamedContent contents) {
		this.contents = contents;
	}
	
	
	
	
	
	
	
	
	//Search list
	
public String Searching() {
	
	if(singleton.getChain().trim().length()<=0)
		message("Pls Sign in");
		else {
		       server_Request.search_notification(getSearch());
		      	return "/Search.xhtml";
		}
	
	return null;
		}



	
	
		public List<DownloadSsec> getListS() {
			return server_Request.search_notification(getSearch());
		}
		public void setListS(List<DownloadSsec> listS) {
			this.listS = listS;
		}
			
	
	
	public List<DownloadSsec> getList() {
		if(singleton.getChain().trim().length()<=0)
		System.out.println("none");
		else
			return server_Request.view_suborders();

	return null;	
	}
	
	
	public void setList(List<DownloadSsec> list) {
		this.list = list;
	}
	
	
	
	public List<DownloadSsec> getList5() {
		if(	new Singleton().getChain().trim().length()==0)
			System.out.println("nothing");
		else 
		return server_Request.view_all_post();
		
		return null;
		
	}
	public void setList5(List<DownloadSsec> list5) {
		this.list5 = list5;
	}
	
	
	
	
	
	
	

	public List<DownloadSsec> getList1() {
		if(	new Singleton().getChain().trim().length()==0)
			System.out.println("nothing");
		else 
		return server_Request.view_notifications();
		
		
		return null;
	}
	public void setList1(List<DownloadSsec> list1) {
		this.list1 = list1;
	}
	
	
	

	
	
	
	
	public String home() {
		if(singleton.getChain().length()==0)
			message("Pls sign in");
		else
			return "/CP1.xhtml?faces-redirect=true";
		
		
		return null;
	}
	
	
	
	public String view_sub_noti() {
		if(singleton.getChain().trim().length()==0) {
			message("Pls sign in");
			return  null;	
		}else
			return  "/CP3.xhtml";	
		

	}
	

	public String go_back() {
		
		if(singleton.getChain().trim().length()==0)
			message("Pls sign in");
		else 
			return  "/CP1.xhtml?faces-redirect=true";
		
	return  null;
	}
	
	public String request_view() {
		
		if(singleton.getChain().trim().length()==0)
			message("Pls sign in");
		else {
			FacesContext context=FacesContext.getCurrentInstance();
			 new Singleton().setIds(context.getExternalContext().getRequestParameterMap().get("eee"));
			System.out.println("Clicked "+new Singleton().getIds());
			
			}
		return  "/CP2.xhtml?faces-redirect=true";
	}
	
	
	
	
	public String search_view() {
		
		if(singleton.getChain().trim().length()==0)
			message("Pls sign in");
		else {
			FacesContext context=FacesContext.getCurrentInstance();
			new Singleton().setIds(context.getExternalContext().getRequestParameterMap().get("mmm"));
			System.out.println("Clicked "+new Singleton().getIds());
		return  "/CP5.xhtml?faces-redirect=true";
		}
		return null;
	}
	
	
	

	
	
public String request_view1() {
		
		if(singleton.getChain().trim().length()==0)
			message("Pls sign in");
		else {
			FacesContext context=FacesContext.getCurrentInstance();
			 new Singleton().setIds(context.getExternalContext().getRequestParameterMap().get("usered"));
			System.out.println("Clicked "+new Singleton().getIds());
			
			FacesContext cons=FacesContext.getCurrentInstance();
			int c =Integer.parseInt(cons.getExternalContext().getRequestParameterMap().get("eds"));
			  server_Request.clearNotifications(c);
		}
		return  "/CP2.xhtml?faces-redirect=true";
	}
	
	
	public List<DownloadSsec> getList2() {
		if(	new Singleton().getChain().trim().length()==0)
			System.out.println("nothing");
		else 
		return server_Request.view_orders(new Singleton().getIds());
		
		return  null;
	}
	public void setList2(List<DownloadSsec> list2) {
		this.list2 = list2;
	}
	
	
	
	
	public String totals() {
		
	FacesContext  context=FacesContext.getCurrentInstance();
     String c =String.valueOf(context.getExternalContext().getRequestParameterMap().get("ny"));
	 System.out.println("SSS "+c); 
     String h = server_Request.suminprices(c);
	  message("Total = "+h);
	
	return null;}
	
	
	public String sign_in() {
		
	
	return "/Sign_up.xhtml?faces-redirect=true";}
	
	
	
	public String droping() {
		
		FacesContext  context=FacesContext.getCurrentInstance();
		int c=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("drops"));
	int x=	server_Request.drop_id_notification(c);
	
	return null;}
	
	
	
	
	
	public String address_view() {
		
		FacesContext  context=FacesContext.getCurrentInstance();
		new Singleton().setAddress(context.getExternalContext().getRequestParameterMap().get("libs"));
		
			System.out.println("XCX   "+new Singleton().getAddress());
		
		return  "/CP6.xhtml?faces-redirect=true";
	}



	
	public List<DownloadSsec> getAddlist() {
		return server_Request.max_in_address();
	}
	public void setAddlist(List<DownloadSsec> addlist) {
		this.addlist = addlist;
	}
	
	
	
	public void message(String j) {
		RequestContext  context= RequestContext.getCurrentInstance();
		context.execute("swal('"+j+"')");
	
	}
	
	

}
