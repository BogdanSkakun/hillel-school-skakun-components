package components.pages;

import components.interfaces.Getter;
import components.loggers.ConsoleLogger;
import components.loggers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase implements Getter{

    protected WebDriver driver;
    private String url = "http://comments.azurewebsites.net";
    private String title = "Index";
    protected Logger logger = new ConsoleLogger();
    protected  String getUrl(){
        return url;
    }

    protected  String getTitle(){
        return  title;
    }
    public PageBase(WebDriver driver){
        this.driver=driver;
    }


    @Override
    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    @Override
    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public boolean checkPageIsOpen(){
        return  driver.getCurrentUrl().contains(getUrl()) && driver.getTitle().contains(getTitle());
    }
    protected void log(String textToLog) {
        logger.log(textToLog);
    }
}
