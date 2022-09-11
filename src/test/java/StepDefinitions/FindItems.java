package StepDefinitions;

import Component.DataConfig;
import Driver.DriverClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static Component.IdDataHelper.*;


public class FindItems extends DriverClass {


    public static String itemPrice;


    @When("ON MAIN PAGE")
    public void on_main_page()  {
        Assert.assertEquals(driver.findElement(CHECK_LOGIN).isDisplayed(), true);
        logger.info("Check the user is on main pager or not");
    }

    @SneakyThrows
    @When("ENTER ITEM1")
    public void enter_item1(){
        System.out.println(DataConfig.dataConfigXlsx[0][0]);
        logger.info("Search for 'şort' word");
        sendKeysMethod(INPUT_ITEM, DataConfig.dataConfigXlsx[0][0]);
    } @SneakyThrows
    @When("ENTER ITEM2")
    public void enter_item2(){
        Thread.sleep(1000);
        System.out.println(DataConfig.dataConfigXlsx[1][0]);
        logger.info("Search for 'gömlek' word");
        sendKeysMethod(INPUT_ITEM, DataConfig.dataConfigXlsx[1][0]);
    }
    @SneakyThrows
    @When("DELETE ITEM")
    public void delete_item(){

        sendKeysMethod(INPUT_ITEM, Keys.CONTROL+"A");
        sendKeysMethod(INPUT_ITEM, Keys.DELETE);
    }
    @SneakyThrows
    @Then("CLICK ENTER")
    public void click_enter(){

        sendKeysMethod(INPUT_ITEM, Keys.ENTER);
    }
}
