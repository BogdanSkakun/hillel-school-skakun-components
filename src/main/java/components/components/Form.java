package components.components;

import components.implementations.CheckBox;
import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

/**
 * Created by HillelNew5 on 29.03.2018.
 */
public class Form extends ElementBase {
    public Form(WebElement element) {
        super(element);
    }

    public InputWithLabel commentField(){

        return  new InputWithLabel(getElement("//input[@id='Text']"));
    }
    public InputWithLabel numberField(){
        return  new InputWithLabel(getElement("//input[@id='Number']"));
    }
    public CheckBox activeCheckbox(){
        return  new CheckBox(getElement("//input[@id='Active']"));
    }
}
