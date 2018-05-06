package components.components;

import components.implementations.Input;
import org.openqa.selenium.WebElement;

public class InputField extends Input {
    public InputField(WebElement element) {
        super(element);
    }

    public Input commentInput(){
        return  new Input(getElement("//input[@id='Input']"));
    }
    public Input numberInput(){
        return  new Input(getElement("//input[@id='Number']"));
    }

}
