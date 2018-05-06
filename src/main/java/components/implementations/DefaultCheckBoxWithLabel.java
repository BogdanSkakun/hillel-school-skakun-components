package components.implementations;

import components.components.CheckBoxWithLabel;
import org.openqa.selenium.WebElement;

/**
 * Created by HillelNew5 on 01.04.2018.
 */
public class DefaultCheckBoxWithLabel extends CheckBoxWithLabel {
    public DefaultCheckBoxWithLabel(WebElement element) {
        super(element);

    }
    @Override
    public CheckBox checkBox(){
        return new CheckBox(getElement("//input[@id='Categories']"));
    }
    @Override
    public ElementBase label(){
        return new ElementBase(getElement("//span"));
    }
}
