package components.components;

import components.implementations.ElementBase;
import components.implementations.Input;
import org.openqa.selenium.WebElement;

public class InputWithLabel extends Input {
    public InputWithLabel(WebElement element) {
        super(element);
    }
    public Input commentInput(){
        return  new Input(getElement("//input[@id='Input']"));
    }
    public ElementBase commentLabel(){
        return new ElementBase(getElement("//label[text()='Comment Input']"));
    }
    public Input numberInput(){
        return  new Input(getElement("//input[@id='Number']"));
    }
    public ElementBase numberLabel(){
        return new ElementBase(getElement("//label[text()='Number']"));
    }



}
