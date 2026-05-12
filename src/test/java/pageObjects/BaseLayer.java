package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseLayer {
	
	WebDriver driver;
	
  public BaseLayer(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);	
  }
}
