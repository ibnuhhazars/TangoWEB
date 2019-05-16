import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/ibnuhhazar/Workspace/TangoWEB/feature/Registration.feature"},
        plugin = {"json:/Users/ibnuhhazar/Workspace/TangoWEB/target/cucumber-parallel/json/2.json"},
        monochrome = true,
        tags = {"@registration,@feedback"},
        glue = {"com.test.stepDef"})
public class Parallel02IT {
}
