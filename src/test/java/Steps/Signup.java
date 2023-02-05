package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashboardPage;
import Pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup {
	
	WebDriver driver;
	SignupPage signup;
	DashboardPage dashboard;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.setProperty("webdriver.chrome", "C:\\Users\\m.alasmari.t\\eclipse-workspace\\CJS\\src\\test\\resources\\Drivers\\chromedriver_win32.zip");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@When("user is on signup page")
	public void on_signup_page() {
		
		driver.navigate().to("https://sit-uniportal-01.scfhs.org.sa/#/user/signup");
		
	}

	@And("^user enters (.*) (.*) (.*) (.*) (.*) (.*)$")
	public void user_enters_wanted_fields(String fName, String lName, String email, String cEmail, String password, String cPassword) throws InterruptedException {
		
		signup = new SignupPage(driver);
		
		signup.enterFields(fName, lName, email, cEmail, password, cPassword);
		
		Thread.sleep(10000);
		
	}

	@And("user clicks terms and conditions checkbox")
	public void clicks_terms_conditions() {
		
		signup.clickTandC();
		
	}

	@And("user clicks signup button")
	public void clicks_signup() {
		
		signup.clickSignup();
		
	}

	@Then("user navigated to dashboard page")
	public void navigated_to_dashboard() {
		
		dashboard.findLogoutbutton();
		
		driver.quit();
		
	}
	
	@Then("error masseage will apear under every invalid field")
	public void error_masseage_under_invalid_fields() {
		
		List <WebElement> errorMassages=  driver.findElements(By.xpath("//div[@class='error']"));
		
		signup.errorM(errorMassages.size());
		
	}
	
	@Then("user can not click signup button")
	public void canntClicksignup() {
		
		signup.signupIsnotClickable();
		
		
	}


}
