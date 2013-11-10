package models;

import java.util.Date;

import play.db.jpa.Blob;

public class Review {
	
	public String reviewDescription;
	
	public Blob reviewPic;
	
	public int overallRate;
	public int priceRate;
	public int packagingRate;
	public int qualityRate;
	public int environmentRate;
	
	public Review(String reviewDescription, Blob reviewPic, int overallRate, int priceRate, int packagingRate, int qualityRate, int environmentRate){
		
		this.reviewDescription = reviewDescription;
		this.reviewPic = reviewPic;
		
		this.overallRate = overallRate;
		this.priceRate = priceRate;
		this.packagingRate = packagingRate;
		this.qualityRate = qualityRate;
		this.environmentRate = environmentRate;
	}
		
	

}
