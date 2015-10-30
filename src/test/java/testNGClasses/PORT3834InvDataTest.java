package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT3834InvDataTest extends MainClass {

	@Test
	public void port3834InvDataTest() {
		LoginPage.login("BP5033287", "In10071ss");
		assertEquals(getElementText(LoginPage.errSection),
				"Your username and password do not match our records. Please try again.",
				"Verifying if actual message equals: Your username and password do not match our records. Please try again.");
	}
}
