package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PORT3836NeedHelpTest extends MainClass {

	@DataProvider(name = "Links")
	public static Object[][] elements() {
		return new Object[][] { { "http://bpp-fusion-test.apolloglobal.int/group/student/my-learning", "Privacy policy", "www.bpp.com/privacy" },
				{ "http://bpp-fusion-test.apolloglobal.int/group/student/my-calendar", "Accessibility", "http://www.bpp.com/help/l/help" },
				{ "http://bpp-fusion-test.apolloglobal.int/group/student/my-groups", "Terms & conditions", "http://www.bpp.com/terms" } };
	}

	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		logger.log(LogStatus.PASS, "Clickod on login button");
	}

	@Test(dataProvider = "Links")
	public void port3836NeedHelpPapersTest(String address1, String link, String address) {
		getPage(address1);
		switchToFrame(HeaderPage.iFrame);
		clickOn(By.linkText("Need Help"));
		logger.log(LogStatus.PASS, "Clicked on Need Help link from " + address1 + " page");
		switchToTab(1);
		clickOn(By.linkText(link));
		logger.log(LogStatus.PASS, "Clicked on " + link + " from Help page");
		switchToTab(2);
		assertEquals(getCurrUrl(), address, "Verifyong if actual current addres equals: " + address);
		closeTab(2);
		closeTab(1);
		switchToTab(0);
		switchToFrame(HeaderPage.iFrame);
	}
}
