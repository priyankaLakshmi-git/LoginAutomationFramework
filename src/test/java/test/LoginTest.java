package test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.POMclass;
import Reports.Listenerclass;
public class LoginTest extends baseclass
{
	
  @Test
  public  void login()
  {	  
	   
	  //WebDriver driver1=driver.get();
	  System.out.println(driver1.getCurrentUrl()); 	  
	  System.out.println("thread ID"+Thread.currentThread().getId());
	  POMclass  lp = new POMclass(driver1);
	  String username=lp.enterUsername("student");
		  try 
		  {
		  Assert.assertTrue(username.equals("student"));
		  Listenerclass.test.get().pass("Entered correct student");	      
		  }
		  catch (AssertionError e) 
		  {
			  Listenerclass.test.get().fail("Entered incorrect username");
			  throw e;
		  }
	      String pwd=lp.enterPassword("Password123");
	      try 
	      {
	    	  Assert.assertTrue(pwd.equals("Password123"));
	    	  Listenerclass.test.get().pass("entered correct password");
		  } 
	      catch (AssertionError e) 
	      {
	    	  Listenerclass.test.get().fail("entered incorrect password");
	    	  throw e;
		  }	      
	      lp.clickLogin();
	      Listenerclass.test.get().info("clicked  on submit");  
	  	  System.out.println("login class is running  parallel  to  login"+driver1.getTitle());

           }
}
