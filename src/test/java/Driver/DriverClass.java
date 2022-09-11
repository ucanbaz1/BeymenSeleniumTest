package Driver;

import Component.DataConfig;
import Exceptions.Exceptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;
import org.apache.log4j.Logger;
public class DriverClass {

    public static WebDriver driver;
    //private static Logger logger = Logger.getLogger(DriverClass.class.getName());
    protected final static Logger logger = Logger.getLogger(DriverClass.class);
    private static final int USER_WAIT_IN_MS = 1000;
    private static final int EXPECTED_CONDITION_TIMEOUT = 10;
    private static final int EXPECTED_CONDITION_POLLING_INTERVAL = 3;




    public static void openBrowser() throws IOException {



        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(DataConfig.LOGIN_ADDRESS);
        logger.info("Open Browser");
        driver.manage().window().maximize();
        logger.info("Maximize window size");

    }

    public <id, keyString> void sendKeysMethod(id id, keyString keyString) throws Exceptions {
        sleepms(USER_WAIT_IN_MS);
        if ((id == null))
            throw new Exceptions(id + "is null");
        else if (!(id instanceof WebElement) && !(id instanceof By))
            throw new Exceptions(id + "parameter type not supported by sendKeys function");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(EXPECTED_CONDITION_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(EXPECTED_CONDITION_POLLING_INTERVAL))
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);

        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = null;
                if (id instanceof By) {
                    el = driver.findElement((By) id);
                } else {
                    el = ((WebElement) id);
                }
                if (keyString instanceof String) {
                    el.clear();
                    el.sendKeys(((String) keyString));
                } else if (keyString instanceof Keys) {
                    el.sendKeys(((Keys) keyString));
                }
                sleepms(500);
                return el;
            }
        });
    }

    public <id> void clickMethod(id id) throws Exceptions {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(EXPECTED_CONDITION_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(EXPECTED_CONDITION_POLLING_INTERVAL))
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(org.openqa.selenium.TimeoutException.class)
                .ignoring(WebDriverException.class)
                .ignoring(ElementClickInterceptedException.class);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = null;
                if (id instanceof By) {
                    el = driver.findElement((By) id);
                } else if (id instanceof WebElement) {
                    el = ((WebElement) id);
                } else if (id instanceof String) {
                    logger.info("id is " + id);
                    el = (WebElement) ((JavascriptExecutor) driver).executeScript("return " + String.valueOf(id));
                    if (el == null)
                        return null;
                }

                new WebDriverWait(driver, 3)
                        .until(ExpectedConditions.elementToBeClickable(el));
                el.click();
                return el;
            }
        });
        sleepms(USER_WAIT_IN_MS);
    }

    public static void sleepms(long time) {
        logger.info("Sleeping for " + time + " ms");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





