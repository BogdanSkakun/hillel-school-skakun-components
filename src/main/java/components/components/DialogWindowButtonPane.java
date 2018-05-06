package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class DialogWindowButtonPane extends ElementBase {
    public DialogWindowButtonPane(WebElement element) {
        super(element);
    }

    public ElementBase okButton(){return new ElementBase(getElement("//button[@type='button']"));}

}
