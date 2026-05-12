package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PageLayer;
import testBase.TestLayer;
import utilities.DataProviders;

public class TestLoginPage extends TestLayer {

    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
    public void testLoginFunctionality(String username, String password) throws InterruptedException {

        logger.info("🚀 Browser launched");
        logger.info("🌐 Navigating to login page");

        PageLayer lp = new PageLayer(driver);
        
          Thread.sleep(5000);     
        lp.setUsername(username);
        lp.setPassword(password);
        lp.clickLogin();

        String actualTitle = driver.getTitle();

        if(actualTitle.equals(":: Connect Us ::"))
        {
            logger.info("✅ Login successful");

            // Logout only when login success
            lp.clickOnAvatar();
            lp.clickLogout();
             

            logger.info("✅ Logout successful"); 
        }
        else
        {
            logger.error("❌ Login failed");
            Assert.fail("Login Failed for user: " + username);
        }
    }
}