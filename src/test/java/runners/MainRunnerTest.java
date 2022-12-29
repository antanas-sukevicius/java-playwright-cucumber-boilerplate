package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"progress","html:target/test-report.html",
                "json:target/test-report.json",
                "junit:target/test-report.xml",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        monochrome = true,
        glue = "steps/ui"
)

public class MainRunnerTest {
}
