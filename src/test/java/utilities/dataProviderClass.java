package utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class dataProviderClass 
{
	
	@DataProvider(name="Browser_Details")
	public  Object[][] BrowserDetails()
	{
		return new Object[][]
		{
			{"chrome","https://www.saucedemo.com/"}
      	};
	}
	

	@DataProvider(name="login_standard_user")
	public Object[][] testdata1()
	{
	return new Object[][]
	{
		{"standard_user","secret_sauce"}
	};
	}
	
	@DataProvider(name="login_lockedout_user",parallel=true)
	public Object[][] testdata2()
	{
	return new Object[][]
	{
	 {"lockedout_user","secret_sauce"}
	};
	}
	
	@DataProvider(name="login_problem_user",parallel=true)
	public Object[][] testdata3()
	{
	return new Object[][]
	{
	 {"problem_user","secret_sauce"}
	};
	}
	
	@DataProvider(name="login_invalid_credentials")
	public Object[][] testdata4() throws IOException
	{		
		  Sheet s=Login_testdata.OpenExcel();		  
		  List <Object[]> credentials=new ArrayList<>();
		  int i;
		  for(i=1;i<=s.getLastRowNum();i++)
		  {
			  if(s.getRow(i).getCell(0).toString().contains("invalid_user"))
			  {
			  System.out.println(s.getRow(i).getCell(0).toString());
			  credentials.add(new Object[]{s.getRow(i).getCell(1).toString(),s.getRow(i).getCell(2).toString()});  
			  break;
			  }
			 
		  }	
		  return credentials.toArray(new Object[0][]);
	}
	
	@DataProvider(name="login_empty_user",parallel=true)
	public Object[][] testdata7()
	{
	return new Object[][]
	{
	 {"  ","secret_sauce"}
	};
	}	
	
	@DataProvider(name="login_empty_password",parallel=true)
	public Object[][] testdata8()
	{
	return new Object[][]
	{
	 {"standard_user"," "}
	};
	}
	
	@DataProvider(name="login_empty_username_password",parallel=true)
	public Object[][] testdata9()
	{
	return new Object[][]
	{
	 {" "," "}
	};
	}
	
	@DataProvider(name="login_performance_glitch_user",parallel=true)
	public Object[][] testdata10()
	{
	return new Object[][]
	{
	 {"performance_glitch_user","secret_sauce"}
	};
	}
	
	@DataProvider(name="productdetails")
		public Object[][]testdata11() throws  IOException, InvalidFormatException 
		{
		    String[] products;
		    File products_file=new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+
			"My stuff"+File.separator+"Automation stuff"+File.separator+"Login_Testdata.xlsx");
	    	if(!products_file.exists())
	    	throw new FileNotFoundException();
	    	XSSFWorkbook Prod_book=new XSSFWorkbook(products_file);
		    XSSFSheet s=Prod_book.getSheetAt(1);
		    int cols=s.getRow(0).getLastCellNum();
		    products=new String[cols];
		    for(int i=0;i<cols;i++)
		    	{
		    		if(s.getRow(0)!=null && s.getRow(0).getCell(i)!=null)
		    		products[i]=s.getRow(0).getCell(i).toString(); 
		    	}
		    	Prod_book.close();
		    	return new Object[][] {{products}};
			}
	    	
};
	

