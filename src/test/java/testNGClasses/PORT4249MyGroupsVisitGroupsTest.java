package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HeaderPage;
import pages.LoginPage;
import pages.MyGroupsPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT4249MyGroupsVisitGroupsTest extends MainClass {
	@Test
	public void port4249MyGroupsVisitGroupsTest() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		switchToDefaultFrame();
		clickOn(HeaderPage.myGroups);
		switchToFrame(HeaderPage.iFrame);
		Assert.assertEquals(getElementText(MyGroupsPage.mainContent),
				"To visit any of the groups you currently belong to, simply click the relevant title below.");
	}
}
