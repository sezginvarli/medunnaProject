package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "C:/Users/Pc/IdeaProjects/medunnaProject/src/test/resources/features/api_features",
        glue = {"stepdefinitions","hooks"},
<<<<<<< HEAD:src/test/java/runners/UIRunner.java
        tags = "@US03",
=======
        tags = "@US_06_TC_03",
>>>>>>> main:src/test/java/runners/Runner.java
        dryRun = false

)
public class UIRunner {
}