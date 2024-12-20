package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass {
	   @Test(groups= {"Sanity", "Master"})
	  public void verifyLogin() {
		   logger.info("**** Starting TC_002_LoginTest");
		   HomePage hp = new HomePage(driver);
		   hp.clickMyAccount();
		   hp.clickLoginbtn();
		   
		   LoginPage lp = new LoginPage(driver);
		   lp.enterUsername(p.getProperty("username"));
		   lp.enterPassword(p.getProperty("password"));
		   lp.clkloginbtn();
		  
		   logger.info("Login Successfully");
		   
		  MyAccountPage mac = new MyAccountPage(driver);
		  boolean targetpage = mac.isMyAccountPageExists();
		  Assert.assertTrue(targetpage);
	  }

}
