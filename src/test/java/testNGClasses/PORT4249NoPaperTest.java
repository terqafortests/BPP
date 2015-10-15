package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT4249NoPaperTest extends MainClass {
	@Test
	public void port4249NoPaperTest() {
		LoginPage.login("BP5033281", "Kp100615");
		switchToFrame(HeaderPage.iFrame);
		Assert.assertEquals(getElementText(SelectPaperPage.messageArea),
				"Sorry, there are no courses you can login to right now, this may be because the course you’ve enrolled on has either not started or expired.");
	}
}
