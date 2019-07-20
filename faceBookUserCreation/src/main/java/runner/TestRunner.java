package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = { "stepDefinition" }, format = { "pretty",
		"html:target/cucumber-reports" }, monochrome = true,  tags= {"@UserCreation,@LoginTest"})

public class TestRunner {

}
