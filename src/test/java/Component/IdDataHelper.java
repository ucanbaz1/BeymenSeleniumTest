package Component;

import org.openqa.selenium.By;


public class IdDataHelper {

    public static final By CHECK_LOGIN = By.xpath("//*[@title='Hesabım']");
    public static final By INPUT_ITEM = By.xpath("//*[@placeholder='Ürün, Marka Arayın']");
    public static final By ITEM_ID = By.xpath("//*[@data-page='1']");
    public static final By ITEM_INFO = By.xpath("//*[@class='m-productDescription__infoList']");
    public static final By ITEM_PRICE=By.id("priceNew");

    public static final By ADD_BASKET=By.id("addBasket");

    public static final By ITEM_VARIATION=By.xpath("//*[@class='m-variation__item']");

    public static final By BASKET=By.xpath("//*[@title='Sepetim']");

    public static final By ITEM_PRICE_ON_BASKET=By.xpath("//*[@class='m-orderSummary__item -grandTotal']");
    public static final By ADD_ITEM=By.xpath("//*[@value='2']");

    public static final By ITEM_COUNT=By.id("quantitySelect0-key-0");

    public static final By DELETE_BUTTON=By.id("removeCartItemBtn0-key-0");

    public static final By NULL_BASKET=By.xpath("//*[@class='m-empty__messageTitle']");


}
