package controllers;


import java.util.List;

import models.Member;
import models.Product;
import play.mvc.Before;
import play.mvc.Controller;

public class Products  extends Controller {

	//Save a new product
		public static void saveProduct(Product p){
			
			p.save();
			productsList();
		}
	
		public static void productsList(){
			
			List <Product> list = Product.find("order by id").fetch();
					
			render(list);
		}
		
		public static void createProduct(){
			
			render();
		}
		
	
}
