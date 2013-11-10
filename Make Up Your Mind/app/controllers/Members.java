package controllers;

import models.Member;
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
	
	public static void signUp(){
		render();
	}
	
	public static void profile(long id){
		Member m = Member.findById(id);
		render(m);
	}
}
