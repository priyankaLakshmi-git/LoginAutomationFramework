package test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.POMClass;
import reports.Listenerclass;
import utilities.dataProviderClass;
import utilities.retryClass;
public class LoginTest extends baseclass
{
  @Test(retryAnalyzer = retryClass.class,dataProviderClass=dataProviderClass.class,dataProvider="login_testdata")
  public  void login(String  user,String pwd)
  {	  
	  System.out.println("testdata : "+user +" " + pwd);	  
	  WebDriver driver1=driver.get(); 	  
	  POMClass  lp = new POMClass(driver1);
	  lp.enterUsername(user);
		  try 
		  {
		  Assert.assertEquals(user,"student");
		  Listenerclass.test.get().pass("Entered correct student");	      
		  System.out.println("username is "+user);
		  }
		  catch (AssertionError e) 
		  {
			  Listenerclass.test.get().fail("Entered incorrect username");
			  throw e;
		  }
          lp.enterPassword(pwd);
	      try 
	      {
	    	  Assert.assertEquals(pwd,"Password123");
	    	  Listenerclass.test.get().pass("entered correct password");
		  } 
	      catch (AssertionError e) 
	      {
	    	  Listenerclass.test.get().fail("entered incorrect password");
	    	  throw e;
		  }	      
	      lp.clickLogin();
	      Listenerclass.test.get().info("clicked  on submit");  
           }
}
