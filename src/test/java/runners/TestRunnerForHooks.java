package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/HooksDemo/HooksDemo.feature",
        glue = {"StepsForHooks.java"},
        monochrome = true,
        dryRun = true,
        //tags = "@Outline",
        plugin = {"pretty", "json:target/JSONReports/report.json",
                "html:target/HTMLReports/report.html",
                "junit:target/JUnitReports/report.xml"}
)

public class TestRunnerForHooks {
}
