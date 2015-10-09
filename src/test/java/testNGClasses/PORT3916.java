package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3916 extends MainClass {
	@Test
	public void port3916() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		MyLearningPage.changeCourse("AZ Course 01");
		Assert.assertEquals(getElement(MyLearningPage.courseName).getText(), "AZ Course 01");
	}
}
