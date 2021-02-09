package uploadData;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import server.Server_Request;

@ManagedBean
@SessionScoped
public class ScreenView  implements Serializable{

	
	public String mainTain() {
		FacesContext  context=FacesContext.getCurrentInstance();
		Map <String, Object> obj=context.getExternalContext().getSessionMap();
		   if(obj.isEmpty()) 
			new Server_Request().read_in_visitor(1);
		return null;
	}
	
}
