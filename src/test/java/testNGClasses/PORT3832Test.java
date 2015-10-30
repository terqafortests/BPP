package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PORT3832Test extends MainClass {

	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] { { MyLearningPage.dropDowm }, { MyLearningPage.topics }, { MyLearningPage.steps } };
	}

	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		logger.log(LogStatus.PASS, "Clicked on Open button");
	}

	@Test(dataProvider = "Check elements")
	public void port3832Test(By elements) {
		assertTrue(getElement(elements).isDisplayed(), "Verifying if elements are displayed");
	}

}
