package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.SelectPaperPage;
import utils.MainClass;
import org.testng.annotations.BeforeTest;

public class PORT3817Test extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5032875", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on Open button");
		getPage("http://bpp-fusion-test.apolloglobal.int/group/student/my-profile");
	}

	@Test
	public void port3817Test() {
		assertEquals(getElementText(MyProfilePage.alertMessage),
				"If you'd like to update your profile details, please contact the Student Management Centre by calling 0330 060 3200.",
				"Verifying if actual message equals:  If you'd like to update your profile details, please contact the Student Management Centre by calling 0330 060 3200. ");
	}

}
