package Runner;


import Component.DataConfig;
import Driver.DriverClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features",glue = {"StepDefinitions"},

        monochrome = true,
        plugin= {"pretty","json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"   },

        strict = true


)

public class RunnerTest {

    public static DataConfig data = new DataConfig();

    @BeforeClass
    public static void setup() throws IOException {
        data.properties();

    }
    @AfterClass()
    public static void teardown() {
        DriverClass.driver.close();
        DriverClass.driver.quit();

    }

}