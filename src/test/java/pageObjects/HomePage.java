package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//span[text() ='My Account']") public WebElement myaccount;
	@FindBy(xpath = "//a[text() = 'Register']") public WebElement register;
	@FindBy(xpath = "//a[text() = 'Login']") public WebElement login;
	
	public void clickMyAccount() {
		myaccount.click();
	}
	public void clickRegister() {
		register.click();
	}
	
	public void clickLoginbtn() {
		login.click();
	}

}


