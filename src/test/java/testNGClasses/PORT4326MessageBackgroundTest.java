package testNGClasses;

import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.MainClass;

public class PORT4326MessageBackgroundTest extends MainClass {
	@Test
	public void port4326MessageBackgroundTest() {
		getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
		Calendar time = Calendar.getInstance();
		int hour = time.get(Calendar.HOUR_OF_DAY);
		if ((hour >= 12) & (hour < 18)) {
			Assert.assertEquals(getElementAtt(LoginPage.backgroundImage, "class"), "container afternoon");
			Assert.assertEquals(getElementText(LoginPage.message), "Good Afternoon");
		} else if ((hour >= 18) & (hour < 24)) {
			Assert.assertEquals(getElementAtt(LoginPage.backgroundImage, "class"), "container evening");
			Assert.assertEquals(getElementText(LoginPage.message), "Good Evening");
		} else if (hour < 12) {
			Assert.assertEquals(getElementAtt(LoginPage.backgroundImage, "class"), "container morning");
			Assert.assertEquals(getElementText(LoginPage.message), "Good Morning");
		}
	}
}
