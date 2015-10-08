package pages;

import org.openqa.selenium.By;
import utils.MainClass;

/**
 * Created by roma on 10/8/15.
 */
public class MyLearningPage extends MainClass {



    public void selectStep(int num) {
     clickOn(By.xpath("//div[@class='step_button']//*[contains(text(), 'Step " + num + "')]"));
    }

    public void selectTopic(int topNun) {
        clickOn(By.xpath("//div[@class='topics']//*[contains(text(), '" + topNun + "')]"));
    }
}
