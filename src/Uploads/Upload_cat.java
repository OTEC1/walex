package Uploads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

import DBCONNECT.Cre;
import server.Server_Request;

@ManagedBean
@SessionScoped
public class Upload_cat {

	 Server_Request server_Request =new Server_Request();
	 Singleton  singleton=new Singleton();
	  UploadedFile  file;
	  String w1="",w2="",w4="";
		static String 
			a1="Sequins ",a2="Velvet",a3="Silk",
			a4="Organza",a5="Brocade",a0="Select Cat",
			rols,Category="";
	
		
	  
	  
	public String getW1() {
		return w1;
	}

	public void setW1(String w1) {
		this.w1 = w1;
	}

	public String getW2() {
		return w2;
	}

	public void setW2(String w2) {
		this.w2 = w2;
	}



	public String getW4() {
		return w4;
	}

	public void setW4(String w4) {
		this.w4 = w4;
	}

	public String getRols() {
		return rols;
	}

	public void setRols(String rols) {
		this.rols = rols;
	}

	public String getA0() {
		return a0;
	}

	public void setA0(String a0) {
		this.a0 = a0;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public String getA4() {
		return a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public String getA5() {
		return a5;
	}

	public void setA5(String a5) {
		this.a5 = a5;
	}
	
	
	   public  String getCategory() {
		return Category;
	}

	public  void setCategory(String category) {
		this.Category = category;
	}
	
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
	
	public String editing() {
		if(	new Singleton().getChain().trim().length()==0)
			message("pls sign in");
		else 
				return "/editing.xhtml?faces-redirect=true";
		
		return null;}
	
	
	
	public String send_in() {
		
		
	//	System.out.println(w1+w2+w4+getCategory());
		
		if(	singleton.getChain().trim().length()==0)
			message("pls sign in");
		else {
		InputStream by=null;
		if(file.getSize()==0)
			message("Pls select a Pics");
		
		else
			if(w1.trim().length()>0 &&w2.trim().length()>0 && getCategory().trim().length()>0 ){

		try {
			by=	file.getInputstream();
		} catch (IOException e) {
		System.out.println(e);
		}
		    String n1 =name_gen();
			ObjectMetadata  b = new ObjectMetadata();
			 b.setContentType(file.getContentType());
			b.setContentLength(file.getSize());
		int c=  	server_Request.put_in(w1,w2,n1,getCategory());		
			server_Request.Upload_file(Cre.bucket, n1, by, b);
			if(c==1) {
			message("Upload Successfully ");
			w1=""; w2=""; w4="";
			}else
				message("Error Occured while Uploading");
		}
		
		
			else
				 if(getCategory().trim().length()==0)
				     message("Pls Select a Categroy  ");
			else
				message("Pls fill out all fields");
		}
		
		return  null;
	}
	
	
	
	


	
	
	private String name_gen() {
	  String  l =String.valueOf(System.nanoTime());
	  String  w =String.valueOf(System.currentTimeMillis());
	  String e =l.concat(w).concat(".png");
	  return  e;
	}
	


	public void read() {
	if(	singleton.getChain().trim().length()==0)
		message("pls sign in");
	else {
		
		 if(rols.contains(a0) &  getCategory().trim().length()==0){
		      
		          setCategory("");
		   }else 
		      if(rols.contains(a1)){
		              setCategory(getA1());
		              System.out.println("WE");  
		       }
		      else
		          if(rols.contains(a2)){  
		            setCategory(getA2());
		      }
		       else
		           if(rols.contains(a3)){   
		             setCategory(getA3());
		      }
		       else
		            if(rols.contains(a4)){   
		            setCategory(getA4());
		      }
		       else
		             if(rols.contains(a5)){
		             setCategory(getA5());
		      }
	}
	}
	
	
	
	
	public void message(String h) {
		   RequestContext  context=RequestContext.getCurrentInstance();
		   context.execute(" swal('"+h+"')");	
	}
	
	
	
	
	
	
	
	
	
//	private byte[] read_pic() {
//	
//	FileOutputStream  outputStream=null;
//	try {
//		
//		 outputStream =new FileOutputStream("");
//		
//		try {
//			outputStream.write((int)file.getInputstream().transferTo(outputStream));
//			outputStream.close();
//		} catch (IOException e) {
//		System.out.println(e);
//		}
//		
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//		}
//	return outputStream;
//}
}
