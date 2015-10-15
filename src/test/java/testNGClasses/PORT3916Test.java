package testNGClasses;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3916Test extends MainClass {
	@Test
	public void port3916Test() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		MyLearningPage.changeCourse("AZ Course 01");
		Assert.assertEquals(getElementText(MyLearningPage.courseName), "AZ Course 01");
	}
}
