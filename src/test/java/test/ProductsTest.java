package test;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageClass.POMClass;
public class ProductsTest 
{
	static WebDriver driver;
	WebDriverWait wait;
	POMClass pomClass;
	int cartcount=0;
	double prodprice=0,totalprice=0;; 
	public ProductsTest(WebDriver driver1)
	{
	driver=driver1;	
	pomClass=new POMClass(driver);
    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

public  int Add_Products(String prodname) throws InvalidFormatException, IOException
{		
	String cartupdate;
	prodprice=pomClass.ProductsPageVerification(prodname);
		if(prodprice!=0)
		{
		cartcount++;
		totalprice=totalprice+prodprice;
		}
	if(cartcount!=0)
	{
		cartupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='shopping-cart-badge']"))).getText();
		Assert.assertEquals(cartcount,Integer.parseInt(cartupdate),"Cart count should match with added products !");
		System.out.println("total price in cart is" + totalprice);
	}
	return cartcount;
}
}
