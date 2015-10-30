package pages;

import org.openqa.selenium.*;
import utils.MainClass;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by roma on 10/8/15.
 */
public class MyLearningPage extends MainClass {


    public static By dropDowm = By.name("select_course");
    public static By helpLink = By.id("forumhelplink");
    public static By courseName = By.xpath("//div[@class='wa_courseformat']/h1");
    public static By userDropdown = By.cssSelector(".caret");
    public static By myProfile = By.linkText("My Profile");
    public static By steps = By.xpath("//div[@class='list']//div[contains(@class, 'step_button')]");
    public static By topics = By.xpath("//div[contains(@class, 'topic')]");

    public static void changeCourse(String name) {
        Select sel = new Select(getElement(dropDowm));
        sel.selectByVisibleText(name);
        logger.log(LogStatus.PASS, "Changed course to: " + name);

    }

    public static void selectStep(int num) {
     clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
     logger.log(LogStatus.PASS, "Selected step: " + num);
    }

    public static void selectTopic(int topNum) {
        clickOn(By.xpath("//div[@class='topics']//*[contains(text(), '" + topNum + "')]"));
        logger.log(LogStatus.PASS, "Selected topic: " + topNum);
    }
    
    public static void selectActivity(int actNum) {
    	clickOn(By.xpath("//div[@class='subtopic']/div[contains(text(), '"+ actNum + "')]"));
    	logger.log(LogStatus.PASS, "Selected learning activity: " + actNum);
    }
}
