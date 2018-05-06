package components.components;

import components.implementations.DefaultCheckBoxWithLabel;
import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by HillelNew5 on 25.03.2018.
 */
public class CategoriesBlock extends ElementBase {

    public CategoriesBlock(WebElement element){
        super(element);

    }
    public ElementBase headerLabel() {
        return new ElementBase(getElement("//div[@class='category-list-title']"));
    }

    public List<CheckBoxWithLabel> categories() {

       return getElements("//div").stream()
        .map(i -> new DefaultCheckBoxWithLabel(i))
        .collect(Collectors.toList());


    }
}
