package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

	@Before
	static void setConnectedUser() {
		if(Security.isConnected()){
			Member m = Member.find("byEmail", Security.connected()).first();
			render(m);
		}
	}
	
    public static void index() {
    	
    	
        render();
    }

}