package controllers;

import models.Member;
import models.Product;
import models.Review;
import play.mvc.Before;
import play.mvc.Controller;

public class Reviews extends Controller{

	
		//Save a new product
		public static void saveReview(Review r){
			
			r.save();
			reviewsList();
		}
	
		public static void reviewsList(){
			
			render();
		}
		
	
}
