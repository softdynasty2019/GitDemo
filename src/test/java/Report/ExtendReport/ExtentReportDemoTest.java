package Report.ExtendReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoTest {
	
	ExtentReports extent;

	@BeforeTest 
	
	public void config() {
		
	//Extent Report-Generate Report //ExtentSparkReport	--Config Report
		
		
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		//It will write The report which is collected 
		ExtentSparkReporter report=new ExtentSparkReporter(Path);
		report.config().setReportName("Web Automation Report");
		report.config().setDocumentTitle("Google Home Page Automation Report");
		
		//It will collect the Result From  the Test 
		extent =new ExtentReports ();
		extent.attachReporter(report);
		extent.createTest("Test Report");
		extent.setSystemInfo("Qa Tester","Masud Rana");
				
	}
	
	@Test
	public void googleHomePage() {
		
		extent.createTest("googleHomePage");
		System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println("USA QA CODE");
		System.out.println("Bangladesh QA CODE");
		driver.getTitle();
		driver.close();
		extent.flush();
		
		
		
	}
	
	
}
