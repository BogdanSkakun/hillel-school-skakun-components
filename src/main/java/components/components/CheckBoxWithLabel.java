package components.components;

import components.implementations.CheckBox;
import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

/**
 * Created by HillelNew5 on 25.03.2018.
 */
public abstract class CheckBoxWithLabel extends ElementBase {

    public CheckBoxWithLabel(WebElement element) {
        super(element);
    }
    public abstract CheckBox checkBox();
    public abstract ElementBase label();



}
