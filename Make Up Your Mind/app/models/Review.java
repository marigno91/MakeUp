package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Review extends Model{
	
	public String reviewDescription;
	
	public Blob reviewPic;
	
	public int overallRate;
	public int priceRate;
	public int packagingRate;
	public int qualityRate;
	public int environmentRate;
	
	@ManyToOne 
	public Member m;
	@ManyToOne
	public Product p;
	
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
