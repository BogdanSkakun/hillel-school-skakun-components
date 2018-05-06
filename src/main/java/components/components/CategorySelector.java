package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by HillelNew5 on 25.03.2018.
 */
public class CategorySelector extends ElementBase {

    public CategorySelector(WebElement element){
        super(element);
    }

    public CategoriesBlock availableCats(){
        List<WebElement> blocks = getElements("//div[@class='categories']");
        WebElement availableCatsWebEl =
                blocks.stream().filter(i -> i.getText().contains("Available")).findAny().get();
        return new CategoriesBlock(availableCatsWebEl);
    }

    public CategoryButtons selectButtons(){
        WebElement  element =  getElement("//div[@class='selectbuttons']");

        return new CategoryButtons(element);
    }

    public  CategoriesBlock selectedCats(){
        List<WebElement>  blocks =  getElements("//div[@class='categories']");
        WebElement selectedCatsWebEl = blocks.stream().filter(i->i.findElement(By.xpath("//div[@class='category-list-title']"))
                .getText().contains("available")).findAny().get();
        return new CategoriesBlock(selectedCatsWebEl);
    }
}
