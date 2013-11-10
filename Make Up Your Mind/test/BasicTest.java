import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        
    	//create a new user and save it
    	new Member("Ena", 20, "marianne.arigno@gmail.com","makeup").save();
    	
    	//retrieve the user using email
    	Member ena = Member.find("byEmail", "marianne.arigno@gmail.com").first();
    	
    	//Test
    	assertNotNull(ena);
    	assertEquals("Ena", ena.memberName);
    }

    @Test
    public void tryConnectAsUser() {
    	//create a new user and save it
    	new Member("Ena", 20, "marianne.arigno@gmail.com","makeup").save();
    	
    	//Test
    	assertNotNull(Member.connect("marianne.arigno@gmail.com","makeup")); 
    	assertNull(Member.connect("marianne.arigno@gmail.com","olala")); 
    	assertNull(Member.connect("bob@gmail.com","makeup")); 
    	assertNull(Member.connect("bob@gmail.com","olala"));
    	
    }
}
