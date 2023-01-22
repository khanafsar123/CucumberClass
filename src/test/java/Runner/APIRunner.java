package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue = "APISteps" ,
        dryRun = false ,
        tags = "@apidynamic",
        monochrome = false,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
)

/*
@RunWith(Cucumber.class)
@CucumberOptions(

        //features we use to provide path of all the features files
        features = "src/test/resources/features/",
        glue = "Steps",

        //when you say dryRun=true it stops actual execution
        //it will quickly scan all gherkin steps whenever they are implemented or not
        dryRun = true,
        //when we start dryRun to false,it start execution again
        tags="@api",
        // if you need to run specific test case or cases you use tags, if we have more tags we put or between

        monochrome = true,
        // monochrome is used to remove irrelevant information from console

        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}
        // pretty is adding more details to console

        //to generate report we need plugin of runner class

        //this failed.txt file holds all the scenarios that are failed during execution
)
 */






public class APIRunner {

}
