package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Member extends Model {

	
	
	public String memberName;
	public String password;
	@Column(unique=true)
	public String email;
	
	public String description;

	//physical characteristics
	public int memberAge;
	public String eyeColor;
	public String hairColor;
	public String hairType;
	public String skinColor;
	public String skinType;
	
	//user rate (coming from the other users)
	public float memberRate;
	
	//picture
	public Blob memberPic;
	
	//photo, favourites products, rate du user ??

	public Member(String memberName, int memberAge, String email, String password){
		
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.email = email;
		this.password = password;
	}
	
	public static Member connect(String email, String password){
		return find("byEmailAndPassword", email, password).first();
	}
	
}
