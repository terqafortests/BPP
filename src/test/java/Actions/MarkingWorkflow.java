package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.MainClass;

import java.util.List;

/**
 * Created by roma on 10/9/15.
 */
public class MarkingWorkflow extends MainClass {

    public static void lockSubmission() {
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Log in"));
        clickOn(By.linkText("CAS users"));
        enterText(By.id("username"), "A.CoachIII");
        enterText(By.id("password"), "Co121514");
        clickOn(By.name("submit"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Ach Ladder (fusion)"));
        clickOn(By.linkText("Roma Test Course 1"));
        selectStep(8);
        clickOn(By.xpath("//div[@class='buttons']//*[contains(text(), '" + "TAKE ASSESSMENT" + "')]"));
        clickOn(By.linkText("View/grade all submissions"));

        String name = "Calendar001 StCal001";
        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));
//        WebElement check = getElement(By.xpath("//tr/td[contains(., '" + name + "')]/preceding-sibling::td[last()]"));
//        check.click();
//        clickOn(By.xpath("//tr/td[contains(., '" + name + "')]/preceding-sibling::td[last()]"));

        sleepFor(30000);





    }

    public static void selectStep(int num) {
        clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
    }
}
