package fitness;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType; 

@RunWith(Cucumber .class)
@CucumberOptions(features="Features",
snippets=SnippetType.CAMELCASE,
glue= {"fitness"})

public class AcceptanceTest {

}
