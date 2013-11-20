package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import models.Member;
import models.Review;
import play.libs.Mail;
import play.mvc.Before;
import play.mvc.Controller;

public class Members extends Controller {

	
	//Save a new member
	public static void saveMember(Member m){
		
		m.save();
		profile(m.id);
	}
	
	//Save a new member
		public static void saveNewMember(Member m) throws EmailException{
			
			m.save();
			
			SimpleEmail email = new SimpleEmail();
			email.setFrom("makeupyourmind@gmail.com");
			email.addTo(m.email);
			email.setSubject("Welcome to Make Up Your Mind");
			email.setMsg("Welcome to Make Up Your Mind! Connect right now using this email address as your login :) See you soon!");
			Mail.send(email);
			
			Application.index();
		}
		
	
	public static void getMemberPic(long id){
		Member m = Member.findById(id);
		response.setContentTypeIfNotSet(m.memberPic.type());
		renderBinary(m.memberPic.get());
	}
	
	public static void profileEdit(Long id){
		
		Member m = Member.findById(id);
		render(m);
	}
	
	public static void seeProfile(long id){
		
		Member m = Member.findById(id);
		render(m);
	}
	
	public static void saveRating(Member m, String rate){
		
		m.memberRate = m.memberRate + Integer.parseInt(rate);
		m.numberOfRatings = m.numberOfRatings + 1;
		
		m.save();
		
		seeProfile(m.id);
	}
	
	public static void rateMember(long id){
		
		Member m = Member.findById(id);
		render(m);
	}
	
	public static void signUp(){
		render();
	}
	
	public static void profile(long id){
		Member m = Member.findById(id);
		render(m);
	}
}
