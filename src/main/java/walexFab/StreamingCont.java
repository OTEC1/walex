package walexFab;

import java.io.ByteArrayInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import server.Cre;
import server.RetrieveConnection;
import server.Server_Request;
import server.SweetAlert;


@ManagedBean
@SessionScoped
public class StreamingCont   extends HttpServlet implements Serializable{
	
	Server_Request  request=new Server_Request();
	StreamedContent stream, stream1,mean,streaming,streamLimit;
	private int ppp;
	private String id,Picname,quatity="";
	private String name,itemqua,itemtotal;
	private String price,totalMoney,addUp,itemComment;
	private String userauto_gen;
	private String photos;
	private static String items;
	private byte[] redirectImage;
	private static String totalAmount="";
	int a,price1;
	String name1,photo,itemCo;
	String pics,c;

	 private static final long serialVersionUID = 1L;
	 private List<StreamingCont>  list,list1,list2,listSeq,listVev,listSilk,listorganza,listbrocade,qua;
	 private List<StreamingCont> seqList,velList,organList,silkList,brocadeList,submit_tion_list;
	 Server_Request  request2=new Server_Request();
	 RetrieveConnection sc= new RetrieveConnection();
	 public StreamingCont() {}
		
	
		
	

	
	public String userId() {
		long bb=System.nanoTime();
		String uuid=String.valueOf(bb);
	    uuid=UUID.randomUUID().toString();
		return uuid;
	}
	

	
	
	
	
	
	public String getItemqua() {
		return itemqua;
	}



	public void setItemqua(String itemqua) {
		this.itemqua = itemqua;
	}



	public String getItemtotal() {
		return itemtotal;
	}



	public void setItemtotal(String itemtotal) {
		this.itemtotal = itemtotal;
	}



	public String getPicname() {
		return Picname;
	}



	public void setPicname(String picname) {
		Picname = picname;
	}



	public String shoppAll() {	
		return "/shopAll.xhtml?faces-redirect=true";
	}
	
	
	public byte[] getRedirectImage() {
		return redirectImage;
	}

	public void setRedirectImage(byte[] redirectImage) {
		this.redirectImage = redirectImage;
	}
	

	public String getItemComment() {
		return itemComment;
	}



	public void setItemComment(String itemComment) {
		this.itemComment = itemComment;
	}



	public String getAddUp() {
		return addUp;
	}

	public void setAddUp(String addUp) {
		this.addUp = addUp;
	}
	
	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getQuatity() {
		return quatity;
	}

	public void setQuatity(String quatity) {
		this.quatity = quatity;
	}

	
	public int getPpp() {
		return ppp;
	}

	public void setPpp(int ppp) {
		this.ppp = ppp;
	}

	public  String getItems() {
		return items;
	}
	public  void setItems(String items) {
		this.items = items;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setUserauto_gen(String userauto_gen) {
		this.userauto_gen = userauto_gen;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	public String getUserauto_gen() {
		return userauto_gen;
	}
	
	
	public String getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	int ins;
	public int getIns() {
		return ins;
	}

	public void setIns(int ins) {
		this.ins = ins;
	}

	
	
	public String plus() {
		ins++;
		setQuatity(String.valueOf(ins));
		return null;
	}

	public String minus() {
		
		if(ins<=0) 
			ins=1;
		
		ins--;
		setQuatity(String.valueOf(ins));
		
		return null;
	}




	public void setStreamLimit(StreamedContent streamLimit) {
		this.streamLimit = streamLimit;
	}






	public void setMean(StreamedContent mean) {
		this.mean = mean;
	}


	public void setStreaming(StreamedContent streaming) {
		this.streaming = streaming;
	}



	public void setSubmit_tion_list(List<StreamingCont> submit_tion_list) {
		this.submit_tion_list = submit_tion_list;
	}



	public StreamedContent getStream() throws FileNotFoundException {
		byte[] bbb=null;
		FacesContext face=FacesContext.getCurrentInstance();
		if(face.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {
			String  women =(face.getExternalContext().getRequestParameterMap().get("ew"));
				
			
			bbb=request.read_img(Cre.bucket,women);
	        return new DefaultStreamedContent(new ByteArrayInputStream(bbb));
		}
	}
	
	
	
	public StreamedContent getStreamLimit() {
		byte[] bbb=null;
		FacesContext face=FacesContext.getCurrentInstance();
		if(face.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {
			int women =Integer.parseInt(face.getExternalContext().getRequestParameterMap().get("limit"));
				
			bbb=sc.limit(women);
	        return new DefaultStreamedContent(new ByteArrayInputStream(bbb));
		}
	}

	
	
	public void setStream(StreamedContent stream) {
		this.stream = stream;
	}
	
	
	
	public StreamedContent getStream1() {
		byte[] bbb=null;
		FacesContext face=FacesContext.getCurrentInstance();
		if(face.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {
			String women =(face.getExternalContext().getRequestParameterMap().get("c"));
		
			bbb=request.read_img(Cre.bucket,women);
		 
	        return new DefaultStreamedContent(new ByteArrayInputStream(bbb));
		}
	}
	public void setStream1(StreamedContent stream1) {
		this.stream1 = stream1;
	}

	
	public String directTo() {
		
		
		return null;
	}

	


	public String price_sum() {
		long x1=0;
        long x3;
		FacesContext context=FacesContext.getCurrentInstance();
		x1=Long.valueOf(context.getExternalContext().getRequestParameterMap().get("yek"));
        System.out.println(x1+  "   // ff " +getQuatity());

        if(getQuatity().trim().length()==0  && !getQuatity().trim().equals("0"))
        	new SweetAlert().message("Pls Enter a value");
        else {

        long x2=Long.valueOf(getQuatity());
		
	      x3 = x2 * x1;
	      System.out.println(x3);
	     
	     setTotalMoney(String.valueOf(x3));
//	     System.out.println(x3);
        }
	     return null;
	}
	


	public StreamedContent getMean() {
		byte[] bbb=null;
		FacesContext face=FacesContext.getCurrentInstance();
		if(face.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {
			String women =(face.getExternalContext().getRequestParameterMap().get("dddd"));
				
		
			bbb= request.read_img(Cre.bucket, women);
		 
	        return new DefaultStreamedContent(new ByteArrayInputStream(bbb));
		}
	}	
	
	
	public StreamedContent getStreaming() {
		byte[] bbb=null;
		FacesContext face=FacesContext.getCurrentInstance();
		if(face.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {
			String women =(face.getExternalContext().getRequestParameterMap().get("sequin"));
				
			
					
			bbb=  request.read_img(Cre.bucket, women);
			return new DefaultStreamedContent(new ByteArrayInputStream(bbb));
	}
		
	
	}
	
	
	

	public String getC() {
		return c;
	}



	public void setC(String c) {
		this.c = c;
	}


	public void spill() {
		System.out.println(quatity);
	}
	
	
	
	
	
}
