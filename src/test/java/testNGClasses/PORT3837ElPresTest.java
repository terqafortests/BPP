package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyCalendarPage;
import pages.SelectPaperPage;
import utils.MainClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PORT3837ElPresTest extends MainClass {
	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] { { MyCalendarPage.exportCalendar, "value", "Export calendar" },
				{ MyCalendarPage.manageSubscription, "value", "Manage subscriptions" },
				{ MyCalendarPage.preferences, "value", "Preferences" },
				{ MyCalendarPage.newEvent, "value", "New event"},
				{ MyCalendarPage.detailedViewFor, "name", "course"}};
	}
	
	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Regression Test");
		clickOn(SelectPaperPage.open);
		getPage("http://bpp-fusion-test.apolloglobal.int/group/student/my-calendar");
		switchToFrame(SelectPaperPage.iFrame);		
	}

	@Test(dataProvider = "Check elements")
	public void port3837PrefTest(By object, String att, String text ) {
		Assert.assertEquals(getElementAtt(object, att), text);		
	}
}
