package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyGroupsPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT4249MyGroupsVisitGroups extends MainClass {
	@Test
	public void port4249MyGroupsVisitGroups() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		clickOn(MyGroupsPage.myGroups);
		Assert.assertEquals(getElement(MyGroupsPage.mainContent).getText(),
				"To visit any of the groups you currently belong to, simply click the relevant title below.");
	}
}
