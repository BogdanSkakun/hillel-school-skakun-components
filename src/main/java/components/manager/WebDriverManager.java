package components.manager;

import components.enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private  static WebDriver driver;



    private WebDriverManager(){}

    public static WebDriverManager getWebDriverManager(){
        if(webDriverManager == null){
            webDriverManager = new WebDriverManager();
        }
            return webDriverManager;
    }

    public static WebDriver getWebDriver(WebDriverType type){
        if(driver == null){
            switch (type){
                case CHROME_DRIVER:  driver = new ChromeDriver();
                                       break;
                case FIREFOX_DRIVER:  driver = new FirefoxDriver();
                                        break;
            }
        }
        return driver;
    }

}
