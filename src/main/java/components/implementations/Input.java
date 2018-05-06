package components.implementations;

import org.openqa.selenium.WebElement;

public class Input extends  ElementBase implements components.interfaces.Input {
    public Input(WebElement element) {
        super(element);
    }

    @Override
    public void setText(String text) {
        getWebElement().sendKeys(text);
    }

    @Override
    public void addText(String text) {

    }

    @Override
    public void clear() {
    getWebElement().clear();
    }
}
