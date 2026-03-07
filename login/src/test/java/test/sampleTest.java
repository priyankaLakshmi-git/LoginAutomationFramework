package test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Reports.Listenerclass;
public class sampleTest  extends baseclass
{

@Test 
public void sampledetails()
{	
	//WebDriver driver1=driver.get();//getting From baseclass driver that is threadlocal now
	/*SoftAssert SA=new SoftAssert();
	SA.fail();
	Listenerclass.test.info("used assert.fail");
	SA.assertEquals("hello", "hello");
	Listenerclass.test.info("used  assert.equals");
	SA.assertAll();
	Listenerclass.test.info("after AassertAll");
	System.out.println("In sample class"+driver);*/
//Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
//Listenerclass.test.pass("navigated successfully to  next page");
	Listenerclass.test.get().pass("now we are in sample_sampledetails methdod with thread ID"+Thread.currentThread().getId());
	Listenerclass.test.get().info("blog page clicked");
	driver1.findElement(By.xpath("//a[text()='Blog']")).click();
	Listenerclass.test.get().pass("blog page came");
}

@Test 
public void showdetails()
{
	Listenerclass.test.get().pass("now we are in sample_showdetails methdod with thread ID"+Thread.currentThread().getId());
	Listenerclass.test.get().info("contact page Clicked");
	driver1.findElement(By.xpath("//a[text()='Contact']")).click();
	Listenerclass.test.get().pass("contact page came");
}
}