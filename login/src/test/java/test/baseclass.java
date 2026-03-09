package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
@Listeners(Reports.Listenerclass.class)
public class baseclass
{

	WebDriver driver1;
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    @BeforeMethod(alwaysRun=true)
    public  void setup()
    {  
    	driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().get("https://practicetestautomation.com/practice-test-login/");
        driver1=driver.get();
    }
    @AfterMethod(alwaysRun=true)
    public   void teardown()
    {
    	
    	driver.remove();
 
    }
}