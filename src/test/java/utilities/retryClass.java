package utilities;
import  org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class retryClass implements IRetryAnalyzer
{
int count=1,maxcount=2;
public boolean retry(ITestResult result)
{
	while(count<maxcount)
	{		
		System.out.println("retried " +count+ " time");
		count++;
		return true;
	}
		return false;	
}
}
