package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyCalendarPage;
import pages.MyGroupsPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3863Test extends MainClass {
	
	@DataProvider(name = "Links")
	public static Object[][] elements() {
		return new Object[][] {{"http://bpp-fusion-test.apolloglobal.int/group/student/my-learning", MyLearningPage.helpLink, "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyLearning"},
			{"http://bpp-fusion-test.apolloglobal.int/group/student/my-calendar", MyCalendarPage.helpLink, "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyCalendar"},
			{"http://bpp-fusion-test.apolloglobal.int/group/student/my-groups", MyGroupsPage.helpLink, "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyGroups"}
				};
	}
	
	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Regression Test");
		clickOn(SelectPaperPage.open);
	}

	@Test(dataProvider = "Links")
	public void port3863MyLeHelpTest(String page, By obj, String link) {
		getPage(page);
		switchToFrame(HeaderPage.iFrame);
		clickOn(obj);
		switchToTab(1);
		assertEquals(getCurrUrl(), link);
		closeTab(1);
		switchToTab(0);
	}
}
