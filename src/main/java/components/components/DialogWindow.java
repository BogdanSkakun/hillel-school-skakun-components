package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class DialogWindow extends ElementBase {
    public DialogWindow(WebElement element) {
        super(element);
    }

    public DialogWindowButtonPane getButtonPane(){
        return new DialogWindowButtonPane(getElement("//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']"));
    }
    public ElementBase messsageDialog(){
        return new ElementBase(getElement("//div[@id='dialog']"));
    }
}
