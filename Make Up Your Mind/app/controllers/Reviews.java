package controllers;

import java.util.List;

import models.Member;
import models.Product;
import models.Review;
import play.mvc.Before;
import play.mvc.Controller;

public class Reviews extends Controller{


		public static void getReviewPic(long id){
			Review r = Review.findById(id);
			response.setContentTypeIfNotSet(r.reviewPic.type());
			renderBinary(r.reviewPic.get());
		}
		
		public static void reviewsList(){
			
			List <Review> list = Review.find("order by id").fetch();
			render(list);
		}
		
		public static void createReview(){
			
			render();
		}
		
			//Save a new product
			public static void saveReview(Review r, String overall, String price, String packaging, String quality, String environment){
				
				r.overallRate = Integer.parseInt(overall);
				r.priceRate = Integer.parseInt(price);
				r.packagingRate = Integer.parseInt(packaging);
				r.qualityRate = Integer.parseInt(quality);
				r.environmentRate = Integer.parseInt(environment);
				
				
				if(Security.isConnected()){
					Member m = Member.find("byEmail", Security.connected()).first();
					
					r.m = m;
				}
				
				
				r.save();
				reviewsList();
			}
		
}
