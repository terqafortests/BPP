package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3858 extends MainClass {
	@Test
	public void port3858() {
		LoginPage.login("BP5033287", "In100715");
		switchToFrame(SelectPaperPage.iFrame);
		Assert.assertTrue(getElement(SelectPaperPage.messageArea).getText()
				.equals("You are currently not enrolled in any courses at this time")
				|| getElement(SelectPaperPage.messageArea).getText().equals(
						"You are currently enrolled in one or more courses that have not started. Please log back in when your course is scheduled to start."));

	}
}
