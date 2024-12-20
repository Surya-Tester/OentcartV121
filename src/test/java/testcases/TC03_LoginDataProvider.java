package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDataProvider extends BaseClass {
	
	  @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven" )
	  public void verifyLoginDDT(String email, String pwd, String exp) {

		   logger.info("**** Starting TC_003_LoginTest");
		   HomePage hp = new HomePage(driver);
		   hp.clickMyAccount();
		   hp.clickLoginbtn();
		   
		   LoginPage lp = new LoginPage(driver);
		   lp.enterUsername(email);
		   lp.enterPassword(pwd);
		   lp.clkloginbtn();
		  
		   logger.info("Login Successfully");
		   
		  MyAccountPage mac = new MyAccountPage(driver);
		  boolean targetpage = mac.isMyAccountPageExists();
		  
		  if(exp.equalsIgnoreCase("Valid"))
		  {
			  if(targetpage==true) {
				  mac.clickLogout();
				  mac.clkcnflogoutbtn();
				  Assert.assertTrue(true);
				  
			  }
			  else {
				  Assert.assertTrue(false);
			  }
			  
		  }
		  if(exp.equalsIgnoreCase("Invalid")) {
			  if(targetpage==true) {
				  mac.clickLogout();
				  Assert.assertTrue(false);
			  }
			  else {
				  Assert.assertTrue(true);
			  }
		  }

}
	  
	  } 
     