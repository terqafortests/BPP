package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3833LogoutTest extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on Open button");
	}

	@Test
	public void port3833LogoutTest() {
		switchToDefaultFrame();
		clickOn(MyLearningPage.userDropdown);
		clickOn(By.linkText("Logout"));
		assertEquals(getCurrUrl(),
				"https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm",
				"Verify if user successfully loged out");
	}
}
