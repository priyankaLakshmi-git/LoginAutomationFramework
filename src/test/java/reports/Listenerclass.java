package reports;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import utilities.screenshotClass;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import test.BaseClass;
public class Listenerclass implements ITestListener
{
	ExtentReports erp=ReporterclassTest.createReport();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	public void onTestStart(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		String classname=result.getTestClass().getName();
		System.out.println("method name is"+methodname+"class name is "+classname);		
		test.set(erp.createTest(classname+'_'+methodname));			
		//Object  obj=(result.getInstance());
		//LoginTest lTest=(LoginTest)obj;
		//System.out.println(lTest.driver.getCurrentUrl());
	}
	public void onTestSuccess(ITestResult result) 
	{
		int s=result.getStatus();
		System.out.println("Status is" +s);
		test.get().pass("Test Passed");
	}
	public void onTestFailure(ITestResult result)
	{
		
		WebDriver driver=BaseClass.getDriver();
		try 
		{
			screenshotClass.getScreenshot(driver);
		} 
		catch (IOException e) 
		{			 
			e.printStackTrace();
		}
		if(test.get()!=null)
		{
		test.get().fail(result.getThrowable()+"status is "+result.getStatus());
		test.get().info("method failed");
	    }
	}
	public void onFinish(ITestContext context) 
	{
		erp.flush();
	}
}