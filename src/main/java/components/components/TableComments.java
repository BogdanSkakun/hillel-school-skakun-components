package components.components;

import components.implementations.ElementBase;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TableComments extends ElementBase {
    public TableComments(WebElement element) {
        super(element);
    }

    public List<Row> rows(){
        return getElements("//tr").stream()
                .map(i -> new Row(i))
                .collect(Collectors.toList());
    }

    public TableCommentsHeader header(){
        return new TableCommentsHeader(getElement("//tr[@class='webgrid-header']"));
    }
    public TableCommentsFooter footer(){
        return new TableCommentsFooter(getElement("//tr[@class='webgrid-footer']"));
    }
    public Row rowById(){
        return new Row(getElement("//tr"));
    }
}
