package controllers;

import models.Member;
import play.mvc.Before;
import play.mvc.Controller;

public class Members extends Controller {

	
	//Save a new member
	public static void saveMember(Member m){
		
		m.save();
		profile(m.id);
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
	
	public static void rateMember(long id){
		
		Member m = Member.findById(id);
		
		render();
	}
	
	public static void signUp(){
		render();
	}
	
	public static void profile(long id){
		Member m = Member.findById(id);
		render(m);
	}
}
