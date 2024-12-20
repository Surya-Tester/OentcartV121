package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Logout' and @class='list-group-item' ]") public WebElement logout;
	@FindBy(xpath="//a[text()='Continue' ]") public WebElement cnflogout;
	@FindBy(xpath="//h2[text()='My Account']") public WebElement AccountPageVerification;
	
	public boolean isMyAccountPageExists() {
		try {
			return (AccountPageVerification.isDisplayed());
		} catch(Exception e) {
			return false;
	   }
	}
	public void clickLogout() {
		logout.click();
	}
	public void clkcnflogoutbtn() {
		cnflogout.click();
	}
}
