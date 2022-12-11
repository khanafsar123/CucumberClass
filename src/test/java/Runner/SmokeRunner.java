package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = "steps" ,
        dryRun = false ,
        tags = "@sprint3",
        monochrome = false,
        plugin = {"pretty"}
)






public class SmokeRunner {

}
