package components.pages;

import components.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class CommentPage extends PageBase {



    public CommentPage(WebDriver driver) {
        super(driver);
    }

    public TableComments tableComments(){
        return new TableComments(getElement("//table[@class='webgrid']"));
    }
    public CommadNavigationBlock navigationBlock(){
        return new CommadNavigationBlock(getElement("//div[@id='command-navigation']"));
    }

    public DialogWindow getWindowDialog(){
        return new DialogWindow(getElement("//div[@role='dialog']"));
    }

    public void deleteComment(int comentNumber, boolean confirmDelete){
        log("Find comment");
        Row comentRow = getRowElementByNumber(comentNumber);
        if(comentRow != null){
            log("Click checkbox with row number " + comentNumber);
            comentRow.checkedColumn().click();
            driver.findElement(By.cssSelector("input[value='Delete']")).click();
            if(confirmDelete){
                log("Confirm deleting comment");
                driver.findElement(By.xpath("//span[text()='Yes']")).click();
                log("Comment deleted");
            }else{
                log("Cancel deleting comment");
                driver.findElement(By.xpath("//span[text()='No']")).click();
            }

        }else {
            log("Comment wasn't deleted");
        }
    }

    public void navigateToPageWithComments(int commentNumber) {
        java.util.List<WebElement> numbers = driver.findElements(By.cssSelector(".numbercolumn"));
        int firstCommentNumber = Integer.valueOf(numbers.get(0).getText());
        int lastCommentNumber = Integer.valueOf(numbers.get(numbers.size() - 1).getText());

        log("Clicking next page button if the comment is not on the page");
        while (!(firstCommentNumber >= commentNumber && lastCommentNumber <= commentNumber)) {

            log("You are on the wrong page! First comment #: " + firstCommentNumber +
                    ", your comment #" + commentNumber
                    + " ,last comment number" + lastCommentNumber);
            tableComments().footer().nextPageButton().click();
            numbers = driver.findElements(By.cssSelector(".numbercolumn"));
            firstCommentNumber = Integer.valueOf(numbers.get(0).getText());
            lastCommentNumber = Integer.valueOf(numbers.get(numbers.size() - 1).getText());
        }

        log("You are on the right page! First comment #: " + firstCommentNumber +
                ", your comment #: " + commentNumber
                + " ,last comment #: " + lastCommentNumber);
    }

    public Row getRowElementByNumber(int elementNumber) {
        List<WebElement> rows =
                driver.findElement(By.cssSelector("tbody"))
                        .findElements(By.cssSelector("tr"));
        WebElement row= rows.stream()
                .filter( i -> i.findElement(By.cssSelector(".numbercolumn"))
                .getText()
                .equals("" + elementNumber))
                .findFirst().get();
        return new Row(row);


    }


}
