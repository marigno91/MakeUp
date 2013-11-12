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
	
		public static void getProductPic(long id){
			Product p = Product.findById(id);
			response.setContentTypeIfNotSet(p.productPic.type());
			renderBinary(p.productPic.get());
		}
		
		public static void productsList(){
			
			List <Product> list = Product.find("order by productname").fetch();
					
					
			render(list);
		}
		
		public static void createProduct(){
			
			render();
		}
		
		public static void productEdit(long id){
			Product p = Product.findById(id);
			render(p);
		}
}
