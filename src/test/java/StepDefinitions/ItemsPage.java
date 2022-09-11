package StepDefinitions;

import Component.FileWriter;
import Driver.DriverClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import static Component.IdDataHelper.*;
import static StepDefinitions.FindItems.itemPrice;

public class ItemsPage extends DriverClass {


    public static String itemInfo;

    @SneakyThrows
    @When("SELECT ITEM")
    public void select_item(){

        clickMethod(ITEM_ID);
        logger.info("Select item");
    }
    @SneakyThrows
    @When("GET INFO")
    public void get_info(){

        itemInfo=driver.findElement(ITEM_INFO).getText();
        itemPrice=driver.findElement(ITEM_PRICE).getText();
        logger.info("Get item information");
        String item = itemPrice + "\n" + itemInfo;
        FileWriter.fileWrite(item);
    }
    @SneakyThrows
    @Then("ADD BASKET")
    public void add_basket(){
        clickMethod(ITEM_VARIATION);
        logger.info("Add item to basket");
        clickMethod(ADD_BASKET);
    }
}
