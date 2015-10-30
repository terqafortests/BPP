package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3839Test extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Created by Roma");
		clickOn(SelectPaperPage.open);
		logger.log(LogStatus.PASS, "Clicked on login button");
	}

	@Test
	public void port3839Test() {
		MyLearningPage.selectStep(1);
		MyLearningPage.selectTopic(1);
		switchToFrame("iframe-layout-instance");
		MyLearningPage.selectActivity(1);
		assertTrue(getElement(By.xpath("//div[contains(@id, 'activity-list')]//li")).isDisplayed(),
				"Verifying if activity is displayed");
	}
}
