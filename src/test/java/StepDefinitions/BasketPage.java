package StepDefinitions;

import Component.GetDigits;
import Component.GetPrice;
import Driver.DriverClass;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Component.IdDataHelper.*;
import static Component.IdDataHelper.NULL_BASKET;
import static StepDefinitions.FindItems.itemPrice;

public class BasketPage extends DriverClass {

    @SneakyThrows
    @When("OPEN BASKET")
    public void open_basket(){

        clickMethod(BASKET);
        logger.info("Open Basket");
        String price = GetPrice.getPrice();
        Assert.assertEquals(itemPrice,price);

    }
    @SneakyThrows
    @When("ADD ITEM")
    public void add_item(){
        clickMethod(ADD_ITEM);
        logger.info("Add one more item");
        Thread.sleep(2000);
        String price = GetPrice.getPrice();
        Assert.assertEquals(GetDigits.findIntegers(itemPrice)*2, GetDigits.findIntegers(price));

    }
    @SneakyThrows
    @When("DELETE ALL ITEM")
    public void delete_all_item(){
        clickMethod(DELETE_BUTTON);
        logger.info("Delete all item from basket");
        Thread.sleep(2000);
        String nullBasket= driver.findElement(NULL_BASKET).getText();
        Assert.assertEquals(nullBasket, "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");

    }
}
