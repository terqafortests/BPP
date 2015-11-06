package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyCalendarPage;
import pages.SelectPaperPage;
import utils.MainClass;
import org.openqa.selenium.By;
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
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Regression Test");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on Open button");
		getPage("http://bpp-fusion-test.apolloglobal.int/group/student/my-calendar");
		switchToFrame(HeaderPage.iFrame);		
	}

	@Test(dataProvider = "Check elements")
	public void port3837PrefTest(By object, String att, String text ) {
		assertEquals(getElementAtt(object, att), text, "Veryfiying if " + text + "mathces text in button...");
	}
}
