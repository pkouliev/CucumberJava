package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = {"step_definitions"},
        monochrome = true,
        dryRun = false,
        //tags = "@Outline",
        plugin = {"pretty", "json:target/JSONReports/report.json",
                "html:target/HTMLReports/report.html",
                "junit:target/JUnitReports/report.xml"}
)
public class TestRunner {
}
