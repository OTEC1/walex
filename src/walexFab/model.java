package walexFab;

public class model {

//	 Map<String,Object> pack = new HashMap<String, Object>();
//  pack.put("image", request.getParameter("image"));
//  pack.put("input", request.getParameter("inputCalculate"));
//  pack.put("price", request.getParameter("price"));
//  pack.put("id", request.getParameter("id"));
//  pack.put("total", start_Ses(request).getAttribute("total"));

	public String id,total,image,input,price;

	public model() {
		
	}
		
	public model(String id, String total, String image, String input, String price) {
		super();
		this.id = id;
		this.total = total;
		this.image = image;
		this.input = input;
		this.price = price;
	}
		
	


	
		
}
