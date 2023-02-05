package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	LoginPage login;
	DashboardPage dashboard;
	
	@Given("browser is open1")
	public void browser_is_open() {
		
		System.setProperty("webdriver.chrome", "C:\\Users\\m.alasmari.t\\eclipse-workspace\\CJS\\src\\test\\resources\\Drivers\\chromedriver_win32.zip");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		driver.navigate().to("https://sit-uniportal-01.scfhs.org.sa/#/user/signin");
		
	}
	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_email_and_password(String email, String password) throws InterruptedException {
		
		login = new LoginPage(driver);
		login.enterFields(email, password);
		
		Thread.sleep(2000);
		
	}
	
	@When("user clicks login button")
	public void user_clicks_login_button() {
		
		login.clickLogin();
		
	}
	
	@Then("error masseage will apear under invalid field")
	public void error_masseage_will_apear_under_invalid_field() {
		
		List <WebElement> errorMassages=  driver.findElements(By.xpath("//div[@class='error']"));
		
		login.errorM(errorMassages.size());
		
	}

	@Then("user can not click Login button")
	public void user_can_not_click_login_button() {
		
		login.loginIsnotClickable();
		
	}

}
