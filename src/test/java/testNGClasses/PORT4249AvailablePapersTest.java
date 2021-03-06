package testNGClasses;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT4249AvailablePapersTest extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(HeaderPage.iFrame);
	}

	@Test
	public void port4249AvailablePapersTest() {

		assertEquals(getElementText(SelectPaperPage.messageArea),
				"Below are all the papers you are currently enrolled in. Select any of them then click ‘Open’ to see the details in the ‘My Learning’ page, showing your progress to date, topics and activities relating to that paper.",
				"Verifying if actual message equals Below are all the papers you are currently enrolled in. Select any of them then click ‘Open’ to see the details in the ‘My Learning’ page, showing your progress to date, topics and activities relating to that paper.");
	}
}
