package cl.atromilen.cucumberselenium;

import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "",
        features = "src/test/java/cl/atromilen/cucumberselenium/features",
        glue = {"cl.atromilen.cucumberselenium.steps"},
        plugin = {
                "json:build/cucumber-reports/cucumber.json",
                "rerun:build/cucumber-reports/rerun.txt"
        }
)
public class RunnerCucumberTests extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

}
