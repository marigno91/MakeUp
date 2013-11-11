package controllers;

import models.Member;
import models.Product;
import play.mvc.Before;
import play.mvc.Controller;

public class Products  extends Controller {

	@Before
	static void setConnectedUser() {
		if(Security.isConnected()){
			Member m = Member.find("byEmail", Security.connected()).first();
			render(m);
		}
	}
	
	//Save a new product
		public static void saveProduct(Product p){
			
			p.save();
			productsList();
		}
	
		public static void productsList(){
			
			render();
		}
		
		public static void createProduct(){
			
			render();
		}
		
	
}
