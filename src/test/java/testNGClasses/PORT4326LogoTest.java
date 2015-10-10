package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT4326LogoTest extends MainClass {
	@Test
	public void port4326LogoTest() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
		Assert.assertEquals(getElementAtt(LoginPage.bppEduLogo, "src"),
				"https://bpp-test.apolloglobal.int/ncas/themes/bpp/images/bpp-professional-logo.png");
		Assert.assertEquals(getElementAtt(LoginPage.bppUniLogo, "src"),
				"https://bpp-test.apolloglobal.int/ncas/themes/bpp/images/bpp-university-logo.png");

	}
}
