package Santhiya.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		//ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sandy");
	}
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results not matching");
		System.out.println("Santhiya");
		extent.flush();
	}
}
