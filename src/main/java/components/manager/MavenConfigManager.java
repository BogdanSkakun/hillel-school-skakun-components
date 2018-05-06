package components.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MavenConfigManager {
    private static MavenConfigManager configManager;


    private MavenConfigManager(){}

    public static  MavenConfigManager getConfigManager(){
        if (configManager==null){
            return configManager = new MavenConfigManager();
        }
        return configManager;
    }
    public static WebDriver getWebDriver(){
        String valueFromProfile;
        WebDriver driver = null;
        Properties props =new Properties();
        InputStream stream = MavenConfigManager.class.getResourceAsStream("/config.properties");
        try {
            props.load(stream);
        }catch(IOException e){
            e.printStackTrace();
        }
        valueFromProfile = props.getProperty("driverType");
        switch (valueFromProfile){
            case "Chrome"  : driver = new ChromeDriver();
                            break;
            case "Firefox" : driver = new FirefoxDriver();
                             break;
        }
        return driver;
    }
    public  String getEnvironment(){
        String environment = "";
        String valueFromProfile;
        Properties props =new Properties();
        InputStream stream = MavenConfigManager.class.getResourceAsStream("/config.properties");
        try {
            props.load(stream);
        }catch(IOException e){
            e.printStackTrace();
        }
        valueFromProfile = props.getProperty("environment");
        switch (valueFromProfile){
            case "Staging"  : environment = "Staging";
                break;
            case "Beta" : environment = "Beta";
                break;
            case "Prod" : environment = "Prod";
                break;
                default : environment = "Staging";
                break;
        }


        return environment;
    }
    public  WebDriver.Timeouts getImplicityWait(){
        WebDriver driver = getWebDriver();
        WebDriver.Timeouts timeouts = null;
        String valueFromProfile;
        Properties props =new Properties();
        InputStream stream = MavenConfigManager.class.getResourceAsStream("/config.properties");
        try {
            props.load(stream);
        }catch(IOException e){
            e.printStackTrace();
        }
        valueFromProfile = props.getProperty("implicitWay");
        switch (valueFromProfile){
            case "5"  : timeouts = driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                break;
            case "10" : timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "20" : timeouts = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                break;
            default : timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
      return  timeouts;


    }


}
