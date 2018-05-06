package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class Row extends ElementBase {
    public Row(WebElement element) {
        super(element);
    }

    public ElementBase checkedColumn(){
        return new ElementBase(getElement("//td[@class='checkedcolumn']"));
    }
    public ElementBase numberColumn(){
        return new ElementBase(getElement("//td[@class='numbercolumn']"));
    }
    public ElementBase textColumn(){
        return new ElementBase(getElement("//td[@class='textcolumn']"));
    }
    public ElementBase inActivationColumn(){
        return new ElementBase(getElement("//td[@class='inactivecolumn']"));
    }
    public ElementBase categoryColumn(){
        return new ElementBase(getElement("//td[@class='categorycolumn']"));
    }
}
