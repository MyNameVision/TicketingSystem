package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLayer extends BaseLayer {

	
	public PageLayer(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='email_id']") 
	WebElement txt_Username;


	@FindBy(xpath="//input[@id='password']") 
	WebElement txt_Password;
	

	@FindBy(xpath="//button[normalize-space()='SIGN IN']") 
	WebElement btn_Loginbtn;
	
	@FindBy(xpath="//img[@class='avatar lg rounded-circle img-thumbnail']") 
	WebElement img_avatar;
	
	@FindBy(xpath="//i[@class='icofont-sign-out fs-5 me-3']") 
	WebElement btn_Logoutbtn;
	
	public void setUsername(String username) {
		txt_Username.clear();
		txt_Username.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_Loginbtn.click();
		
//	1.	 btn_Loginbtn.submit();
		
//	2.	Actions act = new Actions(driver);
//		act.moveToElement(btn_Loginbtn).click().perform();
		
//	3.	JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", btn_Loginbtn);
		
//	4. 	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btn_Loginbtn)).click();
	}
	
	public void clickOnAvatar() {
		img_avatar.click();
	}
	public void clickLogout() {
		btn_Logoutbtn.click();
	}
}
