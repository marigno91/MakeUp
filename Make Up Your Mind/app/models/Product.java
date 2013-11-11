package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Product extends Model {

	@Column(unique=true)
	public String productName;
	public String productBrand;
	
	public String productPrice;
	
	public float productAverageRate;
	public int numberOfRatings = 0;
	
	public Date productLaunchingDate;
	
	//picture
	public Blob productPic;
	
	public Product(String productName, String productBrand, String productPrice, Date productLaunchingDate){
		
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productLaunchingDate = productLaunchingDate;

	}
	
	
	
}
