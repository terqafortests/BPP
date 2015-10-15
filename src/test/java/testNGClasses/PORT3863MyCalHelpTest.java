package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HeaderPage;
import pages.LoginPage;
import pages.MyCalendarPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3863MyCalHelpTest extends MainClass {
	@Test
	public void port3863MyCalHelpTest() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		switchToDefaultFrame();
		clickOn(HeaderPage.myCalendar);
		switchToFrame(HeaderPage.iFrame);
		clickOn(MyCalendarPage.helpLink);
		switchToTab(1);
		Assert.assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyCalendar");
	}
}
