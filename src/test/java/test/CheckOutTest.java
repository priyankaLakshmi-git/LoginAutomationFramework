package test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckOutTest 
{
	WebDriver driver;
	WebDriverWait wait;
public CheckOutTest(WebDriver driver1)
{
	driver=driver1;
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
}

public void checkout_products() throws InterruptedException
{
    driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
	Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/cart.html"));
    
	{
		List  <WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));
		if(cartItems.isEmpty())
		{
			Assert.assertFalse(driver.findElement(By.id("checkout")).isEnabled(),
				    "Checkout should be disabled when cart is empty");
	     }
		else 
		{
			Thread.sleep(5000);
			driver.findElement(By.id("checkout")).click();	
			checkout_pagevalidations();
		}
	}
}

public void checkout_pagevalidations()
{
	Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/checkout-step-one.html"));
	String strfirstname,strlastname,strpostalcode;
	List <WebElement> errormessage;
	//driver.findElement(By.id("first-name")).sendKeys("blp");	
	//driver.findElement(By.id("last-name")).sendKeys("bujji");
	driver.findElement(By.id("postal-code")).sendKeys("1234");	
	driver.findElement(By.id("continue")).click();
	errormessage=driver.findElements(By.xpath("//h3[@data-test='error']"));			
	if(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/checkout-step-one.html"))
	{
	strfirstname=driver.findElement(By.id("first-name")).getAttribute("value");	
	strlastname= driver.findElement(By.id("last-name")).getAttribute("value");
	strpostalcode=driver.findElement(By.id("postal-code")).getAttribute("value");
	if(strfirstname.isEmpty())
	{
		Assert.assertTrue(errormessage.size()>0,"First name field is empty:But Error not displayed");
		Assert.assertEquals(errormessage.get(0).getText(),"Error: First Name is required");
		System.out.println("First name is Mandatory ");
	}		
	else if(strlastname.isEmpty())
	{
		errormessage=driver.findElements(By.xpath("//h3[@data-test='error']"));
		Assert.assertTrue(errormessage.size()>0,"last name field is empty:But Error not displayed");	
		Assert.assertEquals(errormessage.get(0).getText(),"Error: Last Name is required");
		System.out.println("Last name is Mandatory ");
	}
	else if(strpostalcode.isEmpty())
	{
		errormessage=driver.findElements(By.xpath("//h3[@data-test='error']"));
		Assert.assertTrue(errormessage.size()>0,"Postal Code field is empty:But Error not displayed");
		Assert.assertEquals(errormessage.get(0).getText(),"Error: Postal Code is required");
		System.out.println("Postal code is Mandatory ");
	}
}
}
}


