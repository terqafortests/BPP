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

public class PORT3836NeedHelpPapersTest extends MainClass {

	@DataProvider(name = "Links")
	public static Object[][] elements() {
		return new Object[][] { { "Privacy policy", "http://www.bpp.com/privacy" },
				{ "Accessibility", "http://www.bpp.com/help/l/help" },
				{ "Terms & conditions", "http://www.bpp.com/terms" } };
	}

	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
	}

	@Test(dataProvider = "Links")
	public void port3836NeedHelpPapersTest(String link, String address) {
		clickOn(SelectPaperPage.needHelp);
		Logger().log(LogStatus.PASS, "Clicked on Need Help link from Available papers page");
		switchToTab(1);
		clickOn(By.linkText(link));
		Logger().log(LogStatus.PASS, "Clicked on " + link + " from Help page");
		switchToTab(2);
		assertEquals(getCurrUrl(), address, "Verifyong if actual current addres equals: " + address);
		closeTab(2);
		closeTab(1);
		switchToTab(0);
		switchToFrame(HeaderPage.iFrame);
	}
}
