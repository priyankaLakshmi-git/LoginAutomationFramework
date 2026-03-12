package pageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class POMClass
{
    WebDriver POMdriver;
    public POMClass(WebDriver driver1)
    {
        POMdriver = driver1;
    }
   
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.id("submit");
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
}