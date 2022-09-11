package Component;

import Driver.DriverClass;
import org.apache.commons.lang3.StringUtils;

import static Component.IdDataHelper.ITEM_PRICE_ON_BASKET;

public class GetPrice extends DriverClass {

    public static String getPrice(){
        String itemPriceExpected=driver.findElement(ITEM_PRICE_ON_BASKET).getText();
        String subPrice = StringUtils.substringAfterLast(itemPriceExpected, "\n");
        return subPrice;
    }
}
