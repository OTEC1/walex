package server;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class SweetAlert {
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public void message(String c) {
			
			RequestContext  context=RequestContext.getCurrentInstance();
			context.execute("swal('"+c+"')");
			
	}

}
