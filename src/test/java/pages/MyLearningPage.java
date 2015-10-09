package pages;

import org.openqa.selenium.*;
import utils.MainClass;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by roma on 10/8/15.
 */
public class MyLearningPage extends MainClass {


    public static By dropDowm = By.name("select_course");
    public static By helpLink = By.id("forumhelplink");

    public static void changeCourse(String name) {
        Select sel = new Select(getElement(dropDowm));
        sel.selectByVisibleText(name);

    }

    public void selectStep(int num) {
     clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
    }

    public void selectTopic(int topNun) {
        clickOn(By.xpath("//div[@class='topics']//*[contains(text(), '" + topNun + "')]"));
    }
}
