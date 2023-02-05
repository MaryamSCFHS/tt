package Steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features",
glue= {"Steps"}, monochrome = true, tags="@Smoke",
plugin = {"pretty","html:target\\Reports.html"})

public class Runner {
	

}
