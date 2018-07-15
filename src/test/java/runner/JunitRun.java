package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features="src/test/java/Feature/login.feature", glue= {"Steps","pages"}, monochrome=true, tags="@smoke")
@RunWith(Cucumber.class)
public class JunitRun {

	
	
	
}
