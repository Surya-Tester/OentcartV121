package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='firstname']")public WebElement firstname;
	@FindBy(xpath="//input[@name='lastname']")public WebElement lastname;
	@FindBy(xpath="//input[@name='email']")public WebElement email;
	@FindBy(xpath="//input[@name='telephone']")public WebElement number;
	@FindBy(xpath="//input[@name='password']")public WebElement password;
	@FindBy(xpath="//input[@name='confirm']")public WebElement Cnfpassword;
	@FindBy(xpath="//input[text()='Yes']")public WebElement newsletter;
	@FindBy(xpath="//input[@name='agree']")public WebElement agree;
	@FindBy(xpath="//input[@type='submit']")public WebElement submit;	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")public WebElement verifyaccount;	
	
	
	public void enterfname(String fname) {
		firstname.sendKeys(fname);
}
	public void enterlname(String lname) {
		lastname.sendKeys(lname);
}
	public void enteremail(String mail) {
	    email.sendKeys(mail);
}
	public void MobNO(String MoNO) {
		number.sendKeys(MoNO);
	}
	public void enterpassword(String pw) {
		password.sendKeys(pw);
}
	public void enterCnfpassword(String Cnfpw) {
		Cnfpassword.sendKeys(Cnfpw);
}
   public void selectnewsletter() {
	   newsletter.click();;
}
   public void policyagree() {
	   agree.click();;
}
   public void clkregisterbtn() {
		submit.click();;
}
 
   public String getconfirmationMsg() {
	   try {
		   return (verifyaccount.getText());
	   }
	   catch (Exception e) {
		   return (e.getMessage());
	   }
	 
   }
   
}
	
