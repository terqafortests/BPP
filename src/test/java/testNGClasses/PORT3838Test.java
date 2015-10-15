package testNGClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3838Test extends MainClass {
	@Test
	public void port3838Test() {
		List<WebElement> topics = null;
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		MyLearningPage.selectStep(2);
		sleepFor(3000);
		topics = getElements(By.xpath(
				"//div[@class='wa_courseformat']/div[@class='topics']/div[contains(@class, 'topic') and contains(@class, 'selected')]"));
		Assert.assertEquals(topics.size(), 4);
	}
}
