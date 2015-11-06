package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3854Test extends MainClass {
	@Test
	public void port3854Test() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on login button");
		assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student",
				"Verifying if student is redirected to: http://bpp-fusion-test.apolloglobal.int/group/student");
	}
}
