package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@name='email']")public WebElement Uname;
	@FindBy(xpath="//input[@name='password']")public WebElement password;
	@FindBy(xpath="//input[@value='Login']")public WebElement login;
	public void enterUsername(String username) {
		Uname.sendKeys(username);
	}
	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	public void clkloginbtn() {
		login.click();
	}

}
