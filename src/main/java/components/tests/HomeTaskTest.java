package components.tests;

import components.components.CategorySelector;
import components.components.Form;
import components.components.Row;
import components.implementations.ElementBase;
import components.loggers.ConsoleLogger;
import components.loggers.Logger;
import components.pages.CommentPage;
import components.pages.NewCommentPage;
import components.urlbuilder.Url;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HomeTaskTest extends TestBase {
    private CommentPage commentPage;

    @Override
    public void beforeTest(){
        commentPage = new CommentPage(driver);


    }
    @Override
    public void afterTest(){

    }


    @Test
    public void addCommentE2eTest() {
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        Row createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Check comment is presented on list");
        assertNotNull("Input added not properly", createdComment);
        log("Check comment text is right");
        assertEquals("Input added not properly",
                createdComment.textColumn().getText(), commentText);
        log("Check comment category is right");
        assertEquals("Input added not properly",
                createdComment.categoryColumn().getText(), "Cat0");
    }
    @Test
    public void deleteComment(){
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        commentPage.navigateToPageWithComments(commentNumber);
        commentPage.deleteComment(commentNumber,true);
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        Assert.assertNotEquals(commentNumber, commentPage.tableComments().rowById().numberColumn().getText());

    }
    @Test
    public void actionsTest(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ElementBase link = new ElementBase(driver.findElement(By.cssSelector("input[value='New...']")));
        link.click();

        WebElement checkbox = driver.findElement(By.cssSelector("input[name='Active']"));

        new Actions(driver)
                .click(checkbox)
                .build()
                .perform();

        new Actions(driver)
                .sendKeys(Keys.SPACE)
                .build()
                .perform();

    }
    @Test
    public void createAndEditComment(){
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        Row createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Select checkbox for our comment");
        createdComment.checkedColumn().click();
        log("Click edit comment button");
        commentPage.navigationBlock().editButton().click();
        String newComment = "Highway to hell";
        log("Clear text field for coment");
        newCommentPage.form().commentField().clear();
        log("Set new comment");
        newCommentPage.form().commentField().setText(newComment);
        log("Save and return ");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Check comment is presented on list");
        assertNotNull("Input added not properly", createdComment);
        log("Check comment text is right");
        assertEquals("Input added not properly",
                createdComment.textColumn().getText(), newComment);
        log("Check comment category is right");
        assertEquals("Input added not properly",
                createdComment.categoryColumn().getText(), "Cat0");
    }
    @Test
    public void dupkicateCommentWithTheSameValueInNumberField(){
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        Row createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Select checkbox for our comment");
        createdComment.checkedColumn().click();
        log("Click duplicate comment button");
        commentPage.navigationBlock().duplicateButton().click();
        log("Save and return ");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Check error label for number field");
        Assert.assertEquals("The Number field should contain value from 0 to 999 and should be unique" ,
               newCommentPage.errorField().getText());

    }
    @Test
    public void dupkicateCommentWithTheSameValueInCommentField(){
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        Row createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Select checkbox for our comment");
        createdComment.checkedColumn().click();
        log("Click duplicate comment button");
        commentPage.navigationBlock().duplicateButton().click();
        log("Clear comment field");
        newCommentPage.form().commentField().clear();
        log("Set the comment");
        newCommentPage.form().commentField().setText(commentText);
        log("Clear number field");
        newCommentPage.form().numberField().clear();
        log("Set number");
        newCommentPage.form().numberField().setText(commentNumber + "2");
        log("Save and return ");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Check error label for number field");
        Assert.assertEquals("Comment already exists" ,
                newCommentPage.errorField().getText());

    }
    @Test
    public void dupkicateCommentWithEmptyValueInCommentField(){
        log("Click New comment button");
        commentPage.navigationBlock().newCommentButton().click();
        final String commentText = "test comment";
        final int commentNumber = ThreadLocalRandom.current().nextInt(50, 999);
        NewCommentPage newCommentPage =new NewCommentPage(driver);
        log("Wait for page navigation to happen");
        wait.until(ExpectedConditions.titleIs("Editor"));
        log("Set comment text");
        newCommentPage.form().commentField().setText(commentText);
        log("Add number to numberField");
        newCommentPage.form().numberField().setText("" + commentNumber);
        log("Add a category to comment");
        newCommentPage.selector().availableCats().categories().get(0).checkBox().check();
        log("Click add category button");
        newCommentPage.selector().selectButtons().add().click();
        log("Click SaveReturn button");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Checking comment is in the list");
        log("Sorting comments in the DESC order by Clicking Number twice");
        commentPage.tableComments().header().numberFilter().click();
        commentPage.tableComments().header().numberFilter().click();
        log("Navigating to the correct page");
        commentPage.navigateToPageWithComments(commentNumber);
        log("Getting our comment");
        Row createdComment =commentPage.getRowElementByNumber(commentNumber);
        log("Select checkbox for our comment");
        createdComment.checkedColumn().click();
        log("Click duplicate comment button");
        commentPage.navigationBlock().duplicateButton().click();
        log("Clear comment field");
        newCommentPage.form().commentField().clear();
        log("Clear number field");
        newCommentPage.form().numberField().clear();
        log("Set number");
        newCommentPage.form().numberField().setText(commentNumber + "2");
        log("Save and return ");
        newCommentPage.headerButtons().saveAndReturn().click();
        log("Check error label for number field");
        Assert.assertEquals("The Comment Text field is required." ,
                newCommentPage.errorValidationField().getText());

    }
    @Test
    public void editWithoutSelectComment(){
        log("Click Edit comment button");
        commentPage.navigationBlock().editButton().click();
        log("Check if  dialog window present");
        Assert.assertEquals("Please select one comment",
                commentPage.getWindowDialog().messsageDialog().getText());
        log("Click ok button on window dialog");
        commentPage.getWindowDialog().getButtonPane().okButton().click();
        log("Check if window disappeared");
        Assert.assertFalse(commentPage.getWindowDialog().isDisplayed());
    }
    @Test
    public void deletWithoutSelectComment(){
        log("Click Delete comment button");
        commentPage.navigationBlock().deleteButton().click();
        log("Check if  dialog window present");
        Assert.assertEquals("Please select at least one comment",
                commentPage.getWindowDialog().messsageDialog().getText());
        log("Click ok button on window dialog");
        commentPage.getWindowDialog().getButtonPane().okButton().click();
        log("Check if window disappeared");
        Assert.assertFalse(commentPage.getWindowDialog().isDisplayed());
    }
    @Test
    public void duplicateWithoutselectComment(){
        log("Click Duplicate comment button");
        commentPage.navigationBlock().editButton().click();
        log("Check if  dialog window present");
        Assert.assertEquals("Please select one comment",
                commentPage.getWindowDialog().messsageDialog().getText());
        log("Click ok button on window dialog");
        commentPage.getWindowDialog().getButtonPane().okButton().click();
        log("Check if window disappeared");
        Assert.assertFalse(commentPage.getWindowDialog().isDisplayed());
    }












    private void type(String xpath, String text){
            driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    private void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
}
