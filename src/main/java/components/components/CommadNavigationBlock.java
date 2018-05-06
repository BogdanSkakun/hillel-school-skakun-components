package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

public class CommadNavigationBlock extends ElementBase {
    public CommadNavigationBlock(WebElement element) {
        super(element);
    }

    public ElementBase newCommentButton(){
        return new ElementBase(getElement("//input[@value='New...']"));
    }
    public ElementBase duplicateButton(){
        return  new ElementBase(getElement("//input[@value='Duplicate...']"));
    }
    public ElementBase editButton(){
        return new ElementBase(getElement("//input[@value='Edit...']"));
    }
    public ElementBase deleteButton(){
        return new ElementBase(getElement("//input[@value='Delete']"));
    }
}
