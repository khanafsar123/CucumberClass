package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = "steps" ,
        dryRun = false ,
        tags = "@sprint4 ",
        monochrome = true,
        plugin = {"pretty"}
)






public class SmokeRunner {

}
