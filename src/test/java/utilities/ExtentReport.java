package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
 public ExtentSparkReporter sparkReporter;
 public ExtentReports extent;
 public ExtentTest test;
 
 String reportName;
 
 
 public void onStart(ITestContext testContext) {
	 
	 String timeStamp = new SimpleDateFormat("MM.DD.YYYY.HH.MM.SS").format(new Date());
	 reportName="Test_Report-"+timeStamp +".html";
	 sparkReporter = new ExtentSparkReporter(".\\report\\"+reportName);
	 
	 sparkReporter.config().setDocumentTitle("Ticketing System Automation Report");
	 sparkReporter.config().setReportName("Ticketing System Automation Report");
	 sparkReporter.config().setTheme(Theme.DARK);
	 
	 extent = new ExtentReports();
	 extent.attachReporter(sparkReporter);
	 extent.setSystemInfo("Website", "Ticketing System");
	 extent.setSystemInfo("Module", "Admin");
	 extent.setSystemInfo("Sub-Module", "Customer");
	 extent.setSystemInfo("UserName", System.getProperty("user.name"));
	String os= testContext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);
	
	String browser = testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	
	List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
	if(!includeGroups.isEmpty()) {
		extent.setSystemInfo("Included Groups", String.join(", ", includeGroups));
	}
	 
	
 }
}
