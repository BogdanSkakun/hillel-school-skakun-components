package components.pages;

import components.components.CategorySelector;
import components.components.Form;
import components.components.HeaderButtons;
import components.implementations.ElementBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCommentPage extends PageBase{

    private String relativePath = "/Editor/";

    public NewCommentPage(WebDriver driver) {
        super(driver);
    }

    public CategorySelector selector(){
        return new CategorySelector(getElement("//div[@id='categoryselector']"));
    }
    public HeaderButtons headerButtons(){
        return  new HeaderButtons(getElement("//div[@class='page']"));
    }
    public Form form(){
        return new Form(getElement("//div[@id='commentfields']"));
    }
    public ElementBase errorField(){
        return new ElementBase(getElement("//div[@id='errorfield']"));
    }
    public ElementBase errorValidationField(){
        return new ElementBase(getElement("//span[@class='field-validation-error']"));
    }
    @Override
    public String getUrl(){
        return  super.getUrl() + this.relativePath;
    }
}

