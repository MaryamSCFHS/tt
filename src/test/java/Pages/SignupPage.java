package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement txt_fName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement txt_lName;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@name='confirmEmail']")
	WebElement txt_cEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@name='passwordConfirmation']")
	WebElement txt_cPassword;
	
	@FindBy(xpath = "//input[@id='acceptTerms']")
	WebElement cbox_TC;
	
	@FindBy(xpath = "//input[@id='emailDisclaimer']")
	WebElement cbox_updates;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement btn_signup;
	
	
	public SignupPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void enterFields(String fName, String lName, String email, String cEmail, String password, String cPassword) {
		
		txt_fName.sendKeys(fName);
		txt_lName.sendKeys(lName);
		txt_email.sendKeys(email);
		txt_cEmail.sendKeys(cEmail);
		txt_password.sendKeys(password);
		txt_cPassword.sendKeys(cPassword);
		
	}
	
	public void clickTandC() {
		
		cbox_TC.click();
		cbox_updates.click();
		
	}
	
	
	public void clickSignup() {
		
		btn_signup.click();
		
	}
	
	public void errorM(int countOfErrors) {
		
		if (6!=countOfErrors) {
			
			throw new IllegalStateException("There is a invalid field that does not show an error masseage when entering invalid info");
			
		}
	}
	
	public void signupIsnotClickable() {
		
		if(btn_signup.isEnabled()) {
			throw new IllegalStateException("Logout button is clickable when there is invalid feialds");
		}
		
	}
	

}
