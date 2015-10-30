package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT3833LoginTest extends MainClass {

	@Test
	public void port3833LoginTest() {
		LoginPage.login("BP5032875", "Ak081915");
		assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student",
				"Verifying if current url matches http://bpp-fusion-test.apolloglobal.int/group/student");

	}

}
