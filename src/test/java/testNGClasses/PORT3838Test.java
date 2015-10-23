package testNGClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3838Test extends MainClass {

	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 7 }, { 5, 8 }, { 6, 8 } };
	}

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5032875", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
	}

	@Test(dataProvider = "Check elements")
	public void port3838Test(int stepNum, int stepCount) {
		List<WebElement> topics = null;
		MyLearningPage.selectStep(stepNum);
		sleepFor(3000);
		topics = getElements(By.xpath(
				"//div[@class='wa_courseformat']/div[@class='topics']/div[contains(@class, 'topic') and contains(@class, 'selected')]"));
		assertEquals(topics.size(), stepCount);
	}
}
