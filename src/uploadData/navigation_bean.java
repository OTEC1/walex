package uploadData;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class navigation_bean {

	
	
	String Sequin_Lace="Sequins",
			Velvet_Lace="Velvet",
			Silk_Lace="Silk",
			Organza_Lace="Organza",
            Brocade_Lace="Brocade";
	static  String value;
	
	public String name() {
		
		FacesContext context=FacesContext.getCurrentInstance();
		String c =context.getExternalContext().getRequestParameterMap().get("c1");
		
		System.out.println(c);	
		switch (c) {
		case "Sequins":
				value=Sequin_Lace;
			return  "/SequinLace.xhtml?faces-redirect=true";
			
			
			case "Velvet":
				value=Velvet_Lace;
			return  "/SequinLace.xhtml?faces-redirect=true";
			
			
			case "Silk":
				value=Silk_Lace;
			return  "/SequinLace.xhtml?faces-redirect=true";
	
	
			case "Organza":
				value=Organza_Lace;
			return  "/SequinLace.xhtml?faces-redirect=true";
	
	
			case "Brocade":
					value=Brocade_Lace;
			return  "/SequinLace.xhtml?faces-redirect=true";


	
		default:
			break;
		}
	return  null;}

	
	
	
	

	public String getValue() {
		return value;
	}






	public void setValue(String value) {
		this.value = value;
	}






	public String getVelvet_Lace() {
		return Velvet_Lace;
	}




	public void setVelvet_Lace(String velvet_Lace) {
		Velvet_Lace = velvet_Lace;
	}




	public String getSilk_Lace() {
		return Silk_Lace;
	}




	public void setSilk_Lace(String silk_Lace) {
		Silk_Lace = silk_Lace;
	}




	public String getOrganza_Lace() {
		return Organza_Lace;
	}




	public void setOrganza_Lace(String organza_Lace) {
		Organza_Lace = organza_Lace;
	}




	public String getBrocade_Lace() {
		return Brocade_Lace;
	}




	public void setBrocade_Lace(String brocade_Lace) {
		Brocade_Lace = brocade_Lace;
	}




	public String getSequin_Lace() {
		return Sequin_Lace;
	}


	public void setSequin_Lace(String sequin_Lace) {
		Sequin_Lace = sequin_Lace;
	}
	
	
	
	
	

	
}
