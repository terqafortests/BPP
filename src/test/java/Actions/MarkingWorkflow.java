package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.Select;
import utils.MainClass;


/**
 * Created by roma on 10/9/15.
 */
public class MarkingWorkflow extends MainClass {

    public static By operation = By.id("id_operation");

    public void estimeteStudent(String name, String course, int step, String act, String secAct, String courseGroup, String activ) {

        /**
         * name - student name
         * course - needed course
         * step - number of step
         * lock - action (lock submission)
         * unlock - action (unlock submission)
         * courseGroup - course category
         * */

        lockSubmission(name, course, step, act, courseGroup, activ);
        estimate(name, course, step, activ);
        unlockSubmission(name, course, step, secAct,  courseGroup, activ);

    }

//    lock submission and send to marker

    public void lockSubmission(String name, String course, int step, String act, String courseGroup, String activ) {

        String markerName = "AlexN CoachI";
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Log in"));
        clickOn(By.linkText("CAS users"));
        enterText(By.id("username"), "A.CoachIII");
        enterText(By.id("password"), "Co121514");
        clickOn(By.name("submit"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Ach Ladder (fusion)"));
        clickOn(By.linkText("All courses"));
        clickOn(By.linkText(courseGroup));
        clickOn(By.linkText(course));
        selectStep(step);

        clickOn(By.xpath("//div[@class='activities']//*[contains(text(), '"+ activ +"')]"));

        clickOn(By.xpath("//div[@class='buttons']//*[contains(text(), '" + "TAKE ASSESSMENT" + "')]"));
        clickOn(By.linkText("View/grade all submissions"));
        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));
        withOperation(act);
        clickOn(By.id("id_submit"));

        if (isAlertPres() == true)
            Driver().switchTo().alert().accept();

        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));
        setMarker();
        clickOn(By.id("id_submit"));

        if (isAlertPres() == true)
            Driver().switchTo().alert().accept();

        sleepFor(5000);

        selectMarker(markerName);
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("BPP generic"));
        clickOn(By.linkText("AlexNIII CoachIII"));
        clickOn(By.linkText("Log out")); // Not sure
        sleepFor(5000);
    }

//    login as marker and estimate
    public void estimate(String name, String course, int step, String activ) {
        String user = "A.CoachI";
        String pass = "Co121514";
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");

        clickOn(By.linkText("Log in"));
        clickOn(By.linkText("CAS users"));
        enterText(By.id("username"), user);
        enterText(By.id("password"), pass);
        clickOn(By.name("submit"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Ach Ladder (fusion)"));
        clickOn(By.linkText(course));
        selectStep(step);

        clickOn(By.xpath("//div[@class='activities']//*[contains(text(), '"+ activ +"')]"));

        clickOn(By.linkText(activ));
        clickOn(By.xpath("//div[@class='buttons']//*[contains(text(), '" + "TAKE ASSESSMENT" + "')]"));
        clickOn(By.linkText("View/grade all submissions"));
        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));
        changeSubmission(name);
        enterText(By.xpath("//tr/td[contains(., '" + name + "')]/following-sibling::td[3]/input[@class='quickgrade']"), "50");
        clickOn(By.id("id_savequickgrades"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("BPP generic"));
        clickOn(By.linkText("AlexN CoachI"));
        clickOn(By.linkText("Log out")); // Not sure
    }

    public void unlockSubmission(String name, String course, int step, String secAct, String courseGroup, String activ) {
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Log in"));
        clickOn(By.linkText("CAS users"));
        enterText(By.id("username"), "A.CoachIII");
        enterText(By.id("password"), "Co121514");
        clickOn(By.name("submit"));
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("Ach Ladder (fusion)"));
        clickOn(By.linkText("All courses"));
        clickOn(By.linkText(courseGroup));
        clickOn(By.linkText(course));
        selectStep(step);

        clickOn(By.xpath("//div[@class='activities']//*[contains(text(), '"+ activ +"')]"));

        clickOn(By.linkText(activ));
        clickOn(By.xpath("//div[@class='buttons']//*[contains(text(), '" + "TAKE ASSESSMENT" + "')]"));
        clickOn(By.linkText("View/grade all submissions"));
        clickOn(By.xpath("//tr/td[contains(., 'Select " + name + "')]/input[@name='selectedusers']"));

        Select select = new Select(getElement(By.xpath("//tr/td[contains(., '" + name + "')]/following-sibling::td[2]/select")));
        select.selectByValue("Released");

        withOperation(secAct);
        clickOn(By.id("id_submit"));
        if (isAlertPres() == true)
            Driver().switchTo().alert().accept();
        getPage("http://bpp-fusion-test.apolloglobal.int/vle/");
        clickOn(By.linkText("BPP generic"));
        clickOn(By.linkText("AlexNIII CoachIII"));
        clickOn(By.linkText("Log out")); // Not sure
        sleepFor(5000);
    }

    public static void selectMarker(String markerName) {
        Select select = new Select(getElement(By.xpath("//div[@class='felement fselect']/select[@name='allocatedmarker']")));
        select.selectByVisibleText(markerName);
        clickOn(By.id("id_submitbutton"));
    }

    public static void changeSubmission(String name) {

        Select select = new Select(getElement(By.xpath("//tr/td[contains(., '" + name + "')]/following-sibling::td[2]/select")));
        select.selectByValue("readyforreview");
    }

    public static void setMarker() {
        Select select = new Select(getElement(operation));
        select.selectByVisibleText("Set allocated marker");
    }

    public static void withOperation(String act) {
        Select sel = new Select(getElement(operation));
        sel.selectByVisibleText(act);
    }

    public static void selectStep(int num) {
        clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
    }


    public boolean isAlertPres() {
        try {
            Driver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
