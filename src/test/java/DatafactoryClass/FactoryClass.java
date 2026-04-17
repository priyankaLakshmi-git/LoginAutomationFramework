package DatafactoryClass;
import org.testng.annotations.Factory;
import test.RunTest;
import utilities.dataProviderClass;
public class FactoryClass
{
	@Factory(dataProviderClass=dataProviderClass.class,dataProvider="Browser_Details")
	public Object[] datasetup1(String Browser,String url)
	{
		return new Object[]
				{
					new RunTest(Browser,url)					
				};
	}
}
