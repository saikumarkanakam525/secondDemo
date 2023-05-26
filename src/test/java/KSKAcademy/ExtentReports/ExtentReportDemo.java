package KSKAcademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		//ExtentReports, ExtentSparkReporter - Helper class to set configurations to the report that is going to be created by main class - ExtentReports
		
		String path = System.getProperty("user.dir")+ "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); //ExtentSparkReporter takes "path" to create report
		reporter.config().setReportName("Web Automation Results");  //To set report name in html
		reporter.config().setDocumentTitle("Test Results");       //To set tab name in html
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sai Kumar");
		
	}
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("Initial Demo"); //To keep on monitoring the method(test case) to get the result status
		WebDriverManager.chromedriver().setup();   //To download chromedriver and invoke the chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match");
		extent.flush();
		
		System.out.println("everytime");
	}

}
