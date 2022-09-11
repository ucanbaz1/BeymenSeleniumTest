package StepDefinitions;


import Component.DataConfig;
import Driver.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;



import static Component.IdDataHelper.CHECK_LOGIN;


public class LoginPage extends DriverClass{
    DataConfig data = new DataConfig();

    @Given("OPEN BROWSER AND LOGIN")
    public void open_browser() throws IOException {

        data.properties();
        data.propertiesExcel("dataXlsx.xlsx");
        openBrowser();

    }

    @Then("USER IS NAVIGATE to PAGE")
    public void user_is_navigate_to_page() {
        Assert.assertEquals(driver.findElement(CHECK_LOGIN).isDisplayed(), true);
    }

}
