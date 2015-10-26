package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT4326LogoTest extends MainClass {

	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] {
				{ LoginPage.bppEduLogo, "src",
						"https://bpp-test.apolloglobal.int/ncas/themes/bpp/images/bpp-professional-logo.png" },
				{ LoginPage.bppUniLogo, "src",
						"https://bpp-test.apolloglobal.int/ncas/themes/bpp/images/bpp-university-logo.png" } };
	}

	@BeforeTest
	public void preCon() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
	}

	@Test(dataProvider = "Check elements")
	public void port4326LogoTest(By obj, String att, String expected) {
		assertEquals(getElementAtt(obj, att), expected, "Veryfying if there is right logo on the page");
	}
}
