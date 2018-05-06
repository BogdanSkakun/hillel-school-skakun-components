package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class HeaderButtons extends ElementBase{

    public HeaderButtons(WebElement element) {
        super(element);
    }

    public ElementBase refreshButton(){
        return new ElementBase(getElement("//a[text()='Refresh']"));
    }
    public ElementBase saveButton(){
        return new ElementBase(getElement("//input[@value)='Save']"));
    }

    public ElementBase  saveAndReturn(){
        return new ElementBase(getElement("//input[@value='Save & Return']"));
    }
    public ElementBase Return(){
        return new ElementBase(getElement("//a[text()='Return']"));
    }

}
