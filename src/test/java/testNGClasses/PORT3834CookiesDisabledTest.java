package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT3834CookiesDisabledTest extends MainClass {

	@Test
	public void port3834InvDataTest() {
		LoginPage.login("BP5033287", "In100715");
		assertEquals(getElementText(LoginPage.errSection),
				"The content in this not-found page can be managed by the content admin user.",
				"Verifying if actual message equals: The content in this not-found page can be managed by the content admin user.");
	}
}
