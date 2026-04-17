package pageClass;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.Listenerclass;
public class POMClass
{
    WebDriver POMdriver;
    WebDriverWait wait;
    WebElement element;
    public POMClass(WebDriver driver1)
    {
        POMdriver = driver1;
        wait=new WebDriverWait(POMdriver,Duration.ofSeconds(10));
    }
   
    By username = By.name("user-name");
    By password = By.name("password");
    By loginBtn = By.id("login-button");
    By product  = By.xpath("//div/button[@class='btn btn_primary btn_small btn_inventory ']");
    public String enterUsername(String user)
    {
    	POMdriver.findElement(username).sendKeys(user);
        return user;
    }
    public String enterPassword(String pwd)
    {
    	POMdriver.findElement(password).sendKeys(pwd);
        return pwd;
    }
    public void clickLogin()
    {
    	POMdriver.findElement(loginBtn).click();
    }  		
    
    public double ProductsPageVerification(String  prodname)
    {
    	String  Prod_title1,Prod_title2;
    	double price1=0,price2=0;
    	List  <WebElement> ProductsList2=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-test='inventory-item-name']")));
    	for(WebElement productname2:ProductsList2)
    	{
    	Prod_title1=productname2.getText();
    	if(Prod_title1.equalsIgnoreCase(prodname))
    	{
    	price1=Double.parseDouble(productname2.findElement(By.xpath("./ancestor::div[@data-test='inventory-item']//div[@data-test='inventory-item-price']")).getText().replace("$",""));
        System.out.println("product price is " + price1);
        wait.until(ExpectedConditions.elementToBeClickable(productname2)).click();
        System.out.println("Adding product " + prodname + " to cart" );
        System.out.println("Clicked  on Product.User navigated  to Products details page");
        Listenerclass.test.get().pass("Clicked  on Product.User navigated  to Products details page");
        Prod_title2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-name']"))).getText();
    	Assert.assertEquals(Prod_title1,Prod_title2);
    	System.out.println("Product titles are same in  both Products list and Produt Details pages");
    	Listenerclass.test.get().pass("Product titles are same in  both Products list and Produt Details pages");
    	price2=Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-price']"))).getText().replace("$",""));
    	Assert.assertEquals(price1,price2,"prices are not same in products List and product details page");
    	Listenerclass.test.get().pass("prices are same in products List and product details page");
    	Listenerclass.test.get().pass("Product verification done");
    	System.out.println("prices are same in products List and product details page");
    	System.out.println("Products Page verification Done for following product : " + Prod_title2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,'add-to-cart')]"))).click();
        System.out.println("Product Added to cart");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products"))).click();
        System.out.println("Navigated back  to  Products List page");
        return price1;
    	}
    	}
    	return price1;   	
    }
}