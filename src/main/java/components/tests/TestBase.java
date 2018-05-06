package components.tests;

import components.components.Form;
import components.enums.WebDriverType;
import components.loggers.ConsoleLogger;
import components.loggers.Logger;
import components.manager.WebDriverManager;
import components.urlbuilder.Url;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HillelNew5 on 01.04.2018.
 */
public abstract class TestBase {
    protected Logger logger;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Form form;

    @Before
    public void setUp() {
        logger = new ConsoleLogger();
        driver = WebDriverManager.getWebDriver(WebDriverType.CHROME_DRIVER);
        wait = new WebDriverWait(driver, 10);

        log("Setting window size");
        driver.manage().window().setSize(new Dimension(1280, 760));

        log("Navigating to Comments website");
        String url = new Url.UrlBuilder("comments.azurewebsites.net")
                .withHttps(false)
                .build()
                .getUrl();
        driver.get(url);
        beforeTest();

    }

    @After
    public void tearDown() {
        afterTest();
        driver.quit();
    }
    protected void log(String textToLog) {
        logger.log(textToLog);
    }

    protected  void beforeTest(){

    }
    protected  void afterTest(){

    }
}
