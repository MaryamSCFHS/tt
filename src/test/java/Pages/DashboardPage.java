package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="")
	WebElement btn_logout;
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	public void findLogoutbutton() {
		
		if(!btn_logout.isDisplayed()) {
			
			throw new IllegalStateException("This is not the dashboard, it might be wrong username and/or password");
			
		}
	}

}
