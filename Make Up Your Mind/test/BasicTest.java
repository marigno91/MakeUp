import org.junit.*;

import java.util.*;

import play.db.jpa.Blob;
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
    	new Member("Ena", 20, "ena@ena.ena","makeup").save();
    	
    	//Test
    	assertNotNull(Member.connect("ena@ena.ena","makeup")); 
    	assertNull(Member.connect("ena@ena.ena.com","olala")); 
    	assertNull(Member.connect("bob@gmail.com","makeup")); 
    	assertNull(Member.connect("bob@gmail.com","olala"));
    	
    }
    
    @Test
    public void createAndRetrieveProduct() {
        
    	//create a new user and save it
    	new Product("fdt mufe", "mufe", "38€").save();
    		
    	//retrieve the user using email
    	Product prod = Product.find("productName", "fdt mufe").first();
    	
    	//Test
    	assertNotNull(prod);
    	assertEquals("fdt mufe", prod.productName);
    }
    
    @Test
    public void createAndRetrieveReview() {
        
    	//create a new user and save it
    	new Review("blablabla", 1, 2, 3, 4, 5).save();
    		
    	
    	//retrieve the user using email
    	Review rev = Review.find("reviewDescription", "blablabla").first();
    	
    	//Test
    	assertNotNull(rev);
    	assertEquals("blablabla", rev.reviewDescription);
    }
    
    
    
}
