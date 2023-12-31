package testrunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"src/test/resources/features/PC1Form.feature"},
				features =	{"src/test/resources/features"},
		//features= {"target/test-classes/features/PC1Form.feature"},1
		//features= {"target/test-classes/features"},
		//features= {"target/test-classes/features/PC7Form-PassportRenewal.feature"},
		glue = {"stepdefinitions","AppHooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-json/cucumber.json"

		},
		dryRun=false,
		publish=false
		
		)
public class TestRunner {

}
