package Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ReporterclassTest
{
public static ExtentSparkReporter espr;
public static ExtentReports erp;
public static ExtentReports createReport()
{
espr=new ExtentSparkReporter("target/LoginAutomationreport.html");
erp=new ExtentReports();
erp.attachReporter(espr);
return erp;
}
}
