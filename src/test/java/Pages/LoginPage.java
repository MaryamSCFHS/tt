package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@name='Password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_signin;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterFields(String email,String password) {
		
		txt_email.sendKeys(email);
		txt_password.sendKeys(password);
		
	}
	
	public void clickLogin() {
		
		btn_signin.click();
		
	}
	
	public void errorM(int countOfErrors) {
		
		if (countOfErrors<1) {
			
			throw new IllegalStateException("There is a invalid field that does not show an error masseage when entering invalid info");
			
		}
	}
	
	public void loginIsnotClickable() {
		
		if(btn_signin.isEnabled()) {
			throw new IllegalStateException("Signin button is clickable when there is invalid feialds");
		}
		
	}

}
