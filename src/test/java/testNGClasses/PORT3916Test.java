package testNGClasses;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3916Test extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on Login button");
	}

	@Test
	public void port3916Test() {
		MyLearningPage.changeCourse("AZ Course 01");
		assertEquals(getElementText(MyLearningPage.courseName), "AZ Course 01", "Verifying if changed step equals: AZ Course 01");
	}
}
