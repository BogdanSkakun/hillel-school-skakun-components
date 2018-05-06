package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class TableCommentsFooter extends ElementBase {
    public TableCommentsFooter(WebElement element) {
        super(element);
    }
    public ElementBase nextPageButton(){
        return new ElementBase(getElement("//a[text()='>']"));
    }
    public ElementBase previousPageButton(){
        return new ElementBase(getElement("//a[text()='<']"));
    }
}
