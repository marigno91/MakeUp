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
			
			if(Security.isConnected()){
				Member m = Member.find("byEmail", Security.connected()).first();
				List <Review> list = Review.find("order by id").fetch();
				render(list,m);
			}
			else
			{
				List <Review> list = Review.find("order by id").fetch();
				render(list);
			}
			
		}
		
		public static void createReview(){
			
			List <Product> listProd = Product.find("order by id").fetch();

			render(listProd);

		}
		
			//Save a new product
			public static void saveReview(Review r, Product p, String overall, String price, String packaging, String quality, String environment, String productName){
				
				r.overallRate = Integer.parseInt(overall);
				r.priceRate = Integer.parseInt(price);
				r.packagingRate = Integer.parseInt(packaging);
				r.qualityRate = Integer.parseInt(quality);
				r.environmentRate = Integer.parseInt(environment);
				
				List <Product> prod = Product.find("productName", productName).fetch();
				
				r.p = prod.get(0);
				
				if(Security.isConnected()){
					Member m = Member.find("byEmail", Security.connected()).first();
					
					r.m = m;
				}
				
				
				r.save();
				reviewsList();
			}
		
}
