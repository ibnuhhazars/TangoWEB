import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/ibnuhhazar/Workspace/TangoWEB/feature/Feedback.feature"},
        plugin = {"json:/Users/ibnuhhazar/Workspace/TangoWEB/target/cucumber-parallel/json/1.json"},
        monochrome = true,
        tags = {"@registration,@feedback"},
        glue = {"com.test.stepDef"})
public class Parallel01IT {
}
