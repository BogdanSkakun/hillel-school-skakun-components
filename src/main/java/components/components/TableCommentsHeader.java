package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class TableCommentsHeader extends ElementBase {
    public TableCommentsHeader(WebElement element) {
        super(element);
    }

    public ElementBase numberFilter(){
        return new ElementBase(getElement("//a[text()='Number']"));
    }
    public ElementBase commentTextFilter(){
        return new ElementBase(getElement("//a[text()='Comment Text']"));
    }
    public ElementBase activateFilter(){
        return new ElementBase(getElement("//a[text()='Active']"));
    }
}
