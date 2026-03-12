package utilities;
import org.testng.annotations.DataProvider;
public class dataProviderClass 
{
	@DataProvider(name="login_testdata",parallel=true)
	public Object[][] testdata()
	{
	return new Object[][]
	{
	 {"student","Password123"},
	 {"students","Password1234"}
	};
	}
	}
