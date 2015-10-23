package testNGClasses;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3858Test extends MainClass {
	@Test
	public void port3858Test() {
		LoginPage.login("BP5033287", "In100715");
		switchToFrame(HeaderPage.iFrame);
		assertTrue(getElementText(SelectPaperPage.messageArea)
				.equals("You are currently not enrolled in any courses at this time")
				|| getElementText(SelectPaperPage.messageArea).equals(
						"You are currently enrolled in one or more courses that have not started. Please log back in when your course is scheduled to start."));

	}
}
