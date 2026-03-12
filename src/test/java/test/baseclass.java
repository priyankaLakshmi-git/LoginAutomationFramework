package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners(reports.Listenerclass.class)
public class baseclass
{
	WebDriver driver1;
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    @Parameters({"browser","url"})
    @BeforeMethod(alwaysRun=true)
    public  void setup(@Optional("firefox") String  browser ,String url)
    {  
    	if(browser.equalsIgnoreCase("Chrome"))
    	driver.set(new ChromeDriver());
    	else 
    	driver.set(new FirefoxDriver());
    	driver.get().manage().window().maximize();
        driver.get().get(url);
	}
    @AfterMethod(alwaysRun=true)
    public   void teardown()
    {
    	
    	driver.get().quit();
    	driver.remove();
 
    }
}