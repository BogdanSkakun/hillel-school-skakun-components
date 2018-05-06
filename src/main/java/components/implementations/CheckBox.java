package components.implementations;

import org.openqa.selenium.WebElement;

public class CheckBox extends ElementBase implements components.interfaces.CheckBox
{
    public CheckBox(WebElement element) {
        super(element);
    }


    @Override
    public void check() {
        if(!isChecked()){
            click();
        }
    }

    @Override
    public void unCheck() {
        if (isChecked()){
            click();
        }

    }

    @Override
    public boolean isChecked() {
        return getWebElement().isSelected();
    }
}
