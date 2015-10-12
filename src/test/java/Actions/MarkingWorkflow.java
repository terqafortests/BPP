package Actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.MainClass;

/**
 * Created by roma on 10/9/15.
 */
public class MarkingWorkflow extends MainClass {

    public static By operation = By.id("id_operation");

//    lock submission and send to marker

    public static void lockSubmission(String name, String course, int step, String act) {
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Log in"));
        clickOn(By.linkText("CAS users"));
        enterText(By.id("username"), "A.CoachIII");
        enterText(By.id("password"), "Co121514");
        clickOn(By.name("submit"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Ach Ladder (fusion)"));
        clickOn(By.linkText(course));
        selectStep(step);
        clickOn(By.xpath("//div[@class='buttons']//*[contains(text(), '" + "TAKE ASSESSMENT" + "')]"));
        clickOn(By.linkText("View/grade all submissions"));
        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));
        withOperation(act);
        clickOn(By.id("id_submit"));
        Driver().switchTo().alert().accept();



        sleepFor(30000);;
    }

//    login as marker and estimate
    public static void estimate() {
        String user = "A.CoachI";
        String pass = "Co121514";

    }

    public static void withOperation(String act) {
        Select sel = new Select(getElement(operation));
        sel.selectByVisibleText(act);
    }

    public static void selectStep(int num) {
        clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
    }
}
