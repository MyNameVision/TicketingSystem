package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestLayer {


	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	public void setup() throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		
		
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		p=new Properties();
	    p.load(file);
		
		
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass 
	public void teardown() {
		driver.close();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generateNumbers= RandomStringUtils.randomNumeric(10);
		return generateNumbers;
	}
	
	public String randomAlphaNumeric() {
		String generateAlpha = RandomStringUtils.randomAlphabetic(3);
		String generateNumeric = RandomStringUtils.randomNumeric(5);
		return (generateAlpha+"@"+generateNumeric);
	}
}
 