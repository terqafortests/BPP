package testNGClasses;

import org.testng.annotations.Test;
import junit.framework.Assert;
import pages.LoginPage;
import pages.MyCalendarPage;
import pages.MyGroupsPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3863 extends MainClass {
	@Test
	public void port3863() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		clickOn(MyLearningPage.helpLink);
		switchToTab(1);
		Assert.assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyLearning");
		closeTab(1);

		switchToTab(0);
		clickOn(MyCalendarPage.myCalendar);
		switchToFrame(SelectPaperPage.iFrame);
		clickOn(MyCalendarPage.helpLink);
		switchToTab(1);
		Assert.assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyCalendar");
		closeTab(1);

		switchToTab(0);
		clickOn(MyGroupsPage.myGroups);
		switchToFrame(SelectPaperPage.iFrame);
		clickOn(MyGroupsPage.helpLink);
		switchToTab(1);
		Assert.assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyGroups");
		closeTab(1);
	}
}
