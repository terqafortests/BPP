package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;
import org.testng.annotations.BeforeTest;

public class PORT4445Test extends MainClass {

	@BeforeTest
	public void beforeTest() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
	}

	@Test
	public void port4445Test() {
		assertEquals(getElementText(LoginPage.signInMessage), "Please sign into your learning environment",
				"Verifying if actual message equals: Please sign into your learning environment");
	}

}
