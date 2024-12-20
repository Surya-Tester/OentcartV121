package testcases;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistration extends BaseClass {
   
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Registartion button clicked");
		
		AccountRegistrationPage reg = new AccountRegistrationPage(driver);
		reg.enterfname(randomString());
		reg.enterlname(randomString());
		reg.enteremail(randomString()+"@gmail.com");
		reg.MobNO(ranomNumber());
		String password = randomPassword();
		reg.enterpassword(password);
		reg.enterCnfpassword(password);
		logger.info("Matching Password Successfully entered"); 
		reg.policyagree();
		reg.clkregisterbtn();
		logger.info("registartion completed");
		reg.getconfirmationMsg();
		Assert.assertEquals("Your Account Has Been Created!", "Your Account Has Been Created!");
	}
	catch(Exception e) {
		logger.error("Test Failed...");
		logger.debug("Debug logs...");
		Assert.fail();
  }	
 }
}
	
	

