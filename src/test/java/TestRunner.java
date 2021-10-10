import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/java/features",
        glue={"stepDefs"},
        plugin={"html:target/reports/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}